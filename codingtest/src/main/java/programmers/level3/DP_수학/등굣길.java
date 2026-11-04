package programmers.level3.DP_수학;

//격자를 만들어요. 물웅덩이는 0이고 시작 칸은 1이에요.
//반복문으로 칸마다 "위 + 왼쪽"을 계산해요. 물 칸은 건너뛰어요.
//도착 칸의 값을 1,000,000,007로 나눈 나머지로 반환해요.
// 시작점은 0,0 / 도착점 m-1, n-1 으로 고정


public class 등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int[][] board = new int[n][m];
        boolean[][] isPuddle = new boolean[n][m];
        for(int i = 0; i < puddles.length; i++){
            int[] arr = puddles[i];
            isPuddle[arr[1]-1][arr[0]-1] = true;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0){
                    board[i][j] = 1;
                    continue;
                }
                int up = 0, left = 0; // 인덱스임
                if (i > 0) up = board[i-1][j];
                if (j > 0) left = board[i][j-1];

                // 웅덩이 판별해서 지나가기
                if(isPuddle[i][j]){
                    continue;
                }
                board[i][j] = (up + left) % 1000000007;
            }
        }
//        view(board);
        int answer = board[n-1][m-1];
        return answer;
    }
    public void view(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        등굣길 s = new 등굣길();
        // 입출력 예 1: m=4, n=3, puddles=[[2, 2]] -> 4
        System.out.println(s.solution(4, 3, new int[][]{{2, 2}})); // 4
        // 추가 예 1: 물웅덩이 5개 -> 3
        System.out.println(s.solution(5, 5, new int[][]{{2, 1}, {4, 2}, {2, 3}, {3, 4}, {5, 4}})); // 3
        // 추가 예 2: 물웅덩이 10개 -> 8
        System.out.println(s.solution(7, 7, new int[][]{{2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}, {2, 5}, {5, 2}, {3, 6}, {6, 3}, {4, 1}})); // 8
        // 추가 예 3: 물웅덩이 없는 100 x 100 (나머지 연산 확인) -> 690285631
        System.out.println(s.solution(100, 100, new int[][]{})); // 690285631
    }
}
