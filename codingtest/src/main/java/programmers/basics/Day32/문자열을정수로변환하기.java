package programmers.basics.Day32;

public class 문자열을정수로변환하기 {
    public int solution(String n_str) {
        int result = Integer.parseInt(n_str);
        return result;
    }
    public static void main(String[] args) {
        문자열을정수로변환하기 s =new 문자열을정수로변환하기();
        System.out.println(s.solution("10"));
        System.out.println(s.solution("8542"));
    }
}
