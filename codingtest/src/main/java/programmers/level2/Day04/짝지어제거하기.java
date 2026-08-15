package programmers.level2.Day04;

import java.util.Stack;

public class 짝지어제거하기 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            char c =  s.charAt(i);
            if(i == 0 || stack.isEmpty()){
                stack.push(c);
            }else if(stack.peek().equals(c)) {
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        if(stack.isEmpty()) return 1;
        return result;
    }
    public static void main(String[] args){
        짝지어제거하기 s = new 짝지어제거하기();
        System.out.println(s.solution("baabaa")); // 1
        System.out.println(s.solution("cdcd")); // 0
    }
}
