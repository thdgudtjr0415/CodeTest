package programmers.basics.Day36;

import java.util.Arrays;

public class 정사각형으로만들기 {
    public int[][] solution(int[][] arr) {
        int rowCount = arr.length;
        int colCount = arr[0].length;
        int max = Math.max(rowCount, colCount);
        int[][] result = new int[max][max];
        for(int i = 0; i < rowCount; i++){
            for(int j = 0; j < colCount; j++){
                result[i][j] = arr[i][j];
            }
        }
        return result;
    }
    public static void main(String[] args){
        정사각형으로만들기 s = new 정사각형으로만들기();
        System.out.println(Arrays.deepToString(s.solution(
                new int[][]{{572, 22, 37}, {287, 726, 384}, {85, 137, 292}, {487, 13, 876}})));
        System.out.println(Arrays.deepToString(s.solution(
                new int[][]{{57, 192, 534, 2}, {9, 345, 192, 999}})));
        System.out.println(Arrays.deepToString(s.solution(
                new int[][]{{1,2}, {3,4}})));
    }
}
