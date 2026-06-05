package programmers.basics.Day25;

import java.util.Arrays;

public class 수열과구간쿼리_01 {
    public int[] solution(int[] arr, int[][] queries) {
        int[] result = arr.clone();
        for(int i=0;i<queries.length;i++){
            int first = queries[i][0];
            int second = queries[i][1];
            for(int j=first;j<=second;j++){
                result[j]++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        수열과구간쿼리_01 s = new 수열과구간쿼리_01();
        System.out.println(Arrays.toString(s.solution(new int[]{0,1,2,3,4},
                new int[][]{{0,1},{1,2},{2,3}}))); //1,3,4,4,4
    }
}
