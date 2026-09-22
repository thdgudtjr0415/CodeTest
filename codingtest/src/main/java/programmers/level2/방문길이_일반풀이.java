package programmers.level2;

//U: 위쪽으로 한 칸 가기
//D: 아래쪽으로 한 칸 가기
//R: 오른쪽으로 한 칸 가기
//L: 왼쪽으로 한 칸 가기
// 좌표는 -5 ~ 5

public class 방문길이_일반풀이 {
    public int solution1(String dirs) {
        // 지금 좌표는 -5~5 이지만 우리는 지나간 선을 나타내야하기 때문에 배열x2배 해야함
        // 1로 표시하는 곳은 좌표 -1 을 표시하는 곳은 선, 즉 지나간 자리를 나타냄
        int[][] board = new int[22][22];
        int[] curr = {10,10};
        board[curr[0]][curr[1]] = 1;
        int len = dirs.length();

        for(int i = 0; i < len; i++){
            char c = dirs.charAt(i);
            int dr = 0;
            int dc = 0;
            //U,D,R L 순서(위, 아, 오, 왼)
            if(c == 'U'){
                dr = 1; dc = 0;
            }else if(c == 'D'){
                dr = -1; dc = 0;
            }else if(c == 'R'){
                dr = 0; dc = 1;
            }else if(c == 'L'){
                dr = 0; dc = -1;
            }
            curr[0] += dr * 2;
            curr[1] += dc * 2;
            if(curr[0] >= 0 && curr[0] <= 21 && curr[1] >= 0 && curr[1] <= 21){
                board[curr[0]-dr][curr[1]-dc] -= 1;
//                board[curr[0]][curr[1]] += 1; // 영향이 없는 줄(사실 우리는 지나간 선만 알면됨)
            }else {
                curr[0] -= dr*2;
                curr[1] -= dc*2;
            }
        }

//        view(board);
        int answer = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] < 0){
                    answer++;
                }
            }
        }
        return answer;
    }

    // ===== 코드 리뷰 (고칠 것) =====
    // 1. 주석이 예전 방식(점 표시)에 머물러 있다 -> 선 칸은 -1, 점 칸은 +1 방식에 맞게 수정
    // 2. nr, nc는 "새 행/열"이 아니라 "이동 방향" -> dr, dc로 이름 변경
    // 3. 점 칸 표시(+= 1)와 시작 칸 표시는 결과에 영향 없음 -> 삭제
    // 4. 마지막 22x22 전체 스캔 -> 선 칸이 처음 표시될 때(값이 0일 때) answer++ 로 대체
    // 5. 이동 후 범위 밖이면 되돌리는 방식 -> 도착 좌표를 먼저 계산해서 검사
    // 6. main의 println -> assert로 변경 (기대값을 코드에 적어 둠)

    public int solution2(String dirs) {
        int[][] board = new int[22][22];
        int[] curr = {10,10};
        board[curr[0]][curr[1]] = 1;
        int len = dirs.length();
        int answer = 0;

        for(int i = 0; i < len; i++){
            char c = dirs.charAt(i);
            int dr = 0;
            int dc = 0;
            //U,D,R L 순서(위, 아, 오, 왼)
            if(c == 'U'){
                dr = 1; dc = 0;
            }else if(c == 'D'){
                dr = -1; dc = 0;
            }else if(c == 'R'){
                dr = 0; dc = 1;
            }else if(c == 'L'){
                dr = 0; dc = -1;
            }

            int tr = curr[0] + dr * 2;
            int tc = curr[1] + dc * 2;

            // 조건에 미리 도착할 좌표를 대입해서 되돌아가는 경우를 없앰
            if(tr >= 0 && tr <= 20 && tc >= 0 && tc <= 20) {
                if(board[curr[0] + dr][curr[1] + dc] == 0){
                    answer++;
                }
                // 선 표시
                board[curr[0] + dr][curr[1] + dc] -= 1;
                curr[0] = tr;
                curr[1] = tc;
            }
        }

        return answer;
    }

    private void view(int[][] board) {
        System.out.println("------------------------------------");
        for(int i = board.length - 1; i >= 0; i--){   // 큰 행부터 출력
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------------------");
    }


    public static void main(String[] args){
        방문길이_일반풀이 s = new 방문길이_일반풀이();
//        int r = s.solution1("ULURRDLLU");
//        assert r == 7 : "결과 + " + r;
//        System.out.println(s.solution1("ULURRDLLU")); // 7
//        System.out.println(s.solution1("LULLLLLLU")); // 7

        int r1 = s.solution2("ULURRDLLU");
        assert r1 == 7 : "결과 + " + r1;
        int r2 = s.solution2("LULLLLLLU");
        assert r2 == 7 : "결과 + " + r2;
        System.out.println(s.solution2("ULURRDLLU")); // 7
        System.out.println(s.solution2("LULLLLLLU")); // 7
    }
}
