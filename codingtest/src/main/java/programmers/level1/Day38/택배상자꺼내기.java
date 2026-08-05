package programmers.level1.Day38;

/*
 * 1 ~ n의 번호가 있는 택배 상자가 창고에 있음, 가로로 w개씩 적재
 * 첫 줄은 왼쪽에서 오른쪽으로 정방향 w개, 다음 층은 거꾸로 오른쪽에서 왼쪽으로 w개
 * 이렇게 지그재그로 쌓은 다음, 특정 상자를 꺼내려면 그 위에 쌓인 상자를 전부 먼저 꺼내야 함
 * (택배가 아닌 곳은 -1로 표시) 이때 주의할 점은 배열을 굳이 거꾸로 안쌓아도 될듯

 * ex) n=13, w=3
 * 13 -1 -1     ← row0 (맨 위층)
 * 12 11 10     ← row1
 * 7  8  9      ← row2
 * 6  5  4      ← row3
 * 1  2  3      ← row4 (맨 아래층)
 * n : 총 택배 상자 개수
 * w : 가로로 놓는 상자 개수 (한 층에 쌓이는 개수)
 * num : 꺼내려는 택배 상자 번호
 * return : num을 포함해 꺼내야 하는 총 상자 개수
 * 순서
 * 1. n, w를 이용해 지그재그 방식으로 2차원 배열에 상자 번호를 채워 넣기 (빈 자리는 -1)
 * 2. 배열을 순회하면서 num이 있는 위치 (a행, b열) 찾기
 * 3. b열을 row0부터 a행까지 위에서 아래로 훑으면서, -1이 아닌 칸의 개수를 센다
 *    (맨 위층이 비어있는 칸일 수 있으므로 단순히 "행 번호+1"로 계산하면 안 됨)
 * 4. 그 개수가 곧 꺼내야 하는 총 상자 개수 (num 자신도 자동으로 포함됨)
 */

public class 택배상자꺼내기 {
    public int solution(int n, int w, int num) {
        int result = 0;
        // 나머지 부분은 -1로 채울 예정
        // 나눗셈 올림 처리하는 방법 이거 잘 기억하기
        int row = (n+w-1)/w ;
        int[][] box = new int[row][w];
        int cur = 1; // 이건 택배를 1부터 n까지 채울 예정
        // 박스 2차원행렬로 채울것
//        for(int i = 0; i < row; i++){
//            if(i % 2 == 0) {
//                for (int j = 0; j < w; j++) {
//                    box[i][j] = cur++;
//                }
//            }
//            if(i % 2 != 0){
//                for(int j = w-1; j >= 0; j--){
//                    box[i][j] = cur++;
//                }
//            }
//        }
//        for(int i = 0; i < row; i++){
//            for(int j = 0; j < w; j++){
//                if(box[i][j] > n){
//                    box[i][j] = -1;
//                }
//            }
//        }
        // 개선된 반복문
        for(int i = 0; i < row; i++){
                int start, end, step;
                if(i%2 ==0){ // 층이 짝수인지 홀수 인지 판단
                    start = 0;
                    end = w;
                    step = 1;
                }else {
                    start = w-1;
                    end = -1; // 이 end가 0이 된다면 아래의 j != end 기 때문에 0을 포함 못함 그래서 0보다 작은 -1
                    step = -1;
                }
                // 여기서 end쪽은 <,> 이런걸 쓰게 된다면 오류가 나거나 한 행 자체가 안나올듯
                for(int j = start; j != end; j+=step){
                    box[i][j] = (cur <= n) ? cur : -1;
                    cur++;
                }
        }
        int idxI = 0;
        int idxJ = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < w; j++){
                if(box[i][j] == num){
                    idxI = i;
                    idxJ = j;
                }
            }
        }
        for(int j = idxI; j < row; j++){
            if(box[j][idxJ] != -1){
                result++;
            }
        }
//        printBox(box);
        return result;
    }

    // 2차원 배열(box)을 표 형태로 보기 좋게 출력하는 메서드
    private void printBox(int[][] box) {
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[i].length; j++) {
                // printf: 형식(포맷)에 맞춰서 값을 바로 출력
                // %3d  -> 정수(d)를 최소 3칸 너비로 오른쪽 정렬해서 출력
                //         (자릿수 모자라면 앞에 공백으로 채워줌, 그래서 1과 12가 섞여도 줄이 안 삐뚤어짐)
                //         (여기서 %3d를 쓴 이유는 많아봐야 n이 100 까지니까 3자리면 충분
                // 맨 뒤 " " -> 숫자 사이 간격용 공백 한 칸
                System.out.printf("%3d ", box[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        택배상자꺼내기 s = new 택배상자꺼내기();
        System.out.println(s.solution(22,6,8)); //3
        System.out.println(s.solution(13,3,6)); //4
    }
}
