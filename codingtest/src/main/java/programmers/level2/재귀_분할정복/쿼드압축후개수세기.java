package programmers.level2.재귀_분할정복;

import java.util.Arrays;

class 쿼드압축후개수세기 {
    public int[] solution(int[][] arr) {
        int[] count = new int[2]; // 0과 1의 개수
        int n = arr.length;
        int row = 0;
        int col = 0;
        compress(arr, row, col, n, count);
        return count;
    }

    private void compress(int[][] arr, int row, int col, int n, int[] count) {
        int startNum = arr[row][col];
        int half = n/2;
        boolean flag = isSame(arr, row, col, n);
        if(flag){
            count[startNum]++;
        }else {
            compress(arr, row, col, half, count);
            compress(arr, row, col + half, half, count);
            compress(arr, row + half, col, half, count);
            compress(arr,row + half, col + half, half, count);
        }
    }

    private boolean isSame(int[][] arr, int row, int col, int n) {
        int num = arr[row][col];
        for(int i = row; i < row + n; i++){
            for(int j = col; j < col + n; j++){
                if(num != arr[i][j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        쿼드압축후개수세기 s = new 쿼드압축후개수세기();
        System.out.println(Arrays.toString(
                s.solution(new int[][]{
                        {1,1,0,0},
                        {1,0,0,0},
                        {1,0,0,1},
                        {1,1,1,1}}))); // 4,9
        System.out.println(Arrays.toString(
                s.solution(new int[][]{
                        {1,1,1,1,1,1,1,1},
                        {0,1,1,1,1,1,1,1},
                        {0,0,0,0,1,1,1,1},
                        {0,1,0,0,1,1,1,1},
                        {0,0,0,0,0,0,1,1},
                        {0,0,0,0,0,0,0,1},
                        {0,0,0,0,1,0,0,1},
                        {0,0,0,0,1,1,1,1}}))); // 10,15
    }
}
