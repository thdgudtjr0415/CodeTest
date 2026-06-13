package programmers.basics.Day33;

public class 문자열로변환 {
    public String solution(int n) {
        String result = n+"";
        return result;
    }
    public static void main(String[] args) {
        문자열로변환 s = new 문자열로변환();
        System.out.println(s.solution(123));
        System.out.println(s.solution(2573));
    }
}
