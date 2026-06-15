package programmers.basics.Day35;

import java.util.Arrays;

public class 조건에맞게수열변환하기_03 {
    public int[] solution(int[] arr, int k) {
        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            if(k%2!=0){
                result[i] = arr[i]*k;
            }else {
                result[i] = arr[i]+k;
            }
        }
        return result;
    }
    public static void main(String[] args){
        조건에맞게수열변환하기_03 s = new 조건에맞게수열변환하기_03();
        System.out.println(Arrays.toString(s.solution(new int[]{1, 2, 3, 100, 99, 98}, 3)));//3,6,9,300,297,294
        System.out.println(Arrays.toString(s.solution(new int[]{1, 2, 3, 100, 99, 98}, 2)));//3,4,5,102,101,100
    }
}
