package programmers.level1.Day18;

//1. 정수를 저장할 변수 n을 만들고 board의 길이를 저장합니다.
//2. 같은 색으로 색칠된 칸의 개수를 저장할 변수 count를 만들고 0을 저장합니다.
//3. h와 w의 변화량을 저장할 정수 리스트 dh, dw를 만들고 각각 [0, 1, -1, 0], [1, 0, 0, -1]을 저장합니다.
//4. 반복문을 이용해 i 값을 0부터 3까지 1 씩 증가시키며 아래 작업을 반복합니다.
//    4-1. 체크할 칸의 h, w 좌표를 나타내는 변수 h_check, w_check를 만들고 각각 h + dh[i], w + dw[i]를 저장합니다.
//    4-2. h_check가 0 이상 n 미만이고 w_check가 0 이상 n 미만이라면 다음을 수행합니다.
//        4-2-a. board[h][w]와 board[h_check][w_check]의 값이 동일하다면 count의 값을 1 증가시킵니다.
//5. count의 값을 return합니다.

//제한사항
//1 ≤ board의 길이 ≤ 7
//board의 길이와 board[n]의 길이는 동일합니다.
//0 ≤ h, w < board의 길이
//1 ≤ board[h][w]의 길이 ≤ 10
//board[h][w]는 영어 소문자로만 이루어져 있습니다.

// 즉 어려운 말같지만 쉽게 생각해서 정사각형의 칸들이 주어지고 2차 행렬에 대한 좌표 , h,w가 주어진다면
// 그 칸을 기준으로 상하좌우에 같은 색이 있다면 count++

public class 이웃한칸 {
    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        int count = 0;
        // index 순서대로 오른쪽(0,1), 아래(1,0), 위(-1,0), 왼쪽(0,-1)
        int[] dh = new int[]{0, 1, -1, 0};
        int[] dw = new int[]{1, 0, 0, -1};

        for(int i =0; i <= 3; i++){
            int h_check = h + dh[i];
            int w_check = w + dw[i];
            if((h_check >= 0 && h_check < n) && (w_check >= 0 && w_check < n)){
                // String 이니까 equals 주의
                if(board[h][w].equals(board[h_check][w_check])){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        이웃한칸 s = new 이웃한칸();
        System.out.println(s.solution(new String[][]{
                {"blue", "red", "orange", "red"},
                {"red", "red", "blue", "orange"},
                {"blue", "orange", "red", "red"},
                {"orange", "orange", "red", "blue"}},1,1));        //2
        System.out.println(s.solution(new String[][]{
                {"yellow", "green", "blue"},
                {"blue", "green", "yellow"},
                {"yellow", "blue", "blue"}}, 0,1)); //1
    }
}
