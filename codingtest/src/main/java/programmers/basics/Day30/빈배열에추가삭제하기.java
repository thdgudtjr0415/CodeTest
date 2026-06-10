package programmers.basics.Day30;

import java.util.ArrayList;
import java.util.Arrays;

public class 빈배열에추가삭제하기 {
    public int[] solution(int[] arr, boolean[] flag) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < arr.length; i++){
            if(flag[i]){
                for(int j = 0; j < arr[i]*2; j++) list.add(arr[i]);
            }else {
                for(int j = 0; j < arr[i]; j++) list.remove(list.size()-1);
            }
        }
//        int[] result = new int[list.size()];
//        for(int i = 0; i < list.size(); i++) result[i] = list.get(i);
        // ArrayList<Integer>의 데이터들을 한 줄 기차(스트림)로 세우고
        int[] result = list.stream()
                .mapToInt(Integer::intValue)     // 래퍼(감싸는) 객체 상자(Integer)를 까서 순수한 숫자 알맹이(int)로 변환한 뒤
                .toArray();                      // 벨트 위를 흘러가던 int 값들을 모아서 최종 int[] 배열로 굳혀서 완성!
        return result;
    }
    public static void main(String[] args) {
        빈배열에추가삭제하기 s = new 빈배열에추가삭제하기();
        System.out.println(Arrays.toString(s.solution(
                new int[]{3,2,4,1,3}, new boolean[]{true,false,true,false,false})));//3,3,3,3,4,4,4,4

    }
}
