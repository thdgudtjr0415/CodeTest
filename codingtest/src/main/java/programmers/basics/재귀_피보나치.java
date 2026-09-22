package programmers.basics;

//문제: 재귀로 피보나치수 구하기
//정수 n이 주어질 때, 재귀 함수를 사용해서 n번째 피보나치수를 구하는 메서드 fibonacci(int n)을 작성하세요.
//피보나치수: 0, 1, 1, 2, 3, 5, 8, 13, ...  (앞의 두 수를 더해서 다음 수를 만듦)
//조건:
//for문이나 while문을 쓰지 않고, 오직 재귀 호출만으로 구해야 해요.
//n이 0이면 0을, n이 1이면 1을 그대로 반환해야 해요. (이 둘이 "막다른 길"이에요)
//fibonacci(0)
// 결과: 0
//fibonacci(1)
// 결과: 1
//fibonacci(6)
// 결과: 8   (0,1,1,2,3,5,8 순서에서 6번째, 0부터 세기 시작)

// f(2) = f(1) + f(0)
// f(3) = f(2) + f(1)

public class 재귀_피보나치 {
    public int fibonacci(int n) {
        int sum = 0;

        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }

        sum = fibonacci(n-1) + fibonacci(n-2);
        return sum;
    }
    public static void main(String[] args){
        재귀_피보나치 s = new 재귀_피보나치();
        System.out.println(s.fibonacci(0));
        System.out.println(s.fibonacci(1));
        System.out.println(s.fibonacci(6));
    }
}
