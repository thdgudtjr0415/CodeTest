package programmers.basics.Day12;

import java.util.ArrayList;
import java.util.Arrays;

public class 배열만들기_05 {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<intStrs.length;i++){
            int str = Integer.parseInt(intStrs[i].substring(s,s+l));
            if(str > k){
                list.add(str);
            }
        }
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++) result[i] = list.get(i);
        return result;
    }
    public static void main(String[] args){
        배열만들기_05 s = new 배열만들기_05();
        System.out.println(Arrays.toString(
                s.solution(new String[]{"0123456789", "9876543210", "9999999999999"},
                        50000, 5, 5))); // 56789,99999
    }
}
