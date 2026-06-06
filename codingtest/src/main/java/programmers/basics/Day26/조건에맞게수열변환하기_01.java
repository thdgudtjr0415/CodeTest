package programmers.basics.Day26;

import java.util.Arrays;

public class 조건에맞게수열변환하기_01 {
    public int[] solution(int[] arr) {
        int[] result = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            if(num >= 50 && num%2==0){
                result[i] = arr[i]/2;
            }else if(num < 50 && num%2!=0){
                result[i] = arr[i]*2;
            }else {
                result[i] = arr[i];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        조건에맞게수열변환하기_01 s = new 조건에맞게수열변환하기_01();
        System.out.println(Arrays.toString(s.solution(new int[]{1, 2, 3, 100, 99, 98})));//2,2,6,50,99,49
    }
}
