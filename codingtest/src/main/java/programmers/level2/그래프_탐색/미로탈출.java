package programmers.level2.그래프_탐색;

//S : 시작 지점 E : 출구 L : 레버 O : 통로 X : 벽
// 이건 나눠서 풀어야함
// 1. 레버까지 s -> l
// 2. l -> e 탈출 까지

//전체 흐름
//maps를 돌면서 S의 위치를 찾는다 (charAt)
//S에서 L까지 걸린 시간을 함수로 구한다
//L의 위치에서 E까지 걸린 시간을 같은 함수로 구한다
//둘 중 하나라도 -1이면(못 감) -1을 돌려주고, 아니면 두 시간을 더한다
//
//함수 안에서 할 일
//time 표를 -1로 채워서 만든다
//시작 칸의 time을 0으로 하고, 줄(Queue)에 넣는다
//줄이 빌 때까지 꺼낸다 (poll)
//꺼낸 칸의 네 방향 칸을 본다
    //밖이거나 벽이면 건너뛴다
    //이미 간 칸(-1이 아님)이면 건너뛴다
    //아니면 time에 "지금 칸의 시간 + 1"을 적고 줄에 넣는다
    //그 칸이 도착 글자이면 바로 그 시간을 돌려준다
//줄이 비었는데도 못 찾았으면 -1을 돌려준다

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 미로탈출 {
    public int solution(String[] maps) {
        int answer = -1;
        char[][] map = new char[maps.length][maps[0].length()];


        int[] S = {0,0};
        int[] L = {0,0};
        int[] E = {0,0};
        // 배열로 만들기
        for(int i = 0 ; i < map.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                char c = maps[i].charAt(j);
                if(c == 'S') {S[0] = i; S[1] = j;}
                if(c == 'L') {L[0] = i; L[1] = j;}
                if(c == 'E') {E[0] = i; E[1] = j;}
                map[i][j] = c;
            }
        }


        int goToL = go(map, S, L);
        if(goToL == -1) return -1;
        int goToE = go(map, L, E);
        if(goToE == -1) return -1;
        answer = goToL + goToE;
        return answer;
    }
    private int go(char[][] map, int[] start, int[] end) {
        Queue<int[]> queue = new ArrayDeque<>(); // 잘 생각해보기
        // 상, 하 , 좌, 우
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        // 지나갔는지 안지나갔는지
        int[][] visit = new int[map.length][map[0].length];
        for(int i = 0; i < visit.length; i++) Arrays.fill(visit[i], -1); // -1 로 채우고 각 칸마다 시간으로 침

        // 시작점 부터
        int a = start[0];
        int b = start[1];
        visit[a][b] = 0;
        queue.offer(start);
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i = 0; i < 4; i++){
                // 이동할 칸
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                // 각 조건, 배열을 벗어나는지, 그리고 X인지
                if(nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length ||  map[nr][nc] == 'X') continue;
                if(visit[nr][nc] != -1) continue;

                // 이제 시간 적기
                visit[nr][nc] = visit[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{nr, nc});
                if(nr == end[0] && nc == end[1]){
                    return visit[nr][nc];
                }
            }
        }
        return -1;
    }

    private void viewArr(int[][] map){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++) System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args){
        미로탈출 s = new 미로탈출();
        System.out.println(s.solution(
            new String[]{
                    "SOOOL",
                    "XXXXO",
                    "OOOOO",
                    "OXXXX",
                    "OOOOE"})); // 16
        System.out.println(s.solution(
            new String[]{
                    "LOOXS",
                    "OOOOX",
                    "OOOOO",
                    "OOOOO",
                    "EOOOO"})); // -1
    }
}
