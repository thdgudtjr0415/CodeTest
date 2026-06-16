package programmers.basics.Day36;

import java.util.Arrays;
// 이 문제는 다시 풀어보는게 좋을듯
public class 정수를나선형으로배치하기 {
    public int[][] solution(int n) {
        int[][] result = new int[n][n];
        int row = 0, col = 0;
        // 오른,아래,왼쪽,위(나선형으로 진행될때 인덱스들 변화 보면 이해됨)
        int[] drow = {0,1,0,-1};
        int[] dcol = {1,0,-1,0};
        int num = 1;
        int idx = 0;
        while(num <= n*n){
            result[row][col] = num++;
            int nextRow = row + drow[idx];
            int nextCol = col + dcol[idx];
            if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || result[nextRow][nextCol] != 0){
                idx = (idx+1)%4; // 이거 괜찮은듯 무조건 1~4 까지 반복
            }
            row = row + drow[idx];
            col = col + dcol[idx];
        }
        return result;
    }
    public static void main(String[] args){
        정수를나선형으로배치하기 s = new 정수를나선형으로배치하기();
        //[[1, 2, 3, 4], [12, 13, 14, 5], [11, 16, 15, 6], [10, 9, 8, 7]]
        System.out.println(Arrays.deepToString(s.solution(4)));
        //[[1, 2, 3, 4, 5], [16, 17, 18, 19, 6], [15, 24, 25, 20, 7], [14, 23, 22, 21, 8], [13, 12, 11, 10, 9]]
        System.out.println(Arrays.deepToString(s.solution(5)));
    }
}
/*
* 00 01 02 03 13 23 33 32 31 30 20 10 11 12 22 21
* 00 01 02 03 04 14 24 34 44 43 42 41 40 30 20 10 11 12 13 23 33 32 31 21 22
* */