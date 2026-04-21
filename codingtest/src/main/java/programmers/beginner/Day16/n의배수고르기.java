package programmers.beginner.Day16;

import java.util.ArrayList;
import java.util.Arrays;

public class n의배수고르기 {
    public int[] solution(int n, int[] numlist) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < numlist.length; i++){
            if(numlist[i]%n == 0){
                list.add(numlist[i]);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    public static void main(String[] args) {
        n의배수고르기 s = new n의배수고르기();
        System.out.println(Arrays.toString(
                s.solution(3, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12}))); // 6,9,12
        System.out.println(Arrays.toString(
                s.solution(5, new int[]{1, 9, 3, 10, 13, 5}))); // 10,5
        System.out.println(Arrays.toString(
                s.solution(12, new int[]{2, 100, 120, 600, 12, 12}))); // 120,600,12,12
    }
}
