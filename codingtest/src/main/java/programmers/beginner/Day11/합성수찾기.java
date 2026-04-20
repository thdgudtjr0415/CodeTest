package programmers.beginner.Day11;

/*
* 약수의 개수가 세 개 이상인 수를 합성수라고 합니다.
* 자연수 n이 매개변수로 주어질 때 n이하의 합성수의 개수를
* return하도록 solution 함수를 완성해주세요.
* */

// 풀이 접근 방법
// 1~n 까지 반복해서 각 숫자에 약수를 찾는데 약수는 나누어 떨어지는 수를 말함 즉 4라고 하면 1,2,4 가 약수
// 약수가 3개 이상을 찾는건데 찾으면 count++ 해주면 될듯

public class 합성수찾기 {
    public int solution(int n) {
        int result = 0;

        // 1~n 까지 반복
        for (int i = 1; i <= n; i++) {
            // 합성수 3개인걸 찾기 위해서 변수 하나 지정
            int a = 0;
            // n안에서의 수들중에 약수가 되는 것들 찾기 그런데 합성수 3개를 찾기 위해서 ++ 해주기
            for(int j = 1; j <= i; j++) {
                if(i % j == 0) {
                    a += 1;
                }
            }
            // 마지막으로 지정해줬던 a가 3개 이상이면 최종적으로 result 에 ++
            if(a >= 3){
                result++;
            }
            // 그리고 다시 처음부터
        }
        return result;
    }
    public static void main(String args[]){
        합성수찾기 s = new 합성수찾기();
        System.out.println(s.solution(10)); // 5
        System.out.println(s.solution(15)); // 8
    }
}
