package programmers.basics.Day09;

import java.util.ArrayList;
import java.util.Arrays;

public class 배열만들기_04 {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 0;
        while(i < arr.length){
            if(list.isEmpty()){
                list.add(arr[i]);
                i += 1;
            }else {
                if(list.get(list.size()-1) < arr[i]){
                    list.add(arr[i]);
                    i += 1;
                }else if(list.get(list.size()-1) >= arr[i]) {
                    list.remove(list.size()-1);
                }
            }
        }

        int[] stk = new int[list.size()];
        for(int j = 0; j < list.size(); j++){
            stk[j] = list.get(j);
        }

        return stk;
    }
    public static void main(String[] args) {
        배열만들기_04 s = new 배열만들기_04();
        System.out.println(Arrays.toString(s.solution(new int[]{1, 4, 2, 5, 3}))); //1,2,3
    }
}
