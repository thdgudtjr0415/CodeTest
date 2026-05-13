package programmers.basics.Day07;

import java.util.Arrays;

public class 마지막두원소 {
    public int[] solution(int[] num_list) {
        int[] result = new int[num_list.length+1];

        for(int i=0;i<num_list.length;i++){
            result[i]=num_list[i];
        }

        if(num_list[num_list.length-1] > num_list[num_list.length-2]){
            result[result.length-1] = num_list[num_list.length-1] - num_list[num_list.length-2];
        }else {
            result[result.length-1] = num_list[num_list.length-1]*2;
        }

        return result;
    }
    public static void main(String[] args) {
        마지막두원소 s = new 마지막두원소();
        System.out.println(Arrays.toString(s.solution(new int[]{2, 1, 6}))); //2,1,6,5
        System.out.println(Arrays.toString(s.solution(new int[]{5,2,1,7,5}))); //5,2,1,7,5,10

    }
}
