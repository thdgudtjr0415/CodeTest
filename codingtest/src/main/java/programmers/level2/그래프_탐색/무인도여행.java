package programmers.level2.그래프_탐색;

import java.util.*;

// x는 바다를 의미, 숫자는 무인도를 나타냄
// 상하좌우로 연결되는 땅들은 하나의 무인도를 이룸
// 지도의 각 칸에 적힌 숫자는 식량을 나타네는데
// 상하좌우로 연결되는 칸에 적힌 숫자를 모두 합한 값은 해당 무인도에서 최대 며칠동안 머물 수 있는지 나타냄
// 최대 몇일 머물수 있는지 , 각 섬에서 최대 며칠씩 머무를 수 있는지 배열에 오름차순
// 없다면 -1

// list로 섬 들을 담고, visited로 방문의 여부를 판단, 그리고 재귀로 돌면서 섬에 대한 숫자 더하기

public class 무인도여행 {
    public int[] solution(String[] maps) {
        // 몇이 몇개 나올지 모르니까 list로 담기
        List<Integer> list = new ArrayList<>();
        // 방문
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        // 상하좌우
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                if(maps[i].charAt(j) != 'X' && !visited[i][j]){
                    list.add(sumIsland(maps, visited ,dr, dc, new int[]{i, j}));
                }
            }
        }
        if(list.size() == 0){
            return new int[]{-1};
        }
        Collections.sort(list);

//        int[] answer = new int[list.size()];
//        for(int i = 0 ; i < list.size(); i++){
//            answer[i] = list.get(i);
//        }
        return list.stream().mapToInt(Integer :: intValue).toArray();
    }
        //curPoint에서 행과 열을 꺼냄
        //이 칸을 더하면 안 되는 경우면 0을 돌려주고 끝냄. 지도 밖, 바다(X), 이미 방문한 경우임
        //이 칸을 방문했다고 표시함
        //이 칸의 숫자를 합의 시작값으로 잡음
        //상하좌우 네 칸에 같은 함수를 불러서, 돌려받은 값을 합에 더함
        //합을 돌려줌
    private int sumIsland(String[] maps, boolean[][] visited, int[] dr, int[] dc, int[] curPoint) {
        int row = curPoint[0];
        int col = curPoint[1];
        // 경우의 수 map 밖이나, visited에서 지나온곳, 그리고 X인 부분에서 return 0 하기
        if(row < 0 || col < 0 || row >= maps.length || col >= maps[0].length()
                || visited[row][col] || maps[row].charAt(col) == 'X'){
            return 0;
        }
        visited[row][col] = true;
        int sumNum = maps[row].charAt(col) - '0'; // 그냥 쉽게

        for(int i = 0; i < 4; i++){
            // 다음 칸 가기
            int nextRow = row + dr[i];
            int nextCol = col + dc[i];
            sumNum += sumIsland(maps, visited, dr, dc, new int[]{nextRow, nextCol});
        }

        return sumNum;
    }

    private void viewMaps(boolean[][] visited){
        for(int i = 0; i < visited.length; i++){
            for(int j = 0; j < visited[i].length; j++){
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        무인도여행 s = new 무인도여행();
        System.out.println(Arrays.toString(s.solution(new String[]{
                "X591X",
                "X1X5X",
                "X231X",
                "1XXX1"}))); // [1, 1, 27]
        System.out.println(Arrays.toString(s.solution(new String[]{
                "XXX",
                "XXX",
                "XXX"}))); // [-1]
    }
}
