package programmers.basics.Day19;

import java.util.ArrayList;
import java.util.Arrays;

public class 배열만들기_01 {
    public int[] solution(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = k; i <= n; i+=k){
            list.add(i);
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
    public static void main(String[] args) {
        배열만들기_01 s = new 배열만들기_01();
        System.out.println(Arrays.toString(s.solution(10,3))); // 3, 6, 9
        System.out.println(Arrays.toString(s.solution(15,5))); // 5, 10, 15
    }
}
