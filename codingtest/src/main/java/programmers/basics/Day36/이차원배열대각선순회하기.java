package programmers.basics.Day36;

public class 이차원배열대각선순회하기 {
    public int solution(int[][] board, int k) {
        int result = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(i+j<=k){
                    result += board[i][j];
                }
            }
        }
        return result;
    }
    public static void main(String[] ars){
        이차원배열대각선순회하기 s = new 이차원배열대각선순회하기();
        System.out.println(s.solution(new int[][]{{0,1,2},{1,2,3},{2,3,4},{3,4,5}},2)); //8
    }
}
