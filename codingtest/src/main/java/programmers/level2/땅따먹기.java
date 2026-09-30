package programmers.level2;

import java.util.Arrays;

public class 땅따먹기 {
    int solution1(int[][] land) {
        // 처음 배열을 복사해옴
        // 그 이유는 각 열마다의 최선을 비교해서 마지막에 4개를 비교할 예정
        int[] bestScore = land[0];

        for(int i = 1; i < land.length; i++){
            int[] temp = new int[4];
            temp[0] = land[i][0] + Math.max(bestScore[1], Math.max(bestScore[2], bestScore[3]));
            temp[1] = land[i][1] + Math.max(bestScore[0], Math.max(bestScore[2], bestScore[3]));
            temp[2] = land[i][2] + Math.max(bestScore[0], Math.max(bestScore[1], bestScore[3]));
            temp[3] = land[i][3] + Math.max(bestScore[0], Math.max(bestScore[1], bestScore[2]));
            bestScore = temp;
        }

        return Arrays.stream(bestScore).max().getAsInt();
    }
    // 코드리뷰
    // 1. land[0] 이렇게 바로 복사 했는데 이런 습관은 별로 여서 .clone()하는 버릇 가지기
    // 2. 비슷한 코드 4줄을 줄일 수 있을까?
    int solution2(int[][] land) {
        // 처음 배열을 복사해옴
        // 그 이유는 각 열마다의 최선을 비교해서 마지막에 4개를 비교할 예정
        int[] bestScore = land[0];

        for(int i = 1; i < land.length; i++){
            int[] temp = new int[4];
            for(int j = 0; j < 4; j++){
                temp[j] = land[i][j] + maxExcept(bestScore, j);
            }
            bestScore = temp;
        }

        return Arrays.stream(bestScore).max().getAsInt();
    }

    private int maxExcept(int[] bestScore, int exceptIdx) {
        int max = 0;
        for(int i = 0; i < bestScore.length; i++){
            if(i != exceptIdx){
                max = Math.max(max, bestScore[i]);
            }
        }
        return max;
    }

    public static void main(String[] args){
        땅따먹기 s = new 땅따먹기();
//        System.out.println(s.solution1(new int[][]{
//                {1,2,3,5},
//                {5,6,7,8},
//                {4,3,2,1}})); //16
        System.out.println(s.solution2(new int[][]{
                {1,2,3,5},
                {5,6,7,8},
                {4,3,2,1}})); //16
    }
}
