package programmers.basics.Day23;

import java.util.Arrays;

public class n번째원소부터 {
    public int[] solution(int[] num_list, int n) {
        int[] result = new int[num_list.length - n + 1];
        int idx = 0;
        for(int i = n-1; i <num_list.length; i++){
            result[idx++] = num_list[i];
        }
        return result;
    }
    public static void main(String[] args) {
        n번째원소부터 s = new n번째원소부터();
        System.out.println(Arrays.toString(s.solution(new int[]{2,1,6}, 3)));
        System.out.println(Arrays.toString(s.solution(new int[]{5,2,1,7,5}, 2)));
    }

}
