package programmers.level2;

import java.util.Stack;

public class 괄호회전하기 {
    public int solution1(String s) {
        int result = 0;
        int x = s.length();
        for(int i = 0; i < x; i++){
            Stack<Character> stack = new Stack<>();
            for(int j = 0; j < x; j++){
                char c = s.charAt(j);
                if(stack.isEmpty()){
                    stack.push(c);
                }else if(stack.peek() == '(' && c == ')'){
                    stack.pop();
                }else if(stack.peek() == '[' && c == ']'){
                    stack.pop();
                }else  if(stack.peek() == '{' && c == '}'){
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
            if(stack.isEmpty()){
                result++;
            }

            String s1 = s.substring(0,1);
            String s2 = s.substring(1);
            s = s2 + s1;
        }
        return result;
    }

    public int solution2(String s) {
        int result = 0;
        int x = s.length();
        for(int i = 0; i < x; i++){
            Stack<Character> stack = new Stack<>();
            for(int j = 0; j < x; j++){
                char c = s.charAt(j);
                if(j == 0 && (c == ')' || c == ']' || c == '}')){
                    stack.push(c);
                    break;
                }
                if(stack.isEmpty()){
                    stack.push(c);
                }else if(stack.peek() == '(' && c == ')'){
                    stack.pop();
                }else if(stack.peek() == '[' && c == ']'){
                    stack.pop();
                }else  if(stack.peek() == '{' && c == '}'){
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
            if(stack.isEmpty()){
                result++;
            }

            String s1 = s.substring(0,1);
            String s2 = s.substring(1);
            s = s2 + s1;
        }
        return result;
    }
    public static void main(String[] args){
        괄호회전하기 s = new 괄호회전하기();
        System.out.println(s.solution1("[](){}")); //3
        System.out.println(s.solution1("}]()[{")); //2
        System.out.println(s.solution1("[)(]")); //0
        System.out.println(s.solution1("}}}")); //0

        System.out.println(s.solution2("[](){}")); //3
        System.out.println(s.solution2("}]()[{")); //2
        System.out.println(s.solution2("[)(]")); //0
        System.out.println(s.solution2("}}}")); //0
    }
}
