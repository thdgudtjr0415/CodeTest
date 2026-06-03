package programmers.basics.Day23;

import java.util.Arrays;

public class n번째원소까지 {
    public int[] solution(int[] num_list, int n) {
        int[] result = new int[n];
        for(int i = 0; i < n; i++) result[i] = num_list[i];
        return result;
    }
    public static void main(String[] args) {
        n번째원소까지 s = new n번째원소까지();
        System.out.println(Arrays.toString(s.solution(new int[]{2,1,6},1))); //2
        System.out.println(Arrays.toString(s.solution(new int[]{5,2,1,7,5},3))); //5,2,1
    }
}
