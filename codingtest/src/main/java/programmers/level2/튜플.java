package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 튜플 {
    public int[] solution(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 일반 버전
//        String[] arr1 = s.substring(1, s.length() - 1).replace("{","").replace("}","").split(",");
        // 정규표현식
        String[] arr1 = s.substring(1, s.length() - 1).replaceAll("[{}]","").split(",");
        // 원소 1개일때 예외로 처리 하지만 다른 곳에서 처리를 해줘서 필요 없는 줄이됨
//        if(arr1.length == 1){
//            return new int[]{Integer.parseInt(arr1[0])};
//        }
        // 여태 HashMap에 넣는 방식에서 getOrDefault를 사용하면 없으면 기본값으로 해줌
//        for(int i = 0; i < arr1.length; i++){
//            int num = Integer.valueOf(arr1[i]);
//            if(!map.containsKey(num)){
//                map.put(num, 1);
//            }else {
//                map.put(num, map.get(num)+1);
//            }
//        }

        for(int i = 0; i < arr1.length; i++){
            int num =  Integer.valueOf(arr1[i]);
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int[][] arr2 = new int[map.size()][2];
        int idx = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            arr2[idx][0] = entry.getKey();
            arr2[idx][1] = entry.getValue();
            idx++;
        }

        for(int i = 0; i < arr2.length; i++ ){
            for(int j = i+1; j < arr2.length; j++){
                if(arr2[i][1] < arr2[j][1]){
                    int[] temp = arr2[i];
                    arr2[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
        }
        int[] result = new int[arr2.length];
        for(int i = 0; i < arr2.length; i++){
            result[i] = arr2[i][0];
        }

//        System.out.println(Arrays.deepToString(arr2));
//        System.out.println(map.toString());
        return result;
    }

    public static void main(String[] args) {
        튜플 s = new 튜플();
        System.out.println(Arrays.toString(s.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"))); // 2,1,3,4
        System.out.println(Arrays.toString(s.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"))); // 2,1,3,4
        System.out.println(Arrays.toString(s.solution("{{20,111},{111}}"))); // 111,20
        System.out.println(Arrays.toString(s.solution("{{123}}"))); // 123
        System.out.println(Arrays.toString(s.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"))); // 3,2,4,1

        System.out.println(Arrays.toString(s.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"))); // 2,1,3,4
        System.out.println(Arrays.toString(s.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"))); // 2,1,3,4
        System.out.println(Arrays.toString(s.solution("{{20,111},{111}}"))); // 111,20
        System.out.println(Arrays.toString(s.solution("{{123}}"))); // 123
        System.out.println(Arrays.toString(s.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"))); // 3,2,4,1
    }
}
