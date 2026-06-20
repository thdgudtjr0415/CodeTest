package programmers.level1.Day03;

import java.util.Arrays;

public class 나누어떨어지는숫자배열 {
    public int[] solution(int[] arr, int divisor) {
        int len = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i]%divisor==0){
                len++;
            }
        }
        if(len == 0){
            return new int[]{-1};
        }
        int[] answer = new int[len];
        int idx = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i]%divisor==0){
                answer[idx++] = arr[i];
            }
        }
        Arrays.sort(answer);
        return answer;
    }
    public static void main(String[] args) {
        나누어떨어지는숫자배열 s = new 나누어떨어지는숫자배열();
        System.out.println(Arrays.toString(s.solution(new int[]{5,9,7,10}, 5))); //5,10
        System.out.println(Arrays.toString(s.solution(new int[]{2,36,1,3}, 1))); //1,2,3,36
        System.out.println(Arrays.toString(s.solution(new int[]{3,2,6}, 10))); //-1
    }
}
