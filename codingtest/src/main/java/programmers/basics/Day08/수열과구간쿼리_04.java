package programmers.basics.Day08;

import java.util.Arrays;

// 문제 잘 읽기 문제 말장난 떄문에 틀림

public class 수열과구간쿼리_04 {
    public int[] solution(int[] arr, int[][] queries) {
        int[] result = arr.clone();

        for(int i=0;i<queries.length;i++){
            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];

            for(int j = s; j <= e; j++){
                if(j % k == 0){
                    result[j] += 1;
                }
            }
        }

        return result;
    }
    public static void main(String[] args){
        수열과구간쿼리_04 s = new 수열과구간쿼리_04();
        System.out.println(Arrays.toString(s.solution(
                new int[]{0,1,2,4,3}, new int[][]{{0,4,1},{0,3,2},{0,3,3}}))); // 3,2,4,6,4
    }
}
