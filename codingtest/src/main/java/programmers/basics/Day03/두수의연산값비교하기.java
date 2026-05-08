package programmers.basics.Day03;

public class 두수의연산값비교하기 {
    public int solution(int a, int b) {
        int result = 0;
        int ab = Integer.parseInt(a + "" + b);
        int ab2 = 2*a*b;
        result = Math.max(ab, ab2);
        return result;
    }
    public static void main(String[] args) {
        두수의연산값비교하기 s = new 두수의연산값비교하기();
        System.out.println(s.solution(2,91)); //364
        System.out.println(s.solution(91,2)); //912
    }
}
