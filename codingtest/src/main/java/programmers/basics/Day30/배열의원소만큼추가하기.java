package programmers.basics.Day30;

import java.util.Arrays;

public class 배열의원소만큼추가하기 {
    public int[] solution(int[] arr) {
        int len = 0;
        for(int i=0;i<arr.length;i++) len+=arr[i];
        int[] result = new int[len];
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i]; j++){
                result[index++] = arr[i];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        배열의원소만큼추가하기 s = new 배열의원소만큼추가하기();
        System.out.println(Arrays.toString(s.solution(new int[]{5,1,4})));
        System.out.println(Arrays.toString(s.solution(new int[]{6,6})));
        System.out.println(Arrays.toString(s.solution(new int[]{1})));
    }
}
