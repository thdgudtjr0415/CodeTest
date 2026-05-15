package programmers.basics.Day09;

import java.util.Arrays;

public class 카운트업 {
    public int[] solution(int start_num, int end_num) {
        int[] result = new int[end_num - start_num + 1];

        for(int i = 0; i < result.length; i++){
            result[i] = start_num + i;
        }

        return result;
    }
    public static void main(String[] args) {
        카운트업 s = new 카운트업();
        System.out.println(Arrays.toString(s.solution(3, 10))); // 3,4,5,6,7,8,9,10
    }
}
