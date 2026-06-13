package programmers.basics.Day32;

public class 문자열정수의합 {
    public int solution(String num_str) {
        int result = 0;
        for(int i = 0; i < num_str.length(); i++) {
            int num = Integer.parseInt(String.valueOf(num_str.charAt(i)));
            result  += num;
        }
        return result;
    }
    public static void main(String[] args) {
        문자열정수의합 s = new 문자열정수의합();
        System.out.println(s.solution("123456789"));
        System.out.println(s.solution("1000000"));
    }
}
