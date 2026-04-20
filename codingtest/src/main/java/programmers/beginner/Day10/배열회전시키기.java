package programmers.beginner.Day10;

import java.util.Arrays;

// 정수가 담긴 배열 numbers와 문자열 direction가 매개변수로 주어집니다.
// 배열 numbers의 원소를 direction방향으로 한 칸씩 회전시킨 배열을 return하도록 solution 함수를 완성해주세요.
// 3 ≤ numbers의 길이 ≤ 20
// direction은 "left" 와 "right" 둘 중 하나입니다.

public class 배열회전시키기 {
    public int[] solution(int[] numbers, String direction) {
        int[] result = new int[numbers.length];


        if(direction.equals("right")) {
            result[0] = numbers[numbers.length-1];
            for(int i = 1; i < numbers.length; i++) {
                result[i]=numbers[i-1];
            }
        }else if(direction.equals("left")) {
            result [numbers.length-1] = numbers[0];
            for(int i = 0; i < numbers.length-1; i++) {
                result[i]=numbers[i+1];
            }
        }

        return result;
    }

    public static void main(String args[]){
        배열회전시키기 s = new 배열회전시키기();
        // [3, 1, 2]
        System.out.println(Arrays.toString(s.solution(new int[]{1, 2, 3}, "right")));

        // [455, 6, 4, -1, 45, 6, 4]
        System.out.println(Arrays.toString(s.solution(new int[]{4, 455, 6, 4, -1, 45, 6}, "left")));
    }
}
