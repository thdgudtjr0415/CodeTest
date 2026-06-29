package programmers.level1.Day10;

public class 콜라문제 {
    public int solution(int a, int b, int n) {
        // a 빈병, b 돌려받는 콜라의수, n 처음 전체 콜라병
        int result = 0;
        int remainCola = 0;
        while(n >= a){
            // 1. 이번 턴에 마트에서 새로 돌려받을 진짜 새 콜라 수!
            int newCola = (n / a) * b;
            // 2. 마트에 기준이 안 맞아서 못 주고 남은 찌꺼기 병!
            remainCola = n % a;
            // 3. 새 콜라 누적 적립!
            result += newCola;
            // 4. 다음 턴에 쓸 총 빈 병 = 새 콜라 마시고 나온 병 + 키핑해둔 찌꺼기 병
            n = newCola + remainCola;
        }
        return result;
    }
    public static void main(String[] args){
        콜라문제 s = new 콜라문제();
        System.out.println(s.solution(2,1,20)); // 19
        System.out.println(s.solution(3,1,20)); // 9
    }
}
