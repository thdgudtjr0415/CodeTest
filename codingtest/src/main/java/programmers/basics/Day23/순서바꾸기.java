package programmers.basics.Day23;

import java.util.Arrays;

public class 순서바꾸기 {
    public int[] solution(int[] num_list, int n) {
        int[] result = new int [num_list.length];
        int idx = 0;
        for(int i = n; i < num_list.length ; i++){
            result[idx++] = num_list[i];
        }
        for(int i = 0; i < n ; i++){
            result[idx++] = num_list[i];
        }
        return result;
    }
    public static void main(String[] args){
        순서바꾸기 s = new 순서바꾸기();
        System.out.println(Arrays.toString(s.solution(new int[]{2,1,6}, 1)));//1,6,2
        System.out.println(Arrays.toString(s.solution(new int[]{5,2,1,7,5}, 3))); //7,5,5,2,1
    }
}
