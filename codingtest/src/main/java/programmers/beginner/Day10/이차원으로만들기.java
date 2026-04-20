package programmers.beginner.Day10;

// 정수 배열 num_list와 정수 n이 매개변수로 주어집니다. num_list를
// 다음 설명과 같이 2차원 배열로 바꿔 return하도록 solution 함수를 완성해주세요.
// num_list가 [1, 2, 3, 4, 5, 6, 7, 8] 로 길이가 8이고 n이 2이므로 num_list를 2 * 4 배열로 다음과 같이 변경합니다.
// 2차원으로 바꿀 때에는 num_list의 원소들을 앞에서부터 n개씩 나눠 2차원 배열로 변경합니다.
//        num_list	        n	             result
//[1, 2, 3, 4, 5, 6, 7, 8]	2	[[1, 2], [3, 4], [5, 6], [7, 8]]

import java.util.Arrays;

public class 이차원으로만들기 {
    public int[][] solution(int[] num_list, int n) {
        // 지금 문제보면 num_list 의 길이 /n 과 n 만큼의 배열이 나옴(문제에 배수라고 적혀있음)
        int[][] result = new int[num_list.length/n][n];

        // 여긴 이중for문으로 적당히 돌린다음
        for(int i = 0; i < num_list.length/n; i++){
            for(int j = 0; j < n; j++){
                // 여기가 좀 막혔는데 (i*n)+j 이걸 잘 기억하자
                // 지금 아래는 [0][0] , [0][1] 다음을 생각을 해야 위에 수식이 나옴
                result[i][j] = num_list[(i*n)+j];
            }
        }

        return result;
    }
    public static void main(String[] args) {
        이차원으로만들기 a = new 이차원으로만들기();
        System.out.println(Arrays.deepToString(a.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 2)));
        System.out.println(Arrays.deepToString(a.solution(new int[]{100, 95, 2, 4, 5, 6, 18, 33, 948}, 3)));
    }

}
// int, String 등 기본값 반환 → println 바로 사용 ✅
//System.out.println(s.solution(...));  // 3
// 1차원 배열 반환 → Arrays.toString() 필요
//System.out.println(Arrays.toString(s.solution(...)));  // [1, 2, 3]
// 2차원 배열 반환 → Arrays.deepToString() 필요
//System.out.println(Arrays.deepToString(s.solution(...)));  // [[1, 2], [3, 4]]

