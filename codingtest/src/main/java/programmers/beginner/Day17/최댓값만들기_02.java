package programmers.beginner.Day17;


public class 최댓값만들기_02 {
    public int solution(int[] numbers) {
        // 여기서 주의할 점. 문제에서는 두수의 곱이 제일 큰 것을 찾으라고 했는데
        // result를 0으로 초기화 해버리면 이게 제일 클수도 있음 그래서 문제가 말한 답이 아니기 때문에
        // 0으로 초기화 하지 말고 인덱스0,1 두개를 곱한 것을 처음으로 셋팅해야함
        int result = numbers[0] * numbers[1];
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                if(numbers[i]*numbers[j] > result) {
                    result = numbers[i]*numbers[j];
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        최댓값만들기_02 s = new 최댓값만들기_02();
        System.out.println(s.solution(new int[]{1, 2, -3, 4, -5})); //15
        System.out.println(s.solution(new int[]{0, -31, 24, 10, 1, 9})); //240
        System.out.println(s.solution(new int[]{10, 20, 30, 5, 5, 20, 5})); //600
    }
}
