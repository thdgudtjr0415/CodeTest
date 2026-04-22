package programmers.beginner.Day17;

public class 세균증식 {
    public int solution(int n, int t) {
        int result = n;
        for(int i = 0; i < t; i++) {
            result *= 2;
        }
        return result;
    }
    public static void main(String[] args) {
        세균증식 s = new 세균증식();
        System.out.println(s.solution(2, 10)); // 2048
        System.out.println(s.solution(7, 15)); // 229376
    }
}
