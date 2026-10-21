package programmers.level2.스택_큐;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

// 다른 면이 막혀 있어서 맨 앞의 상자만 뺄 수 있습니다 -> 스택
// order 배열은 우리가 해야하는 순서
// 작업 순서
// 1. 1부터 차례로 배열의 길이만큼 n까지 진행
// 2. target = order[idx] 와 비교해서 i과 같다면 answer++
// 2-1. 다르다면 i을 stack에 넣음

public class 택배상자 {
    public int solution1(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        // 총 개수
        int n = order.length;
        int idx = 0;
        for(int i = 1; i <= n; i++){
            int target = order[idx];
            if(target == i){
                idx++;
                result++;
                    while(!stack.isEmpty() && idx < n && stack.peek() == order[idx]){
                        stack.pop();
                        idx++;
                        result++;
                    }
            }else {
                stack.push(i);
            }
        }
        return result;
    }

    // 의문점
    // 1. 구조를 단순하게 가능한가? 일단 스택에 넣고 판별하면 되는거 아닌가?
    // 2. 코드에서 i 이렇게 쓰면 뭔소리인지 모를 수 있으니 box같은 직관적인 변수명 쓰기
    public int solution2(int[] order) {
        Deque<Integer> stack = new ArrayDeque<>();
        int count = 0;
        int index = 0;
        for(int box = 1; box <= order.length; box++){
            stack.push(box);
            while(!stack.isEmpty() && order[index] == stack.peek()){
                index++;
                stack.pop();
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        택배상자 s = new 택배상자();
        System.out.println(s.solution2(new int[]{4,3,1,2,5})); // 2
        System.out.println(s.solution2(new int[]{5,4,3,2,1})); // 5
        // 반례
        System.out.println(s.solution2(new int[]{2,1,3})); // 3
    }
}
