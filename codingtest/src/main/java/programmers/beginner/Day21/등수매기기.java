package programmers.beginner.Day21;

import java.util.Arrays;

public class 등수매기기 {
    public int[] solution(int[][] score) {
        int[] result = new int[score.length];

        // 일단 평균을 담을 그릇
        double[] grades = new double[score.length];
        for(int i=0;i<grades.length;i++){
            grades[i] = (double)(score[i][0]+score[i][1])/2;
        }

        for(int i = 0; i < score.length; i++){
            int rank = 1;
            for(int j=0; j < score.length; j++){
                if(grades[j] > grades[i]){
                    rank++;
                }
            }
            result[i] = rank;
        }

        return result;
    }

    public static void main(String[] args) {
        등수매기기 s = new 등수매기기();
        System.out.println(Arrays.toString(
                s.solution(new int[][]{{80, 70}, {90, 50}, {40, 70}, {50, 80}}))); // 1,2,4,3
        System.out.println(Arrays.toString(
                s.solution(new int[][]{{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}})));
        //4,4,6,2,2,1,7
    }
}
