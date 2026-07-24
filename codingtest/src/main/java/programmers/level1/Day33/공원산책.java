package programmers.level1.Day33;

import java.util.Arrays;

//로봇 강아지는 명령을 수행하기 전에 다음 두 가지를 먼저 확인합니다.
//
//주어진 방향으로 이동할 때 공원을 벗어나는지 확인
//주어진 방향으로 이동 중 장애물을 만나는지 확인
//위 두 가지중 어느 하나라도 해당된다면, 로봇 강아지는 해당 명령을 무시하고 다음 명령을 수행
//S : 시작 지점
//O : 이동 가능한 통로
//X : 장애물
// result 는 결과 즉 인덱스 위치를 뜻함 이거 이차원배열

public class 공원산책 {
    public int[] 일반풀이(String[] park, String[] routes) {
        char[][] parkBoard = new char[park.length][park[0].length()];
        int[] curidx = new int[2];
        char[] dirs = {'N','S','W','E'};
        int[] dh = {-1,1,0,0}; // 세로
        int[] dw = {0,0,-1,1}; // 가로
        // parkBoard[][] 생성
        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[i].length(); j++){
                parkBoard[i][j] = park[i].charAt(j);
                if(parkBoard[i][j] == 'S') {
                    curidx[0] = i;
                    curidx[1] = j;
                }
            }
        }
        // routes 뽑아내서 이동시키기
        for(int i = 0; i < routes.length; i++){
            char direction = routes[i].charAt(0); // routes에서 뽑아낸 방향
            int num = routes[i].charAt(2) - '0'; // direction이 몇번 반복되는지
            int didx = 0; // 방향 4개중의 인덱스
            for(int j = 0; j < 4; j++) {
                if (dirs[j] == direction) {
                    didx = j; break;
                }
            }
            int[] tempidx = {curidx[0], curidx[1]};
            boolean isCheck = true;
            for(int j = 0; j < num; j++){
                tempidx[0] += dh[didx];
                tempidx[1] += dw[didx];
                if(tempidx[0] < 0 || tempidx[1] < 0
                || tempidx[0] >= parkBoard.length || tempidx[1] >= parkBoard[0].length
                || parkBoard[tempidx[0]][tempidx[1]] == 'X'
                ){
                    isCheck = false;
                    break;
                }
            }
            if(isCheck){
                curidx[0] = tempidx[0];
                curidx[1] = tempidx[1];
            }
        }
        int[] result = {curidx[0],curidx[1]};
        return result;
    }

    public int[] 간략풀이(String[] park, String[] routes) {
        // 순서는 NSWE
        int[] dh = {-1, 1, 0, 0}; // 세로
        int[] dw = {0, 0, -1, 1}; // 가로
        int[] curidx = new int[2];

        // start 위치 찾기
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    curidx[0] = i;
                    curidx[1] = j;
                }
            }
        }
        //move
        for (int i = 0; i < routes.length; i++) {
            // 여기서 indexOf로 빠르게 할 수 있음
            int n = "NSWE".indexOf(routes[i].charAt(0));
            int[] tempidx = {curidx[0], curidx[1]};
            // boolean 으로 ture, false 활용의 중요성
            boolean isCheck = true;
            for (int j = 0; j < routes[i].charAt(2) - '0'; j++) {
                tempidx[0] += dh[n];
                tempidx[1] += dw[n];
                if (tempidx[0] < 0 || tempidx[1] < 0
                        || tempidx[0] >= park.length || tempidx[1] >= park[0].length()
                        // 굳이 이차원 배열 int[][] 이렇게 안하고 할수 있을 듯
                        || park[tempidx[0]].charAt(tempidx[1]) == 'X'
                ) {
                    isCheck = false;
                    break;
                }
            }
            if(isCheck){
                curidx[0] = tempidx[0];
                curidx[1] = tempidx[1];
            }
        }
        int[] result = {curidx[0], curidx[1]};
        return result;
    }
    public static void main(String[] args){
        공원산책 s = new 공원산책();
        System.out.println(Arrays.toString(s.일반풀이(
                new String[]{"SOO","OOO","OOO"},
                new String[]{"E 2","S 2","W 1"})));//2,1
        System.out.println(Arrays.toString(s.일반풀이(
                new String[]{"SOO","OXX","OOO"},
                new String[]{"E 2","S 2","W 1"})));//0,1
        System.out.println(Arrays.toString(s.일반풀이(
                new String[]{"OSO","OOO","OXO","OOO"},
                new String[]{"E 2","S 3","W 1"})));//0,0

        System.out.println(Arrays.toString(s.간략풀이(
                new String[]{"SOO","OOO","OOO"},
                new String[]{"E 2","S 2","W 1"})));//2,1
        System.out.println(Arrays.toString(s.간략풀이(
                new String[]{"SOO","OXX","OOO"},
                new String[]{"E 2","S 2","W 1"})));//0,1
        System.out.println(Arrays.toString(s.간략풀이(
                new String[]{"OSO","OOO","OXO","OOO"},
                new String[]{"E 2","S 3","W 1"})));//0,0
    }
}
