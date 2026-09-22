package programmers.basics;

//문제: 재귀로 팩토리얼 구하기
//정수 n이 주어질 때, 재귀 함수를 사용해서 n!(n 팩토리얼, 1×2×3×...×n)을 구하는 메서드 factorial(int n)을 작성하세요.
//조건:
//for문이나 while문을 쓰지 않고, 오직 재귀 호출만으로 구해야 해요.
//n이 0이 되면(더 곱할 게 없으면) 재귀를 멈춰야 해요.
//factorial(4)
// 결과: 24  (1×2×3×4)
//factorial(1)
// 결과: 1
//factorial(0)
// 결과: 1  (0!은 정의상 1이에요)
public class 재귀_팩토리얼 {
    public int factorial(int n) {
        if(n==0){
            return 1;
        }
        int rest = factorial(n-1);
        return n * rest;
    }
    public static void main(String[] args){
        재귀_팩토리얼 s = new 재귀_팩토리얼();
        System.out.println(s.factorial(4));
        System.out.println(s.factorial(1));
        System.out.println(s.factorial(0));
    }
}
