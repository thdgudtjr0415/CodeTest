package programmers.beginner.Day23;

public class 종이자르기 {
    public int solution(int M, int N) {
        int result = 0;
        int n = N;

        while(M > 1){
            M -= 1;
            n +=N;
        }
        result = n-1;
        return result;

        // 사실 (N*M) -1 하면 끝나는 문제..... 다만 1x1일 상황에만 가능한 거라 주의하기
    }
    public static void main(String[] args) {
        종이자르기 s = new 종이자르기();
        System.out.println(s.solution(2,2)); //3
        System.out.println(s.solution(2,5)); //9
        System.out.println(s.solution(1,1)); //0
    }
}
