package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;

// 지금 상황을 보면 [[1, 4], [3, 2], [4, 1]]  // 	[[3, 3], [3, 3]]
// {1,4} 일때 {1*3 + 4*3} , {1*3 + 4*3}
// [[2, 3, 2], [4, 2, 4], [3, 1, 4]] //	[[5, 4, 3], [2, 4, 1], [3, 1, 1]]
// {2,3,2} 일때 2×5 + 3×2 + 2×3 = 22 즉 1행이라면 arr2에서 각 첫번재것들만 곱합

public class 행렬의곱셈 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 여기서 열에 대한 개수는 arr2에서 가져오는게 맞은 곱한 개수에 대한 결과가 arr2에서 나오기 떄문
        int[][] answer = new int[arr1.length][arr2[0].length];

        // 어렵게 생각하지 말고 천천히 계산하는 방향으로
        // 전체 순회
        for(int i = 0; i < arr1.length; i++){
            // 각 arr1[i][j] 의 해당하는 인덱스 마다 arr2[j][k] 곱해주고
            // 그것에 해당하는 anawer[i][k]에 +=로 넣어주면 해결
            for(int j = 0; j < arr1[i].length; j++){
                for(int k = 0; k < arr2[j].length; k++){
                    answer[i][k] += arr1[i][j] * arr2[j][k];
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        행렬의곱셈 s = new 행렬의곱셈();
        System.out.println(Arrays.deepToString(s.solution(
                new int[][]{{1,4},{3,2},{4,1}},
                new int[][]{{3,3},{3,3}}))); //[[15, 15], [15, 15], [15, 15]]
        System.out.println(Arrays.deepToString(s.solution(
                new int[][]{{2,3,2},{4,2,4},{3,1,4}},
                new int[][]{{5,4,3},{2,4,1},{3,1,1}}))); //[[22, 22, 11], [36, 28, 18], [29, 20, 14]]

        System.out.println(Arrays.deepToString(s.solution(
                new int[][]{{1,2},{3,4},{5,6}},
                new int[][]{{1,1,1,1},{2,2,2,2}})));
        // 기대값: [[5, 5, 5, 5], [11, 11, 11, 11], [17, 17, 17, 17]]
        // (arr1: 3행 2열, arr2: 2행 4열 -> 결과는 3행 4열이어야 함, 정사각형 아닌 케이스 검증용)
    }
}
