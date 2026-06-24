package programmers.level1.Day06;

import java.util.Arrays;

// 최대공약수 (GCD, Greatest Common Divisor)
// 두 개 이상의 수가 공통으로 가지고 있는 약수(나누어떨어지는 수) 중 가장 큰 수
// 최소공배수 (LCM, Least Common Multiple)
// 두 개 이상의 수의 공통된 배수(곱해서 커진 수) 중 가장 작은 수

public class 최대공약수와최소공배수 {
    public int[] solution1(int n, int m) {
        int[] answer = new int[2];
        //gcd 최대공약수, 두개이상의 수가 공통으로 가지고 있는 약수 즉 약수를 구하자
        for(int i = 1; i <= Math.min(n,m); i++){
            if(n%i==0 && m%i==0){
                answer[0]=i;
            }
        }
        int nMul = n;
        int mMul = m;
        while(nMul!=mMul){
            if(nMul>mMul){
                mMul += m;
            }else {
                nMul += n;
            }
            answer[1] = nMul;
        }
        return answer;
    }
    public int[] solution2(int n, int m) {
        int gcd = gcd(n,m);
        int lcm = (n*m) /gcd;
        return new int[]{gcd, lcm};
    }
    // 유클리드 호재법
    private int gcd(int n, int m) {
        // n,m 둘중 뭐든 상관 없는 것 왜냐하면 어짜피 %로 나누기 때문
        while(m!=0){
            int r = n % m;
            n = m;
            m = r;
        }
        return n;
    }
    // 재귀함수
    private int gcd2(int n, int m) {
        if(m==0) return n;
        else return gcd2(m,n%m);
    }

    public static void main(String[] args){
        최대공약수와최소공배수 s = new 최대공약수와최소공배수();
        System.out.println(Arrays.toString(s.solution1(3,12))); //3,12
        System.out.println(Arrays.toString(s.solution1(2,5))); //1,10

        System.out.println(Arrays.toString(s.solution2(3,12))); //3,12
        System.out.println(Arrays.toString(s.solution2(2,5))); //1,10
    }
}
