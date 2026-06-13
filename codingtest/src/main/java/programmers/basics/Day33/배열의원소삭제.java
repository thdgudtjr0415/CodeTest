package programmers.basics.Day33;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class 배열의원소삭제 {
    public int[] solution1(int[] arr, int[] delete_list) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < arr.length; i++) list.add(arr[i]);
        for(int i = 0; i < delete_list.length;i++) {
            if(list.contains(delete_list[i])) {
                list.remove(Integer.valueOf(delete_list[i]));
            }
        }
        int[] result = new int [list.size()];
        for(int i=0;i<list.size();i++) result[i] = list.get(i);
        return result;
    }
    public int[] solution2(int[] arr, int[] delete_list) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> deleteSet = new HashSet<>();
        for(int i = 0; i < delete_list.length; i++) deleteSet.add(delete_list[i]);
        for(int i = 0; i < arr.length; i++){
            if(!deleteSet.contains(arr[i])){
                list.add(arr[i]);
            }
        }
        int[] result = new int [list.size()];
        for(int i=0;i<list.size();i++) result[i] = list.get(i);
        return result;
    }
    public static void main(String[] args) {
        배열의원소삭제 s = new 배열의원소삭제();
        System.out.println(Arrays.toString(s.solution1(new int[]{293,1000,395,678,94},
                new int[]{94,777,104,1000,1,12})));//293,395,678
        System.out.println(Arrays.toString(s.solution1(new int[]{110, 66, 439, 785, 1},
                new int[]{377, 823, 119, 43})));//110, 66, 439, 785, 1
        System.out.println(Arrays.toString(s.solution2(new int[]{293,1000,395,678,94},
                new int[]{94,777,104,1000,1,12})));//293,395,678
        System.out.println(Arrays.toString(s.solution2(new int[]{110, 66, 439, 785, 1},
                new int[]{377, 823, 119, 43})));//110, 66, 439, 785, 1
    }
}
