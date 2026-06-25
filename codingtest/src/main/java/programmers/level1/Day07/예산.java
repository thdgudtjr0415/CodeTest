package programmers.level1.Day07;

import java.util.Arrays;

public class 예산 {
    public int solution(int[] d, int budget) {
        int result = 0;
        Arrays.sort(d);
        for(int i = 0; i < d.length; i++){
            // 여기서는 버짓에서 빼는 방식으로 하는게 편할듯
            if(d[i]<= budget){
                // 이렇게 하면 버짓이 새롭게 업데이트 되니까 반복문 돌면서 크거나 작은 경우를 다 맞게 돌아감
                budget -= d[i];
                result++;
            }else {
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        예산 s = new 예산();
        System.out.println(s.solution(new int[]{1,3,2,5,4},9)); //3
        System.out.println(s.solution(new int[]{2,2,3,3},10)); //4
    }
}
