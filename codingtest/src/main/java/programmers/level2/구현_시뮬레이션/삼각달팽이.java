package programmers.level2.구현_시뮬레이션;

import java.util.Arrays;

public class 삼각달팽이 {
    public int[] solution(int n) {
        int len = n * (n+1) /2;
        // 정사각형의 반만 사용한다고 생각 정사각형을 대각선으로 자른 느낌
        int[][] tri = new int[n][n];
        // 욺직이기
        // 아래, 오른쪽, 왼쪽 대각선
        int[] dr = {1, 0,-1};
        int[] dc = {0, 1,-1};
        int idx = 0; // 이건 계속 숫자 올라가면서 %로 나머지를 나눌껀데 이걸로 인덱스 표시할것
        int[] cur = {0, 0}; // 현재 위치
        tri[0][0] = 1; // 시작점
        for(int i = 2 ;i <= len; i++){
            int next = idx%3;
            int row = cur[0] + dr[next];
            int col = cur[1] + dc[next];
            if(row < 0 || row >= n || col < 0 || col >= n || tri[row][col] > 0){
                idx++;
                next = idx%3;
                row = cur[0] + dr[next];
                col = cur[1] + dc[next];
            }
            tri[row][col] = i;
            cur[0] = row; cur[1] = col; // update
        }
        int[] answer = new int[len];
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(tri[i][j] != 0) answer[index++] = tri[i][j];
            }
        }
        return answer;
    }

    private void viewArr(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        삼각달팽이 s = new 삼각달팽이();
        System.out.println(Arrays.toString(s.solution(4)));
        // [1,2,9,3,10,8,4,5,6,7]
        System.out.println(Arrays.toString(s.solution(5)));
        // [1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
        System.out.println(Arrays.toString(s.solution(6)));
        // [1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]
    }
}
