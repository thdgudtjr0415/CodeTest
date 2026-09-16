package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

//Queue -> FIFO
//queue.offer(값);      // 맨 뒤에 추가 (= push 같은 느낌)
//queue.poll();          // 맨 앞의 것을 꺼내면서 제거 (꺼낸 값을 반환)
//queue.peek();          // 맨 앞의 것을 확인만 (제거 안 함)
//queue.isEmpty();       // 비어있는지 확인
//queue.size();          // 몇 개 들어있는지

public class 프로세스 {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        // 우선순위와 원래 인덱스를 하나로 묶어서 큐에 넣음 (따로 관리하면 순서가 어긋날 위험이 있음)
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{priorities[i], i});
        }
        int answer = 0;
        int 실행순서 = 0;
        while(!queue.isEmpty()) {
            // 1. 큐의 첫번째를 확인하기 -> 어짜피 poll로 꺼내야함 이유는 뒤로 보낼지 실행할지 두가지 경우만 있음
            int[] cur = queue.poll(); // cur[0]=우선순위, cur[1]=원래 인덱스
            // 2. 반복문 -> 이제 cur과 비교해서 큰것이 있다면 cur은 offer로 뒤로 보내고 아니면 실행
            // 3. boolean 을 사용해서 ture일 때 실행이 가능하게 체크
            boolean flag = true;
            // for-each를 사용, 일반 반복문 사용이 불가하기 때문에(이런 경우 queue, list, Stack 같은것)
            for(int[] num : queue){
                if(num[0] > cur[0]){
                    flag = false;
                    queue.offer(cur);
                    break;
                }
            }
            if(flag){
                실행순서++;
                if(cur[1] == location){
                    answer =  실행순서;
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        프로세스 s = new 프로세스();
        System.out.println(s.solution(new int[]{2,1,3,2},2)); // 1
        System.out.println(s.solution(new int[]{1,1,9,1,1,1},0)); // 5
    }
}
