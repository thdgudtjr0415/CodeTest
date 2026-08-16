package programmers.level2.Day04;

// 피보나치 수 순서
// 0, 1, 1, 2, 3, 5, 8, 13, 21
// f(n) = f(n-1) + f(n-2)

public class 피보나치수 {
    public int solution(int n) {
        int answer = 0;
        int beforeTwo = 0;
        int beforeOne = 1;
        // n이 0일때랑 1일때는 의미 없음
        if(n == 0) return 0;
        if(n == 1) return 1;
        for(int i = 2; i <= n; i++){
            int currentNum = (beforeTwo + beforeOne) % 1234567;
            beforeTwo = beforeOne;
            beforeOne = currentNum;
            answer = currentNum;
        }
        return answer;
    }
    public static void main(String[] args) {
        피보나치수 s = new 피보나치수();
        System.out.println(s.solution(3)); //2
        System.out.println(s.solution(5)); //5
    }
}
