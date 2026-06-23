package programmers.level1.Day05;

import java.util.Arrays;
import java.util.ArrayList;

public class 같은숫자는싫어 {
    public int[] solution1(int []arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(arr[0]);
        for(int i = 1; i < arr.length; i++){
            if (list.get(list.size() - 1) != arr[i]) {
                list.add(arr[i]);
            }
        }
//        int[] answer = new int[list.size()];
//        for(int i = 0; i < list.size(); i++){
//            answer[i] = list.get(i);
//        }
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    public int[] solution2(int []arr) {
        int size = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] != arr[i-1]){
                size++;
            }
        }
        int[] answer = new int[size];
        answer[0] = arr[0];
        int idx = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i-1] != arr[i]){
                answer[idx++] = arr[i];
            }
        }

        return answer;
    }
    public static void main(String[] args){
        같은숫자는싫어 s = new 같은숫자는싫어();
        System.out.println(Arrays.toString(s.solution1(new int[]{1,1,3,3,0,1,1}))); // 1,3,0,1
        System.out.println(Arrays.toString(s.solution1(new int[]{4,4,4,3,3}))); // 4,3

        System.out.println(Arrays.toString(s.solution2(new int[]{1,1,3,3,0,1,1}))); // 1,3,0,1
        System.out.println(Arrays.toString(s.solution2(new int[]{4,4,4,3,3}))); // 4,3
    }
}
