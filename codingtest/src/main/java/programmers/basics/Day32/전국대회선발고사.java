package programmers.basics.Day32;

import java.util.Arrays;

public class 전국대회선발고사 {
    public int solution(int[] rank, boolean[] attendance) {
        int len = 0;
        for(int i = 0; i < attendance.length; i++) if(attendance[i]) len++;
        int[] arr1 = new int[len];
        int idx = 0;
        for(int i = 0; i < attendance.length; i++){
            if(attendance[i]){
                arr1[idx++] = rank[i];
            }
        }
        Arrays.sort(arr1);
        int[] arr2 = new int[3];
        for(int i = 0; i < 3; i++){
            int num = arr1[i];
            for(int j = 0; j < rank.length; j++){
                if(rank[j] == num){
                    arr2[i] = j;
                }
            }
        }
        int a = arr2[0];
        int b = arr2[1];
        int c = arr2[2];
        int result = 10000 * a + 100 * b + c;
        return result;
    }
    public static void main(String[] args) {
        전국대회선발고사 s = new 전국대회선발고사();
        System.out.println(s.solution(new int[]{3,7,2,5,4,6,1},
                new boolean[]{false, true, true, true, true, false, false})); //20403
        System.out.println(s.solution(new int[]{1,2,3},
                new boolean[]{true, true, true})); //102
        System.out.println(s.solution(new int[]{6,1,5,2,3,4},
                new boolean[]{true, false, true, false, false, true})); //50200
    }
}
