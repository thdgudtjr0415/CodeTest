package programmers.level2.그래프_탐색;

import java.util.ArrayDeque;
import java.util.Queue;


//board에서 R의 위치를 찾아 start에 저장한다. (indexOf('R') 사용)
//visited(boolean[][])를 만들고, 시작 칸을 true로 표시한다.
//큐에 {start행, start열, 0}을 넣는다.
//큐가 빌 때까지 반복한다.
//큐에서 {r, c, count}를 꺼낸다.
//그 칸이 G이면 count를 답으로 돌려주고 끝낸다.
//네 방향(위, 아래, 오른쪽, 왼쪽)마다 다음을 한다.
//현재 칸 (r, c)에서 시작해서, 다음 칸이 판 안이고 D가 아니면 한 칸씩 계속 움직인다.
//멈춘 칸을 (nr, nc)라고 한다.
//visited[nr][nc]가 false이면 true로 바꾸고, 큐에 {nr, nc, count + 1}을 넣는다.
//반복이 끝났는데 G에서 멈춘 적이 없으면 -1을 돌려준다.

public class 리코쳇로봇 {
    public int solution(String[] board) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[] start = new int[2];
        // 방향 위, 아래, 오른쪽, 왼쪽
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,1,-1};

        // 보기 편하게 배열로 만듬
        String[][] boardArr = new String[board.length][];
        for(int i = 0; i < board.length; i++){
            String[] arr = board[i].split("");
            boardArr[i] = arr;
            int j = board[i].indexOf('R'); // R 없으면 -1
            if(j != -1){
                start[0] = i;
                start[1] = j;
            }
        }
        viewArr(boardArr);

        // 멈췄는지 확인
        boolean[][] visited = new boolean[board.length][board[0].length()];
        // 시작칸 true
        visited[start[0]][start[1]] = true;

        int answer = -1;
        queue.offer(new int[]{start[0], start[1], 0}); // 행, 열, 횟수
        while(!queue.isEmpty()){
            int[] que = queue.poll();
            int r = que[0];
            int c = que[1];
            int count = que[2];
            if(boardArr[r][c].equals("G")) return count;
            for(int i = 0; i < 4; i++){
                int nextR = r + dr[i];
                int nextC = c + dc[i];
                // 조건은 board 안쪽이여야 하고 D에 부딛히면 멈춤
                while((nextR < boardArr.length && nextC < boardArr[0].length && nextR >= 0 && nextC >= 0)
                        && !boardArr[nextR][nextC].equals("D")){
                    nextR += dr[i];
                    nextC += dc[i];
                }
                // while을 빠져나가면 그래도 dr[i],dc[i] 만큼 한칸더 가있는거기 때문에 빼줘야함
                nextR -= dr[i];
                nextC -= dc[i];

                // 한번 가봤던 곳은 말고 안가본 곳이면 넣기
                if(!visited[nextR][nextC]){
                    visited[nextR][nextC] = true;
                    queue.offer(new int[]{nextR, nextC, count+1});
                }
            }
        }
        return answer;
    }
    private void viewArr(String[][] arr){
        for(int i = 0 ; i < arr.length; i++){
            for(int j = 0 ; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        리코쳇로봇 s = new 리코쳇로봇();
        System.out.println(s.solution(new String[]{
                "...D..R",
                ".D.G...",
                "....D.D",
                "D....D.",
                "..D...."})); // 7
        System.out.println(s.solution(new String[]{
                ".D.R",
                "....",
                ".G..",
                "...D"})); // -1
    }
}
