package programmers.beginner.Day16;

import java.util.Arrays;

public class 가장큰수찾기 {
    public int[] solution(int[] array) {
        int[] result = new int[2];
        int max = 0;
        int index = 0;

        for(int i = 0; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
                index = i;
            }
        }
        result[0] = max;
        result[1] = index;

        return result;
    }
    public static void main(String[] args) {
        가장큰수찾기 s = new 가장큰수찾기();
        System.out.println(Arrays.toString(s.solution(new int[]{1, 8, 3}))); // 8,1
        System.out.println(Arrays.toString(s.solution(new int[]{9, 10, 11, 8}))); // 11, 2
    }
}
