package programmers.level1.Day17;

import java.util.Arrays;

public class 실패율 {
    public int[] solution(int N, int[] stages) {
        int[] result = new int[N];
        double[][] rankArr = new double[N][2];
        for(int i = 0; i < rankArr.length; i++) {
            int currentStage = i+1;
            rankArr[i][0] = currentStage;
            int failPlayer = 0;
            int player = 0;
            for(int j = 0; j < stages.length; j++) {
                if(stages[j] >= currentStage) player++;
                if(stages[j] == currentStage) failPlayer++;

            }
            if(player == 0){
                rankArr[i][1] = 0.0;
            }else {
                rankArr[i][1] = (double)failPlayer/player;
            }
        }
        for(int i = 0; i < rankArr.length; i++) {
            for(int j = i+1; j < rankArr.length; j++) {
                // 여기 if가 중요
                if (rankArr[j][1] > rankArr[i][1] ||
                        (rankArr[j][1] == rankArr[i][1] && rankArr[j][0] < rankArr[i][0])){
                    double[] temp = rankArr[i];
                    rankArr[i] = rankArr[j];
                    rankArr[j] = temp;
                }
            }
        }
        for(int i = 0; i < rankArr.length; i++) {
            result[i] = (int)rankArr[i][0];
        }
        return result;
    }
    public static void main(String[] args) {
        실패율 s = new 실패율();
        System.out.println(Arrays.toString(s.solution(5,new int[]{2,1,2,6,2,4,3,3})));//3,4,2,1,5
        System.out.println(Arrays.toString(s.solution(4,new int[]{4,4,4,4,4})));//4,1,2,3
    }
}
