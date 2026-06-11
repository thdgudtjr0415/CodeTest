package programmers.basics.Day31;

import java.util.Arrays;

public class 뒤에서5등까지 {
    public int[] solution(int[] num_list) {
        int[] result = new int[5];
        Arrays.sort(num_list);
        for(int i = 0; i < result.length; i++){
            result[i] = num_list[i];
        }
        return result;
    }
    public static void main(String[] args) {
        뒤에서5등까지 s = new 뒤에서5등까지();
        System.out.println(Arrays.toString(s.solution(new int[]{12,4,15,46,38,1,14}))); //1,4,12,14,15
    }
}
