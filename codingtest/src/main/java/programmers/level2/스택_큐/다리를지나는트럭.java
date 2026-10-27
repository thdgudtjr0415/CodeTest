package programmers.level2.스택_큐;

import java.util.ArrayDeque;
import java.util.Queue;

class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0 ; i < bridge_length; i++) queue.offer(0);
        int timeCount = 0;
        int idx = 0;
        int totalWeight = 0; // 초기에 큐를 0으로 채워서 이제 offer 할때마다 무게 갱신
        while(idx <= truck_weights.length-1){
            int truckOutWeight = queue.poll();
            totalWeight -= truckOutWeight;
            if(weight >= totalWeight + truck_weights[idx]){
                queue.offer(truck_weights[idx]);
                totalWeight += truck_weights[idx];
                idx++;
            }else if(weight < totalWeight + truck_weights[idx]){
                queue.offer(0);
            }
            timeCount++;
        }
        // while 이 끝나면 마지막 인덱스라는 것을 인지
        // 마지막 인덱스가 bridge에 올라오면 + bridge_length 만큼 더하고 종료
        timeCount+=bridge_length;
        return timeCount;
    }

    public static void main(String[] args){
        다리를지나는트럭 s = new 다리를지나는트럭();
        System.out.println(s.solution(2, 10, new int[]{7,4,5,6})); // 8
        System.out.println(s.solution(100, 100, new int[]{10})); // 101
        System.out.println(s.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10})); // 110
    }
}
