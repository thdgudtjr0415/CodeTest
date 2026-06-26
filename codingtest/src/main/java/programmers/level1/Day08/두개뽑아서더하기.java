package programmers.level1.Day08;

import java.util.Arrays;
import java.util.HashSet;

// hashset, hashmap 의 차이는 둘다 고유의 값들 즉 중복되지 않게 하려는 건데 map은 키와 밸류로 이뤄져있음

public class 두개뽑아서더하기 {
    public int[] solution1(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++ ){
                set.add(numbers[i]+numbers[j]);
            }
        }
//        int[] result = set.stream().mapToInt(Integer::intValue).toArray(); // 이거 왜워두기***
        int[] result = new int[set.size()];
        int i = 0;
        for(int num : set){
            result[i++] = num;
        }
        Arrays.sort(result);
        return result;
    }
    public int[] solution2(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++ ){
                set.add(numbers[i]+numbers[j]);
            }
        }
        int[] result = set.stream().mapToInt(Integer::intValue).toArray(); // 이거 왜워두기***
//        // 선택 정렬
//        for(int i = 0; i < result.length; i++){
//            for(int j = i + 1; j < result.length; j++ ){
//                if(result[j] < result[i]){
//                    int temp = result[j];
//                    result[j] =  result[i];
//                    result[i] = temp;
//                }
//            }
//        }
        // 버블정렬 오름차순
        for(int i = 0; i < result.length-1; i++){ //버블정렬의 마지막-1 번째에서 끝남 둘이 교환하고 끝이기 때문에
            for(int j = 0; j < result.length-i-1; j++){
                if(result[j] > result[j+1]){
                    int temp = result[j];
                    result[j] =  result[j+1];
                    result[j+1] = temp;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        두개뽑아서더하기 s = new 두개뽑아서더하기();
        System.out.println(Arrays.toString(s.solution1(new int[]{2,1,3,4,1})));//2,3,4,5,6,7
        System.out.println(Arrays.toString(s.solution1(new int[]{5,0,2,7})));//2,5,7,9,12
        System.out.println(Arrays.toString(s.solution2(new int[]{2,1,3,4,1})));//2,3,4,5,6,7
        System.out.println(Arrays.toString(s.solution2(new int[]{5,0,2,7})));//2,5,7,9,12
    }
}
