package programmers.basics.Day30;

import java.util.ArrayList;
import java.util.Arrays;

public class 배열만들기_06 {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 0;
        while(i < arr.length){
            if(list.isEmpty()){
                list.add(arr[i]);
                i++;
            }else if(!list.isEmpty() && list.get(list.size()-1) == arr[i]){
                list.remove(list.size()-1);
                i++;
            }else if(!list.isEmpty() && list.get(list.size()-1) != arr[i]){
                list.add(arr[i]);
                i++;
            }
        }
        if(list.isEmpty()){
            return new int[]{-1};
        }
//        int[] stk = new int[list.size()];
//        for(int j=0;j<list.size();j++) stk[j]=list.get(j);
        int[] stk = list.stream().mapToInt(Integer::intValue).toArray();
        return stk;
    }
    public static void main(String[] args) {
        배열만들기_06 s = new 배열만들기_06();
        System.out.println(Arrays.toString(s.solution(new int[]{0,1,1,1,0})));//0,1,0
        System.out.println(Arrays.toString(s.solution(new int[]{0,1,0,1,0})));//0,1,0,1,0
        System.out.println(Arrays.toString(s.solution(new int[]{0,1,1,0})));//-1
    }
}
