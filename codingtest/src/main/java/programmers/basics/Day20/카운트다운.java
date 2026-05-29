package programmers.basics.Day20;

import java.util.Arrays;

public class 카운트다운 {
    public int[] solution(int start_num, int end_num) {
        int[] result = new int[start_num - end_num + 1];
        for (int i = 0; i <= start_num - end_num; i++) {
            result[i] = start_num - i;
        }
        return result;
    }
    public static void main(String[] args){
        카운트다운 s = new 카운트다운();
        System.out.println(Arrays.toString(s.solution(10, 3))); //10,9,8,7,6,5,4,3
    }
}
