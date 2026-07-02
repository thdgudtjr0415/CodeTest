package programmers.level1.Day13;

import java.util.ArrayList;
import java.util.Arrays;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] human1 = {1, 2, 3, 4, 5};
        int[] human2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] human3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == human1[i%human1.length]) score1++;
            if(answers[i] == human2[i%human2.length]) score2++;
            if(answers[i] == human3[i%human3.length]) score3++;
        }
        int maxScore = Math.max(score1,Math.max(score2,score3));
        int[] score = new int[]{score1,score2,score3};
        int len = 0;
        for(int i = 0; i < score.length; i++){
            if(score[i] == maxScore){
                len++;
            }
        }
        int[] result = new int[len];
        int idx = 0;
        // 여기 범위 이상했음
        for(int i = 0; i < score.length; i++){
            if(score[i] == maxScore){
                result[idx++] = i+1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        모의고사 s = new 모의고사();
        System.out.println(Arrays.toString(s.solution(new int[]{1,2,3,4,5}))); //1
        System.out.println(Arrays.toString(s.solution(new int[]{1,3,2,4,2}))); //1,2,3
    }
}
