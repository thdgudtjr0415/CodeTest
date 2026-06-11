package programmers.basics.Day31;

import java.util.Arrays;

public class 배열의길이에따라다른연산하기 {
    public int[] solution(int[] arr, int n) {
        int[] result = arr.clone();
        if(result.length%2 !=0){
            for(int i = 0; i < result.length; i+=2){
                result[i] += n;
            }
        }else {
            for(int i = 1; i < result.length; i+=2){
                result[i] += n;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        배열의길이에따라다른연산하기 s = new 배열의길이에따라다른연산하기();
        System.out.println(Arrays.toString(s.solution(new int[]{49,12,100,276,33}, 27))); // 76,12,127,276,60
        System.out.println(Arrays.toString(s.solution(new int[]{444,555,666,777}, 100))); // 444,655,666,877
    }
}
