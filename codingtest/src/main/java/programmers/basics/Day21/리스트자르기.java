package programmers.basics.Day21;

import java.util.ArrayList;
import java.util.Arrays;

public class 리스트자르기 {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        ArrayList<Integer> list = new ArrayList<>();
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        switch (n){
            case 1:
                for(int i=0;i <= b; i++) list.add(num_list[i]);
                break;
            case 2:
                for(int i = a; i < num_list.length; i++) list.add(num_list[i]);
                break;
            case 3:
                for(int i = a; i <= b; i++) list.add(num_list[i]);
                break;
            case 4:
                for(int i = a; i <= b; i+=c) list.add(num_list[i]);
                break;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
    public static void main(String[] args){
        리스트자르기 s = new 리스트자르기();
        System.out.println(Arrays.toString(
                s.solution(3, new int[]{1,5,2}, new int[]{1,2,3,4,5,6,7,8,9})));//2,3,4,5,6
        System.out.println(Arrays.toString(
                s.solution(4, new int[]{1,5,2}, new int[]{1,2,3,4,5,6,7,8,9})));//2,4,6
    }
}
