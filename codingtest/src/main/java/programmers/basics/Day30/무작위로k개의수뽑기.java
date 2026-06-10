package programmers.basics.Day30;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class 무작위로k개의수뽑기 {
    public int[] solution(int[] arr, int k) {
        // 여기서 LinkedHashSet은 중복을 걸러주는 자료 구조
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
//        for(int i=0;i<arr.length;i++) set.add(arr[i]); 이렇게 하면 모든 자료 구조가 중복 안되고 저장됨
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
            if(set.size() == k){
                break;
            }
        }
        int[] result = new int[k];
        Arrays.fill(result,-1); // 일단 모두 -1로 채움
        int idx = 0;
        for (int num : set) {     // set에 있는 모든 자료구조를 int num이라는 곳에 넣음
            result[idx++] = num;  // num을 result[idx]에 넣고, idx는 다음 칸으로(+1) 이동
        }
        return result;
    }
    public static void main(String[] args) {
        무작위로k개의수뽑기 s = new 무작위로k개의수뽑기();
        System.out.println(Arrays.toString(s.solution(new int[]{0,1,1,2,2,3},3)));//0,1,2
        System.out.println(Arrays.toString(s.solution(new int[]{0,1,1,1,1},4)));//0,1,-1,-1
    }
}
