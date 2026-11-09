package programmers.level2.미분류;

// N개의 마을, 1번 마을에서 K 시간 이하로 배달할 수 있는 마을만 주문을 받는다
// road의 {a, b, c}: a번 마을과 b번 마을을 잇는 양방향 도로, c는 걸리는 시간
// dist[i]: 1번 마을에서 i번 마을까지 걸리는 최소 시간

import java.util.*;

public class 배달 {
    public int solution(int N, int[][] road, int K) {
        Queue<int[]> queue = new ArrayDeque<>();
        Map<Integer, List<int[]>> map = new HashMap<>(); // key: 마을 번호, value: {이웃한 마을, 걸리는 시간}들
        for(int i = 0; i < road.length; i++){
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            int[] toB = {b, c};  // a 마을에서 b 마을까지 걸리는 시간
            int[] toA = {a, c};  // b 마을에서 a 마을까지 걸리는 시간

            if(!map.containsKey(a)) map.put(a, new ArrayList<>());
            if(!map.containsKey(b)) map.put(b, new ArrayList<>());
            map.get(a).add(toB);
            map.get(b).add(toA);
        }
        // 이웃 정보 확인용 출력
        mapView(map);
        int[] dist = new int[N+1];

        // dist를 큰 값으로 채우고, 큐에 1번 마을 {1, 0}을 넣는다
        Arrays.fill(dist, Integer.MAX_VALUE);
        queue.offer(new int[]{1,0});
        // 큐에서 {마을, 그 마을까지 걸린 시간}을 꺼낸다
        // 그 마을의 이웃으로 가는 새 시간(= 걸린 시간 + 도로 시간)이 이웃의 dist보다 작으면
        // dist를 갱신하고 그 이웃을 큐에 넣는다
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int town = cur[0];
            int time = cur[1];
            // 이부분에서 time 으로 덮어 씌우면 큰값으로 다시 될 수 있어서
            // Math.min으로 작은것 선택
            dist[town] = Math.min(dist[town] ,time);
            for(int[] neighbor : map.get(town)){
                int nextTown = neighbor[0];
                int roadTime = neighbor[1];
                int nextTime = time + roadTime;
                if(dist[nextTown] > nextTime){
                    dist[nextTown] = nextTime;
                    queue.offer(new int[]{nextTown, nextTime});
                }
            }
        }
        int answer = 0;
        // dist 중 K 이하인 마을의 개수를 센다 (0번 칸은 MAX라 세어지지 않는다)
        for(int i = 0; i < dist.length; i++){
            if(dist[i] <= K){
                answer++;
            }
        }
        return answer;
    }
    private void mapView(Map<Integer, List<int[]>> graph){
        for (int key : graph.keySet()) {
            System.out.print(key + "번 마을: ");
            for (int[] next : graph.get(key))  System.out.print(Arrays.toString(next) + " ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        배달 s = new 배달();
        System.out.println(s.solution(5, new int[][]{
                {1,2,1}, {2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}}, 3)); // 4
        System.out.println(s.solution(6, new int[][]{{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}}, 4)); // 4
    }
}
