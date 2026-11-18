package programmers.level2.정렬_그리디;

// xor 두수를 이진수로 바꿔서 각 자리마다 비교, 같으면 0, 다르면 1을 반환
//col 번째의 컬럼의 값으로 정렬을 해야해 sort, compare 로 하면 될것 같고(오름차순)
//값이 동일하면 기본키인 첫번째 컬럼의 값을 기준으로 내림차순
//여기서 정의하는 S_i를 가지고 각 i번재의 행에 대해서 각 컬럼들을 i로 나눈 나머지들의 함으로 정의
//예시의 기준은 begin 부터 end 가 2 ~ 3 이니까 {2, 2, 6}, {1, 5, 10}
//S_2 = (2 mod 2) + (2 mod 2) + (6 mod 2) = 0
//S_3 = (1 mod 3) + (5 mod 3) + (10 mod 3) = 4
// 결과는 0 xor 4 하면 000 , 100 -> 100 으로 반환, 100은 4
// 자바에서는 xor 이 ^ 이거로 연산하면됨

// compareTo
//"A".compareTo("B")  음수: A가 B보다 앞이다
//"B".compareTo("B")  0   : 둘이 같다
//"C".compareTo("B")  양수: C가 B보다 뒤다

import java.util.Arrays;

public class 테이블해시함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
//        int answer = 0;
        // 컬럼 col로 data 오름차순 정렬 하고 같으면 data[i][0] 으로 내림차순
        Arrays.sort(data, (a, b) ->{
            int x = a[col-1];
            int y = b[col-1];
            int xa = a[0];
            int yb = b[0];
            if(x != y){
                return x-y;
            }else {
                return yb-xa;
            }
        });
        int compareXOR = 0;
        for(int i = row_begin-1; i <= row_end-1; i++){
            int num = 0;
            for(int j = 0; j < data[i].length; j++){
                num += data[i][j] % (i+1);
            }
            compareXOR = compareXOR^num;
        }
        return compareXOR;
    }

    public static void main(String[] args) {
        테이블해시함수 s = new 테이블해시함수();
        System.out.println(s.solution(new int[][]{
                {2, 2, 6},
                {1, 5, 10},
                {4, 2, 9},
                {3, 8, 3}},
                2, 2, 3)); // 4
    }
}
