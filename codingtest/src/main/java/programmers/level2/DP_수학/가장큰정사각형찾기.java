package programmers.level2.DP_수학;

public class 가장큰정사각형찾기 {
    public int solution(int[][] board) {
        int answer = 0;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                int cur = board[i][j];
                if(cur == 0) continue;
                int leftTop = 0;
                int top = 0;
                int left = 0;
                if(i > 0 && j > 0){
                    leftTop = board[i-1][j-1];
                    top = board[i-1][j];
                    left = board[i][j-1];
                }
                board[i][j] = Math.min(leftTop, Math.min(top,left)) + 1;
                answer = Math.max(answer, board[i][j]);
            }
        }
        answer = answer * answer;
        return answer;
    }
    public static void main(String[] args) {
        가장큰정사각형찾기 s = new 가장큰정사각형찾기();
        System.out.println(s.solution(new int[][]{
                {0,1,1,1},
                {1,1,1,1},
                {1,1,1,1},
                {0,0,1,0}})); // 9
        System.out.println(s.solution(new int[][]{
                {0,0,1,1},
                {1,1,1,1}})); // 4
        System.out.println(s.solution(new int[][]{
                {0}})); // 0
        System.out.println(s.solution(new int[][]{
                {1}})); // 1
    }
}
