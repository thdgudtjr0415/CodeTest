package programmers.level1.Day05;

import java.util.Arrays;

public class 행렬의덧셈 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        if(arr1[0].length == 1){
            answer[0][0] = arr1[0][0] + arr2[0][0];
            answer[1][0] = arr1[1][0] + arr2[1][0];
        }else {
            for(int i = 0; i < answer.length; i++) {
                for(int j = 0; j < answer[0].length; j++) {
                    answer[i][j] = arr1[i][j] + arr2[i][j];
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        행렬의덧셈 s = new 행렬의덧셈();
        System.out.println(Arrays.deepToString(s.solution(new int[][]{{1,2},{2,3}}, new int[][]{{3,4},{5,6}}))); //4,6 ,7,9
        System.out.println(Arrays.deepToString(s.solution(new int[][]{{1},{2}}, new int[][]{{3},{4}}))); // 4,6
    }
}
