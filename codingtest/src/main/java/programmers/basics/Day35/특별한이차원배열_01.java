package programmers.basics.Day35;

import java.util.Arrays;

public class 특별한이차원배열_01 {
    public int[][] solution(int n) {
        int[][] result = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i==j){
                    result[i][j] = 1;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        특별한이차원배열_01 s = new 특별한이차원배열_01();
        System.out.println(Arrays.deepToString(s.solution(3)));// [[1, 0, 0], [0, 1, 0], [0, 0, 1]]
        System.out.println(Arrays.deepToString(s.solution(6)));// 	[[1, 0, 0, 0, 0, 0], [0, 1, 0, 0, 0, 0], [0, 0, 1, 0, 0, 0], [0, 0, 0, 1, 0, 0], [0, 0, 0, 0, 1, 0], [0, 0, 0, 0, 0, 1]]
        System.out.println(Arrays.deepToString(s.solution(1)));// [[1]]
    }
}
