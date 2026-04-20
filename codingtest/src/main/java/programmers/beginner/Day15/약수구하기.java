package programmers.beginner.Day15;

import java.util.ArrayList;
import java.util.Arrays;

public class 약수구하기 {
    public int[] solution(int n) {
        // 얼마나 들어갈지 몰라서 ArrayList 사용
        ArrayList<Integer> list = new ArrayList<>();

        // %로 나눠서 나머지 0이면 약수
        for(int i = 1; i <= n; i++){
            if(n%i==0){
                list.add(i);
            }
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
    public static void main(String[] args) {
        약수구하기 s = new 약수구하기();
        System.out.println(Arrays.toString(s.solution(24))); // [1, 2, 3, 4, 6, 8, 12, 24]
        System.out.println(Arrays.toString(s.solution(29))); // [1, 29]
    }
}
