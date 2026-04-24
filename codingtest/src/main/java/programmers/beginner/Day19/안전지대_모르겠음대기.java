package programmers.beginner.Day19;

/* 주석.
 * 지금 상황을 보면 지뢰가 들어간다 가정했을때
 * board[i][i] 이라고 가정
 * 그럼 위험 지대는
 * board[i-1][i-1 ~ i+1]
 * board[i][i-1 ~ i+1]
 * board[i+1][i-1 ~ i+1]
 * 까지가 위험지대 조건으로는 보드를 넘어가면 continue로 넘겨야함
 * 0 이 안전지대 1이 위험지대 로 표시 하면 될듯
 * */

public class 안전지대_모르겠음대기 {
    public int solution(int[][] board) {
        int n = board.length;
        int result = 0;
        // 이거 혹시 모르니 보드를 복사 하고 해야하나보다
        int[][] dangerBoard = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1){
                    // 여기 잘 봐야함 여기 부분이
//                    board[i-1][j-1] = 1;
//                    board[i-1][j] = 1;
//                    board[i-1][j+1] = 1;
//                    board[i][j-1] = 1;
//                    board[i][j+1] = 1;
//                    board[i+1][j-1] = 1;
//                    board[i+1][j] = 1;
//                    board[i+1][j+1] = 1;
//                    이거임
                    for(int k = i-1; k <= i+1;k++){
                        for(int l = j-1; l <= j+1;l++){
                            // 이 조건은 인덱스 범위 밖으로 안나가게 하는 것
                            if(k >= 0 && k < n && l >= 0 && l < n){
                                dangerBoard[k][l] = 1;
                            }
                        }
                    }
                    // 위에 것과 같은것

                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dangerBoard[i][j]==0){
                    result++;
                }
            }
        }
        return result;

    }
    public static void main(String[] args) {
        안전지대_모르겠음대기 s = new 안전지대_모르겠음대기();
        System.out.println(s.solution(new int[][]{
                                                    {0, 0, 0, 0, 0},
                                                    {0, 0, 0, 0, 0},
                                                    {0, 0, 0, 0, 0},
                                                    {0, 0, 1, 0, 0},
                                                    {0, 0, 0, 0, 0}})); // 16
        System.out.println(s.solution(new int[][]{
                                                    {0, 0, 0, 0, 0},
                                                    {0, 0, 0, 0, 0},
                                                    {0, 0, 0, 0, 0},
                                                    {0, 0, 1, 1, 0},
                                                    {0, 0, 0, 0, 0}})); // 13
        System.out.println(s.solution(new int[][]{
                                                    {1, 1, 1, 1, 1, 1},
                                                    {1, 1, 1, 1, 1, 1},
                                                    {1, 1, 1, 1, 1, 1},
                                                    {1, 1, 1, 1, 1, 1},
                                                    {1, 1, 1, 1, 1, 1}})); // 0

    }
}
