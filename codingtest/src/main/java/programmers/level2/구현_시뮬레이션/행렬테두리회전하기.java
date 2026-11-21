package programmers.level2.구현_시뮬레이션;

import java.util.*;

// 순서대로 있는 이 행렬에서 직사각형 모양의 범위를 여러번 선택 후,
// 테두리 부분에 있는 숫자들을 시계방향으로 회전
// 각 회전은 (x1, y1, x2, y2)인 정수 4개로 표현

// 1. queries 에 각 행바다 의 직사각형에 해당하는 테두리 부분의 숫자들중 제일 작은 수 저장(이 배열의 크기는 queries.length)
// 2. 그 테두리 부분을 시가 방향으로 회전
// 2-1.

public class 행렬테두리회전하기 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] board = new int[rows][columns];
        int[] answer = new int[queries.length];
        int idx = 1;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                board[i][j] = idx++;
            }
        }
        for(int i = 0; i < queries.length; i++) {
            List<Integer> list = new ArrayList<>(); // 테두리 인덱스 담을 곳
            int top = queries[i][0]-1;
            int bottom = queries[i][2]-1;
            int left = queries[i][1]-1;
            int right = queries[i][3]-1;

            collectBorder(board, top, bottom, left, right, list); // 테두리 골라내기
            // 맨 끝을 빼서 제일 앞으로 넣기
            list.add(0, list.get(list.size()-1));
            list.remove(list.size()-1);
            int minNum = Collections.min(list);
            answer[i] = minNum;
            // 시계 방향대로 다시 넣기
            insertBorder(board, top, bottom, left, right, list);
        }

        return answer;
    }

    private void collectBorder(int[][] board,
                               int top,
                               int bottom,
                               int left,
                               int right,
                               List<Integer> list) {
        for(int i = left; i < right; i++) list.add(board[top][i]);
        for(int i = top; i < bottom; i++) list.add(board[i][right]);
        for(int i = right; i > left; i--) list.add(board[bottom][i]);
        for(int i = bottom; i > top; i--) list.add(board[i][left]);
    }
    private void insertBorder(int[][] board,
                               int top,
                               int bottom,
                               int left,
                               int right,
                               List<Integer> list){
        for(int i = left; i < right; i++){
            board[top][i] = list.get(0);
            list.remove(0);
        }
        for(int i = top; i < bottom; i++){
            board[i][right] = list.get(0);
            list.remove(0);
        }
        for(int i = right; i > left; i--){
            board[bottom][i] = list.get(0);
            list.remove(0);
        }
        for(int i = bottom; i > top; i--){
            board[i][left] = list.get(0);
            list.remove(0);
        }
    }

    public static void main(String[] args) {
        행렬테두리회전하기 s = new 행렬테두리회전하기();
        System.out.println(Arrays.toString(s.solution(6, 6,
                new int[][]{
                        {2,2,5,4},
                        {3,3,6,6},
                        {5,1,6,3}}))); // [8, 10, 25]
        System.out.println(Arrays.toString(s.solution(3, 3,
                new int[][]{
                        {1,1,2,2},
                        {1,2,2,3},
                        {2,1,3,2},
                        {2,2,3,3}}))); // [1, 1, 5, 3]
        System.out.println(Arrays.toString(s.solution(100, 97,
                new int[][]{{1,1,100,97}}))); // [1]
    }
}
