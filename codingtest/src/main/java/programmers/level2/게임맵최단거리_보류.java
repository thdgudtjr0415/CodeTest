package programmers.level2;

// 최단 거리 나오면 bfs로 해야함 -> 큐 사용
// dfs는 재귀사용

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리_보류 {
    public int solution (int[][] maps){
        int n = maps.length;
        int m = maps[0].length;

        // 지나갔는지 확인하는 boolean 배열
        boolean[][] visited = new boolean[n][m];
        // 거리거 얼마인지 알수 잇는
        int[][] distance = new int[n][m];

        // 오른쪽, 왼쪾, 위, 아래(동서북남)
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

        // 여기서부터 BFS 메서드 따로 만들기
        bfs(maps, visited, distance, dr, dc, n, m);

        return distance[n-1][m-1] == 0 ? -1 : distance[n-1][m-1];
    }

    private void bfs(int[][] maps, boolean[][] visited, int[][] distance, int[] dr, int[] dc, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0}); // 시작점 0,0
        visited[0][0] = true;
        distance[0][0] = 1; // 시작했으니 1칸으로 시작

        // 큐가 없을때 까지 반복할 예정
        while(!queue.isEmpty()){
            // 먼저 처음에 넣은 시작점 {0,0} 을 꺼냄
            int[] curIdx = queue.poll();
            // 시작점을 x,y로 구분해서 시작
            int x = curIdx[0];
            int y = curIdx[1];

            // 4방향을 확인해서 거리를 계산할 예정(1 ~ end 까지 1씩 증가시키면서 거리를 셀꺼임)
            for(int i = 0; i < 4; i++){
                // 이 부분이 dr,dc 위에 코드 20번째 보기
                int nx = x + dr[i];
                int ny = y + dc[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m // 여기까진 0보단 크고 맵 안에 있나를 확인
                        && maps[nx][ny] == 1 // 길인지 확인
                        && !visited[nx][ny]){ // boolean 배열 true 인지 확인하기
                    visited[nx][ny] = true;
                    distance[nx][ny] = distance[x][y] + 1;
                    queue.offer(new int[]{nx,ny});
                }
            }
        }
    }

    public static void main(String[] ars){
        게임맵최단거리_보류 s = new 게임맵최단거리_보류();
        System.out.println(s.solution(new int[][]{
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}})); // 11
        System.out.println(s.solution(new int[][]{
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,0},
                {0,0,0,0,1}})); // -1
    }
}
