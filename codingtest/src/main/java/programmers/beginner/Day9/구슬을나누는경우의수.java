package programmers.beginner.Day9;


// 머쓱이는 구슬을 친구들에게 나누어주려고 합니다. 구슬은 모두 다르게 생겼습니다.
// 머쓱이가 갖고 있는 구슬의 개수 balls와 친구들에게 나누어 줄 구슬 개수 share이 매개변수로 주어질 때,
// balls개의 구슬 중 share개의 구슬을 고르는 가능한 모든 경우의 수를 return 하는 solution 함수를 완성해주세요.

// balls share result
//  3	   2	 3
//  5	   3	 10

// hint 서로 다른 n개 중 m개를 뽑는 경우의 수 공식
// n! / (n-m)! * m!
// 5! = 1*2*3*4*5 =

// BigInteger  를 사용해서 풀어야할듯 여기서는 divide(), multiply()
// 이때 BigInteger -> int 로 가려면 .intValue();를 써줘야한다.

import java.math.BigInteger;

public class 구슬을나누는경우의수 {
    public int solution(int balls, int share) {
        int result = 0;
        // 여기 잘 multiply 잘 쓰기
        BigInteger a = factorial(balls);
        BigInteger b = factorial(balls - share).multiply(factorial(share));

        result = a.divide(b).intValue();

        return result;
    }

    // 여긴 n! 팩토리얼을 구하는 함수
    public BigInteger factorial(int n) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++) {
                result =  result.multiply(BigInteger.valueOf(i));
            }
        return result;
    }


    public static void main(String[] args) {
        구슬을나누는경우의수 p = new 구슬을나누는경우의수();
        System.out.println(p.solution(3,2));
        System.out.println(p.solution(5,3));
        System.out.println(p.solution(30,8));
    }
}
