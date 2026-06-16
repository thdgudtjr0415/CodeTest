package programmers.basics.Day36;

/*
* 0 ≤ i, j < n인 정수 i, j에 대하여 arr[i][j] = arr[j][i]
* 1 ≤ arr의 길이 = arr의 원소의 길이 ≤ 100
* 1 ≤ arr의 원소의 원소 ≤ 1,000
* 모든 arr의 원소의 길이는 같습니다.
* */

public class 특별한이차원배열_02 {
    public int solution(int[][] arr) {
        int n =  arr.length;
        int result = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] != arr[j][i]){
                    return 0;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        특별한이차원배열_02 s = new 특별한이차원배열_02();
        System.out.println(s.solution(new int[][]{{5,192,33},{192,72,95},{33,95,999}}));//1
        System.out.println(s.solution(
                new int[][]{{19, 498, 258, 587},{63, 93, 7, 754},{258, 7, 1000, 723},{587, 754, 723, 81}}));//0
    }
}
