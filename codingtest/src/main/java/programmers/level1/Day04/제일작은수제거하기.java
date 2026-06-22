package programmers.level1.Day04;

import java.util.Arrays;

public class 제일작은수제거하기 {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        if(answer.length==0){
            return new int[]{-1};
        }
        int min = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        int idx = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != min){
                answer[idx++] = arr[i];
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        제일작은수제거하기 s = new 제일작은수제거하기();
        System.out.println(Arrays.toString(s.solution(new int[]{4,3,2,1}))); //4,3,2
        System.out.println(Arrays.toString(s.solution(new int[]{10}))); //-1
    }
}
