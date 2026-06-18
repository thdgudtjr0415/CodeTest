package programmers.level1.Day01;

public class 자리수더하기 {
    public int solution(int n) {
        int answer = 0;
        while(n >= 1){
            answer += n%10;
            n = n/10;
        }
        return answer;
    }
    public static void main(String[] args) {
        자리수더하기 s = new 자리수더하기();
        System.out.println(s.solution(123)); //6
        System.out.println(s.solution(987)); //24
    }
}
