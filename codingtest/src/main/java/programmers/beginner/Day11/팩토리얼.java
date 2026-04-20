package programmers.beginner.Day11;

/*
 *  i팩토리얼 (i!)은 1부터 i까지 정수의 곱을 의미합니다.
 *  예를들어 5! = 5 * 4 * 3 * 2 * 1 = 120 입니다.
 * 정수 n이 주어질 때 다음 조건을 만족하는 가장 큰 정수 i를 return 하도록 solution 함수를 완성해주세요.
 * i! ≤ n
 * */

public class 팩토리얼 {
    public int solution(int n) {
        // 1부터 곱해서 차례로 올라갈 꺼니까 1씩 넣어주기
        int result = 1;
        int factorial = 1;

        // whlie 써서 계속 반복해줄껀데
        // 먼저 result 에 ++ 해서 올려주고 그 나온 수를 곱해준다
        while(factorial <= n){
            result++;
            factorial *= result;
        }
        // 마지막에 while문을 탈출한 수는 false때 나오는거니까 하나 더 큰수 임 그거 감안해서 -1 해주기
        return result-1;
    }
    public static void main(String[] args) {
        팩토리얼 s = new 팩토리얼();
        System.out.println(s.solution(3628800));  //10
        System.out.println(s.solution(7));  // 3
    }
}
