package programmers.beginner.Day16;

public class 자릿수더하기 {
    public int solution(int n) {
        int result = 0;
        String[] num = String.valueOf(n).split("");
        for (int i = 0; i < num.length; i++) {
            result += Integer.parseInt(num[i]);
        }

        return result;
    }
    public static void main(String[] args) {
        자릿수더하기 s = new 자릿수더하기();
        System.out.println(s.solution(1234)); // 10
        System.out.println(s.solution(930211)); // 16

    }
}