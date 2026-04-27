package programmers.beginner.Day20;


public class 겹치는선분의길이 {
    public int solution(int[][] lines) {
        // 보드를 생각해서 그위에 count >= 2 이상인 것들만 생각해보기
        int result = 0;
        int[] board = new int[201];

        for(int i = 0; i < lines.length; i++){
            // 여기서 <= 쓰면 안됨 왜냐하면 지금 선분이기 때문에 점을 한개 빼야함
            for(int j = lines[i][0]; j < lines[i][1]; j++){
                board[j+100]++;
            }
            //그럼 여기까지가 겹치는 선분들을 구하는 반복문 여기서 2이상만 뽑으면 됨
        }
        for(int i = 0; i < board.length; i++){
            if(board[i] > 1){
                result ++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        겹치는선분의길이 s = new 겹치는선분의길이();
        System.out.println("solution1");
        System.out.println(s.solution(new int[][]{{0,1}, {2,5}, {3,9}})); // 2
        System.out.println(s.solution(new int[][]{{-1,1}, {1,3}, {3,9}})); // 0
        System.out.println(s.solution(new int[][]{{0,5}, {3,9}, {1,10}})); // 8

    }
}
