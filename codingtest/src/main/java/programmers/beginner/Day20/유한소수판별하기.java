package programmers.beginner.Day20;

public class 유한소수판별하기 {
    public int solution(int a, int b) {
        int result = 0;
        // 여기가 최대 공약수
        int gcd = GCD(a, b);
        int target = b / gcd;
        // 여기서 소인수 즉 2나 5로 나뉠수 있는가 를 판별
        while(target % 2 == 0) {
            target /= 2;
        }
        while(target % 5 == 0) {
            target /= 5;
        }

        // 그래서 2랑 5를 끝까지 나눴으니 나머지가 1이라면 유한소수 아니면 2 무한소수
        if(target == 1) {
            result = 1;
        }else{
            result = 2;
        }
        return result;
    }
    // 유클리드 호재법 잘 알아두기
    public int GCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        유한소수판별하기 s = new 유한소수판별하기();
        System.out.println(s.solution(7, 20)); // 1
        System.out.println(s.solution(11, 22)); // 1
        System.out.println(s.solution(12, 21)); // 2
    }
}
