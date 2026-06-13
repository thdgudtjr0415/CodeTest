package programmers.basics.Day32;

public class 정수부분 {
    public int solution(double flo) {
        int result = (int) flo;
        return result;
    }
    public static void main(String[] args) {
        정수부분 s = new 정수부분();
        System.out.println(s.solution(1.42));
        System.out.println(s.solution(69.32));
    }
}
