package programmers.beginner.Day8;

import java.util.Arrays;

public class 배열자르기 {
    public int[] solution(int[] numbers, int num1, int num2) {
        int[] result = new int[num2-num1+1];

        for(int i = 0; i < num2-num1+1; i++){
            result[i] = numbers[i+num1];
        }

        return result;
    }
    public static void main(String[] args) {
        배열자르기 s = new 배열자르기();
        System.out.println(Arrays.toString(s.solution(new int[]{1, 2, 3, 4, 5}, 1, 3))); // 2,3,4
        System.out.println(Arrays.toString(s.solution(new int[]{1,3,5},1,2))); // 3,5
    }
}
