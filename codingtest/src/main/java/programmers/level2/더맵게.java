package programmers.level2;

// heap 이란
// 자바에서는 힙을 직접 구현할 필요 없이 PriorityQueue<Integer>를 쓰면 됨
// PriorityQueue는 기본적으로 최소힙(min heap) - 값이 가장 작은 원소가 항상 poll()로 먼저 나옴
// new PriorityQueue<>() 로 생성, offer(값) 또는 add(값)으로 삽입, poll()로 최솟값 꺼내면서 동시에 제거
// peek()은 꺼내지 않고 최솟값만 확인할 때 사용

// 진행 방식
// 1. scoville 배열의 모든 값을 PriorityQueue에 offer로 다 집어넣음
// 2. poll()로 가장 작은 값을 꺼내서 K 이상이면 종료 (더 섞을 필요 없음)
// 3. K보다 작으면 poll()을 한번 더 해서 두 번째로 작은 값도 꺼냄
// 4. 두 값을 "가장 작은 값 + 가장 큰 값*2" 공식으로 섞은 새 값을 만들어 다시 offer로 넣음
// 5. 섞은 횟수를 카운트하면서 2~4를 반복
// 6. 큐에 원소가 1개만 남았는데 그 값도 K보다 작으면 더 섞을 수 없으므로 -1 반환

import java.util.PriorityQueue;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) minHeap.offer(scoville[i]);
        int count = 0;
        while(minHeap.peek() < K){
            if(minHeap.size() == 1){
                return -1;
            }
            int num1 = minHeap.poll();
            int num2 = minHeap.poll();
            int sum = num1 + (num2 * 2);
            minHeap.offer(sum);
            count++;
        }
        return count;
    }
    public static void main(String[] args){
        더맵게 s = new 더맵게();
        System.out.println(s.solution(new int[]{1,2,3,9,10,12}, 7)); // 2
    }
}
