package programmers.level2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//나보다 나중에, 나보다 더 낮은 가격이 처음 나오는 지점까지의 거리를 구하는 문제
// 지점이 끝까지 안 나오면 배열 끝까지의 거리

public class 주식가격 {
    public int[] solution1(int[] prices){
        int n = prices.length;
        int[] answer = new int[n];

        for(int i = 0; i < n; i++){
            int cur = prices[i];
            int count = 0;
            for(int j = i+1; j < n; j++){
                count++;
                if(cur > prices[j]) break;
            }
            answer[i] = count;
        }
        return answer;
    }

    //stack.push(i) — 맨 위에 넣기 (= addFirst)
    //stack.pop() — 맨 위에서 꺼내기 (= removeFirst)
    //stack.peek() — 맨 위 값 확인만 (꺼내지 않음, = peekFirst)
    //stack.isEmpty() — 비어있는지 확인
    public int[] solution2(int[] prices){
        Deque<Integer> stack = new ArrayDeque<>();
//        Stack<Integer> stack = new Stack<>();
        int n = prices.length;
        int[] answer = new int[n];

        for(int i = 0; i < n; i++){
            // 이렇게 해놓고 이제 deque에 들어가면 알아서 이전가격이 됨
            int currPrice = prices[i];
            int count = 0;
            while(!stack.isEmpty() && currPrice < prices[stack.peek()]){
                // 꺼네는건 인덱스
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }
        // 인텔리제이상 deque는 pop하게 될때 제일 앞에꺼가 나옴
        while(!stack.isEmpty()){
            int j = stack.pop();
            answer[j] = n -1 - j;
        }
        return answer;
    }
    public static void main(String[] args){
        주식가격 s = new 주식가격();
//        System.out.println(Arrays.toString(s.solution1(new int[]{1,2,3,2,3}))); //4,3,1,1,0
        System.out.println(Arrays.toString(s.solution2(new int[]{1,2,3,2,3}))); //4,3,1,1,0
    }
}
