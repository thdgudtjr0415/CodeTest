package programmers.level1.Day03;

public class 없는숫자더하기 {
    public int solution(int[] numbers) {
        int result = 0;
        int sum = 0;
        for(int i = 0; i < numbers.length; i++){
            sum += numbers[i];
        }
        result = 45 - sum;
        return result;
    }
    public static void main(String[] args){
        없는숫자더하기 s = new 없는숫자더하기();
        System.out.println(s.solution(new int[]{1,2,3,4,6,7,8,0})); // 14
        System.out.println(s.solution(new int[]{5,8,4,0,6,7,9})); // 6
    }
}
