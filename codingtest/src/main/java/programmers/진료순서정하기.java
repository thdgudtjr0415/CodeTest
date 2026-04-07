package programmers;

import java.util.Scanner;
import java.util.Arrays;

public class 진료순서정하기 {
    public int[] solution(int[] emergency) {
        int[] result = new int[emergency.length];
        // 의외로 그냥 rank를 ++ 해줘서 rank의 숫자를 늘려주면 되는 문제
        for(int i = 0; i < emergency.length; i++){
            int rank = 1;
            for(int j = 0; j < emergency.length; j++){
                if(emergency[j] > emergency[i]){
                    rank++;
                }
            }
            result[i] = rank;
        }

        return result;
    }

    public static void main(String[] args) {
        진료순서정하기 p = new 진료순서정하기();

        System.out.println(Arrays.toString(p.solution(new int[]{3, 76, 24})));
        System.out.println(Arrays.toString(p.solution(new int[]{1, 2, 3, 4, 5, 6, 7})));
        System.out.println(Arrays.toString(p.solution(new int[]{30, 10, 23, 6, 100})));
    }
}