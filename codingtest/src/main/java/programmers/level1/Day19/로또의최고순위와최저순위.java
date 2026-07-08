package programmers.level1.Day19;

import java.util.Arrays;

public class 로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] rank = {6, 6, 5, 4, 3, 2, 1}; // 등수를 나타내는 배열
        int count = 0;
        int zero = 0;
        int sum = 0;
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0){
                zero++;
            }
            for(int j = 0; j < win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    count++;
                }
            }
        }
        if(count + zero > 6){
            sum = 6;
        }else {
            sum = count + zero;
        }
        return new int[]{rank[sum], rank[count]};
    }
    public static void main(String[] args){
        로또의최고순위와최저순위 s = new 로또의최고순위와최저순위();
        System.out.println(Arrays.toString(s.solution(new int[]{44,1,0,0,31,25}, new int[]{31,10,45,1,6,19}))); // 3,5
        System.out.println(Arrays.toString(s.solution(new int[]{0,0,0,0,0,0}, new int[]{38, 19, 20, 40, 15, 25}))); // 1,6
        System.out.println(Arrays.toString(s.solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35}))); // 1,1
    }
}