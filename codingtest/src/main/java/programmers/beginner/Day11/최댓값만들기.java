package programmers.beginner.Day11;
/*
 * 정수 배열 numbers가 매개변수로 주어집니다.
 * numbers의 원소 중 두 개를 곱해 만들 수 있는
 * 최댓값을 return하도록 solution 함수를 완성해주세요.
 */

// 여기서 sort로 정렬한 다음에 마지막 두개 곱해주면 끝일듯

import java.util.Arrays;

public class 최댓값만들기 {
    public int solution(int[] numbers) {
        int result = 0;
        // 배열 정렬해서
        Arrays.sort(numbers);
        // 마지막 2개 곱해주기
        result = numbers[numbers.length-1] * numbers[numbers.length-2];

        return result;
    }
    public static void main(String args[]){
        최댓값만들기 s = new 최댓값만들기();
        System.out.println(s.solution(new int[]{1, 2, 3, 4, 5})); //20
        System.out.println(s.solution(new int[]{0, 31, 24, 10, 1, 9})); //744
    }
}