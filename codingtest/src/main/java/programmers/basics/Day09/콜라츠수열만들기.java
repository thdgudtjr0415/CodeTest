package programmers.basics.Day09;

import java.util.ArrayList;
import java.util.Arrays;

public class 콜라츠수열만들기 {
    public int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(n);
        while(n > 1){
            if(n % 2 == 0){
                n = n / 2;
            }else {
                n = 3 * n + 1;
            }
            list.add(n);
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }

        return result;
    }
    public static void main(String[] args){
        콜라츠수열만들기 s = new 콜라츠수열만들기();
        System.out.println(Arrays.toString(s.solution(10))); //10,5,16,8,4,2,1
    }
}
