package programmers.basics.Day32;

import java.util.Arrays;

public class 뒤에서5등위로 {
    public int[] solution(int[] num_list) {
        int[] result = new int[num_list.length - 5];
        Arrays.sort(num_list);
        for(int i = 5; i < num_list.length; i++){
            result[i-5] = num_list[i];
        }
        return result;
    }
    public static void main(String[] args) {
        뒤에서5등위로 s = new 뒤에서5등위로();
        System.out.println(Arrays.toString(s.solution(
                new int[]{12, 4, 15, 46, 38, 1, 14, 56, 32, 10}))); //15,32,38,46,56
    }
}
