package programmers.level2;

// 주의할 것 범위 조심하고 블럭 사라진 후에도 남아있는 것에서만 범위 잘 하기

import java.util.HashSet;
import java.util.Set;

/*
 * [개선할 점]
 * 1. temp += ... : String은 += 할 때마다 새 문자열이 생긴다. StringBuilder 또는 char[]가 더 좋다. ->ok
 * 2. Set<String> "i,j" 키 : split + parseInt 로 다시 풀어야 해서 번거롭다.
 *    boolean[][] 로 지울 칸을 표시하면 문자열 변환 없이 더 간단하다. -> 굳이..?
 * 3. findBlockCount 변수는 불필요 : return set.size(); 한 줄로 충분하다. -> ok
 * 4. '0' 을 직접 쓰는 곳이 여러 군데 : EMPTY 상수를 클래스 필드로 빼면 실수를 줄일 수 있다. -> ok
 * 5. viewBoard, main 은 확인용이라 제출할 때는 없어도 된다. -> ok
 */
public class 프렌즈4블록_CodeReview {
    public static final char EMPTY = '0';
    public int solution(int m, int n, String[] board) {
        // 지울 칸의 좌표("행,열")를 모으는 Set : 2x2가 겹쳐도 같은 칸이 중복으로 들어가지 않는다
        Set<String> set = new HashSet<>();
        int count = 0; // 지워진 블록 총 개수
        char[][] boardGame = new char[m][];
        for(int i = 0; i < m; i++){
            boardGame[i] = board[i].toCharArray();
        }
        int num = -1; // 이번 라운드에 지워질 블록 수 (0이면 더 지울 게 없으니 종료)
        while(num != 0){
            num = findBlock(m, n, boardGame, set);
            removeBlock(boardGame, set);
            dropBlock(boardGame);
            count += num; // 라운드마다 지운 칸 수 누적
        }
        return count;
    }

    private int findBlock(int m, int n, char[][] boardGame, Set<String> set) {
        // m-1, n-1하는 이유는 2x2 최대 i+1, j+1이라서, 지금은 블랙 삭제를 위한 확인이니 범위 설정 이렇게
        for(int i = 0; i < m-1; i++){
            for(int j = 0; j < n-1; j++){
                char c = boardGame[i][j];
                // c != EMPTY : 이미 지워진 빈칸 4개가 모인 것을 블록으로 세지 않기 위한 조건 (없으면 무한 반복)
                if(c != EMPTY && boardGame[i][j+1] == c && boardGame[i+1][j] == c && boardGame[i+1][j+1] == c){
                    set.add(i+ ","+j);
                    set.add(i+ ","+(j+1));
                    set.add((i+1)+ ","+j);
                    set.add((i+1)+ ","+(j+1));
                }
            }
        }
        return set.size();
    }

    // 찾아 둔 칸을 전부 한꺼번에 빈칸으로 바꾸고, 다음 라운드를 위해 Set을 비운다
    private void removeBlock(char[][] boardGame, Set<String> set) {
        for(String key : set){
            String[] arr = key.split(",");
            int y = Integer.parseInt(arr[0]);
            int x = Integer.parseInt(arr[1]);
            boardGame[y][x] = EMPTY;
        }
        set.clear();
    }

    // 열마다 처리 : 블록만 아래->위로 모은 뒤(sb), 맨 아래부터 다시 채우고 남는 위쪽은 빈칸('0')
    private void dropBlock(char[][] boardGame) {
        for(int i = 0; i < boardGame[0].length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = boardGame.length -1; j >= 0; j--){
                if(boardGame[j][i] != EMPTY){
                    sb.append(boardGame[j][i]);
                }
            }
            for(int j = 0; j < boardGame.length; j++){
                char c = EMPTY;
                if(j < sb.length()){
                    c = sb.charAt(j);
                }
                boardGame[boardGame.length-1 -j][i] = c; // 아래에서 j번째 행에 채움
            }
        }
    }

    private void viewBoard(char[][] boardGame) {
        for(int i = 0; i < boardGame.length; i++){
            for(int j = 0; j < boardGame[i].length; j++){
                System.out.print(boardGame[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        프렌즈4블록_CodeReview s = new 프렌즈4블록_CodeReview();
        System.out.println(s.solution(
                4,5,new String[]{
                        "CCBDE",
                        "AAADE",
                        "AAABF",
                        "CCBBF"
                }));

        System.out.println(s.solution(
                6,6,new String[]{
                        "TTTANT",
                        "RRFACC",
                        "RRRFCC",
                        "TRRRAA",
                        "TTMMMF",
                        "TMMTTJ"
                }));
    }
}
