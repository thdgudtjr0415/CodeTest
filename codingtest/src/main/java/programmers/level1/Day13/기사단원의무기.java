package programmers.level1.Day13;

import java.util.Arrays;

public class 기사단원의무기 {
    public int solution(int number, int limit, int power) {
        int result = 0;
        int[] arr = new int[number];
        for(int i = 1; i <= number; i++){
            int count = 0;
            for(int j = 1; j <= i; j++){
                if(i % j == 0){
                    count++;
                }
            }
            arr[i-1] = count;
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > limit){
                arr[i] = power;
            }
            result += arr[i];
        }
        return result;
    }

    public static void main(String[] args){
        기사단원의무기 s = new 기사단원의무기();
        System.out.println(s.solution(5,3,2)); //10
        System.out.println(s.solution(10,3,2)); //21
    }
}
