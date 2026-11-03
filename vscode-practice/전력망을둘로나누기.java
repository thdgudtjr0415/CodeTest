import java.util.*;

public class 전력망을둘로나누기 {
    public int solution(int n, int[][] wires) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        // 전선의 개수는 n-1인거 기억하기
        for(int i = 0; i < n-1; i++){ 
            int one = wires[i][0];
            int two = wires[i][1];
            if(map.get(one) == null) map.put(one, new ArrayList<>());
            if(map.get(two) == null) map.put(two, new ArrayList<>());
            map.get(one).add(two);
            map.get(two).add(one);
        }
        System.out.println(map);
        int answer = n; // 일단 최대 개수부터
        // 송전탑의 개수를 세기 위한 boolean[]
        for (int i = 0; i < wires.length; i++) {
            // 끊을 전선
            int a = wires[i][0];
            int b = wires[i][1];
            boolean[] visited = new boolean[n + 1]; // 인덱스 0은 무시
            // 끊긴 전선 boolean에 표시
            visited[a] = true;
            visited[b] = true;
            // 여기서 a쪽 탑의 개수를 센다
            int count = count(a, map, visited);
            answer = Math.min(Math.abs(count - (n-count)), answer);
        }

        // 그래프 보고 싶을떄 https://edotor.net/ 에서 보기
        // viewGrahp(map, wires);

        return answer;
    }
        // 이웃을 하나씩 본다 (for)
        // 가도 되는 이웃이면 (visited가 false)
        //   1) 그 이웃에 표시하고
        //   2) 그 이웃에서 count를 다시 불러서 cnt에 더한다
    private int count(int start, Map<Integer, List<Integer>> map, boolean[] visited) {
        int cnt = 1;
        for(int next : map.get(start)){
            if(!visited[next]){
                visited[next] = true;
                cnt += count(next, map, visited);
            }
        }
        return cnt;
    }

    // 그래프 보고 싶을떄 https://edotor.net/ 에서 보기
    private void viewGrahp(Map<Integer, List<Integer>> map, int[][] wires){
            StringBuilder dot = new StringBuilder("graph { ");
            for(int[] wire : wires){
                dot.append(wire[0]).append(" -- ").append(wire[1]).append("; ");
            }
            dot.append("}");
            System.out.println(dot);
    }

    public static void main(String[] args){
        전력망을둘로나누기 s = new 전력망을둘로나누기();
        System.out.println(s.solution(
            9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}})); // 3
        System.out.println(s.solution(
            4, new int[][]{{1,2},{2,3},{3,4}})); // 0
        System.out.println(s.solution(
            7, new int[][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}})); // 1
    }
}
