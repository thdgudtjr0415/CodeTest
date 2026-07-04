package programmers.level1.Day15;

import java.util.Arrays;

public class 과일장수 {
    public int solution(int k, int m, int[] score) {
        int result = 0;
        Arrays.sort(score);
        for(int i = score.length-m; i >= 0; i-=m){
            if(score[i] <= k){
                result += score[i]*m;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        과일장수 s = new 과일장수();
        System.out.println(s.solution(3,4, new int[]{1,2,3,1,2,3,1})); // 8
        System.out.println(s.solution(4,3, new int[]{4,1,2,2,4,4,4,4,1,2,4,2})); // 33
    }
}
