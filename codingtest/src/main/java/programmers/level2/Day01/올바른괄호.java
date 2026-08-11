package programmers.level2.Day01;

import java.util.Stack;

public class 올바른괄호 {
    boolean solution(String s) {
        boolean answer = false;
        if(s.charAt(0) == ')') return false;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            }else if(c == ')' && !stack.isEmpty()){
                stack.pop();
            }else if(stack.isEmpty()){
                // 이걸 하는 이유는 모두 통과해서 스택이 비어있는데 또 들어온다면, 즉 ')'이게 들어왔을시에
                // 그럼 false로 반환해서 실패로 해야함
                return false;
            }
        }
        if(stack.isEmpty()) return true;
        return answer;
    }
    public static void main(String[] args){
        올바른괄호 s = new 올바른괄호();
        System.out.println(s.solution("()()"));
        System.out.println(s.solution("(())()"));
        System.out.println(s.solution(")()("));
        System.out.println(s.solution("(()("));
    }
}
