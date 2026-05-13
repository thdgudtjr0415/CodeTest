package programmers.basics.Day07;

import java.util.Arrays;

public class 수열과구간쿼리_02 {
    public int[] solution(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];

            int min = -1; // 이번 쿼리의 결과값 저장용
            for(int j = s; j <= e; j++){
                if(arr[j] > k){
                    // 처음 찾았거나(-1), 지금 숫자가 여태 찾은 min보다 작으면 갱신
                    if(min == -1 || arr[j] < min){
                        min = arr[j];
                    }
                }
            }
            result[i] = min;
        }

        return result;
    }
    public static void main(String[] args) {
        수열과구간쿼리_02 s = new 수열과구간쿼리_02();
        System.out.println(Arrays.toString(
                s.solution(new int[]{0,1,2,4,3},
                           new int[][]{{0,4,2},{0,3,2},{0,2,2}}))); // 3,4,-1
    }
}
