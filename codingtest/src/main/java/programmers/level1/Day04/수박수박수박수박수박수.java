package programmers.level1.Day04;

public class 수박수박수박수박수박수 {
    public String solution(int n) {
        String word = "수박";
        String answer = "";
        for (int i = 0; i < n; i++) {
            answer = answer + word.charAt(i%2);
        }
        return answer;
    }
    public static void main(String[] args) {
        수박수박수박수박수박수 s = new 수박수박수박수박수박수();
        System.out.println(s.solution(3));
        System.out.println(s.solution(4));
    }
}
