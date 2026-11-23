package programmers.level2.문자열;

// 균형잡힌 괄호 문자열 -> (,) 개수가 같음
// 올바른 괄호 문자열 -> 짝도 맞아야함

import java.util.Stack;

public class 괄호변환 {
    public String solution(String p) {
        if(p.isBlank()) return "";
        // 첫 검사 올바른 괄호 인지, 시간 아끼기
        boolean check = isCorrect(p);
        if(check) return p;
        // 올바른 괄호 가 아니라면 u, v 로 나누기
        return convert(p);
    }

    private String convert(String s) {
        if(s.isBlank()) return "";
        String u = ""; String v = "";
        int open = 0; int close = 0;
        for(int i = 0; i < s.length(); i++){
            char openClose = s.charAt(i);
            switch (openClose){
                case '(' : open++; break;
                case ')' : close++; break;
            }
            if(open == close) {
                u = s.substring(0, i+1);
                v = s.substring(i+1);
                break;
            }
        }

        if(isCorrect(u)) return u + convert(v);
        StringBuilder sb = new StringBuilder();
        sb.append("(" + convert(v) + ")");
        // u 맨앞, 맨 뒤 자르고 뒤집기
        u = u.substring(1, u.length()-1);
        for(int i = 0; i < u.length(); i++){
            char word = u.charAt(i);
            if(word == '(') {
                word = ')';
            }else {
                word = '(';
            }
            sb.append(word);
        }
        return sb.toString();
    }

    // 올바른 괄호 문자열
    private boolean isCorrect(String s) {
        // 어짜피 (랑 ) 밖에 없으니까 +1, -1 로 처리 가능할듯
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char word = s.charAt(i);
            if(word == '(') count++;
            if(word == ')') count--;
            if(count == -1) return false;
        }
//        if(count == 0) return true;
//        return false;
        return count == 0; // 0이면 true, 아니면 false
    }

    // 올바른 괄호 문자열
    private boolean isCorrect_ver0(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char word = s.charAt(i);
            if(stack.isEmpty() && word == ')') return false;
            if(!stack.isEmpty() && stack.peek() == '(' && word == ')'){
                stack.pop();
            }else {
                stack.push(word);
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }

    public static void main(String[] args) {
        괄호변환 s = new 괄호변환();
        System.out.println(s.solution("(()())()")); // (()())()
        System.out.println(s.solution(")(")); // ()
        System.out.println(s.solution("()))((()")); // ()(())()
        System.out.println(s.solution(")()(")); //(())
        System.out.println(s.solution("))((")); // ()()
    }
}
