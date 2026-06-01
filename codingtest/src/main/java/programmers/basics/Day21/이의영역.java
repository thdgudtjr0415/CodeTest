package programmers.basics.Day21;

import java.util.ArrayList;
import java.util.Arrays;

public class 이의영역 {
    public int[] solution1(int[] arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean flag = false;
        for(int i = 0;i < arr.length; i++){
            // flag = false 일때
            if(!flag){
                if(arr[i]==2) {
                    flag = true;
                    list.add(arr[i]);
                }
            }else {
                // 이건 true 일때
                list.add(arr[i]);
            }
        }
        // list에 쌓인 것이 없으면 -1 return
        if(list.size()==0) return new int[]{-1};
        while(list.get(list.size()-1) != 2){
            list.remove(list.size()-1);
        }
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++) result[i] = list.get(i);
        return result;
    }
    public int[] solution2(int[] arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int num :  arr) list.add(num);
        int firstIdx = list.indexOf(2);
        int lastIdx = list.lastIndexOf(2);
        // 첫번째 인덱스에 아무것도 없으면 -1 뱉게 함
        if(firstIdx == -1) return new int[]{-1};

        int[] result = new int[lastIdx - firstIdx + 1];
        int idx = 0;
        for(int i = firstIdx;i <= lastIdx; i++){
            result[idx++] = arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        이의영역 s = new 이의영역();
        System.out.println(Arrays.toString(s.solution1(new int[]{1,2,1,4,5,2,9}))); //2,1,4,5,2
        System.out.println(Arrays.toString(s.solution1(new int[]{1,2,1}))); // 2
        System.out.println(Arrays.toString(s.solution1(new int[]{1,1,1}))); // -1
        System.out.println(Arrays.toString(s.solution1(new int[]{1,2,1,2,1,10,2,1}))); // 2,1,2,1,10,2
        System.out.println();
        System.out.println(Arrays.toString(s.solution2(new int[]{1,2,1,4,5,2,9}))); //2,1,4,5,2
        System.out.println(Arrays.toString(s.solution2(new int[]{1,2,1}))); // 2
        System.out.println(Arrays.toString(s.solution2(new int[]{1,1,1}))); // -1
        System.out.println(Arrays.toString(s.solution2(new int[]{1,2,1,2,1,10,2,1}))); // 2,1,2,1,10,2
    }
}
