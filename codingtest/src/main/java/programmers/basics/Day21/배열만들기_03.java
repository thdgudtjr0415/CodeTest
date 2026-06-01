package programmers.basics.Day21;

import java.util.Arrays;

public class 배열만들기_03 {
    public int[] solution(int[] arr, int[][] intervals) {
        int a = intervals[0][0];
        int b = intervals[0][1];
        int c = intervals[1][0];
        int d = intervals[1][1];
        int[] result = new int[(b - a + 1) + (d - c + 1)];
        // 원래 기본 풀었던 생각
//        for(int i = a;  i <= b; i++) result[i-a] = arr[i];
//        for(int i = c;  i <= d; i++) result[(b-a+1) + i-c] = arr[i];
        int index = 0;
        for(int i = a;  i <= b; i++) result[index++] = arr[i];
        for(int i = c;  i <= d; i++) result[index++] = arr[i];
        return result;
    }
    public static void main(String[] args) {
        배열만들기_03 s = new 배열만들기_03();
        System.out.println(Arrays.toString(
                s.solution(new int[]{1,2,3,4,5}, new int[][]{{1,3},{0,4}}))); // 2,3,4,1,2,3,4,5
    }
}
