package programmers.basics.Day23;

import java.util.Arrays;

public class n개간격의원소들 {
    public int[] solution(int[] num_list, int n) {
        int size = (num_list.length-1)/n + 1;
        int[] result = new int[size];
        for(int i = 0; i < size; i++){
            result[i] = num_list[i*n];
        }
        return result;
    }
    public static void main(String[] args){
        n개간격의원소들 s = new n개간격의원소들();
        System.out.println(Arrays.toString(s.solution(new int[]{4,2,6,1,7,6},2)));//4,6,7
        System.out.println(Arrays.toString(s.solution(new int[]{4,2,6,1,7,6},4)));//4,7
    }
}
