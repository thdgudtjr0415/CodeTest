package programmers.basics.Day27;

public class 소문자로바꾸기 {
    public String solution(String myString) {
        return myString.toLowerCase();
    }
    public static void main(String[] args) {
        소문자로바꾸기 s = new 소문자로바꾸기();
        System.out.println(s.solution("aBcDeFg"));
        System.out.println(s.solution("aaa"));
    }
}
