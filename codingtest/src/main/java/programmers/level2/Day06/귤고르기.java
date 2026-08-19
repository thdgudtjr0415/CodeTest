package programmers.level2.Day06;

// 종류의 최소화를 기준으로 작업을 시행해야함
//1 ≤ k ≤ tangerine의 길이 ≤ 100,000
//1 ≤ tangerine의 원소 ≤ 10,000,000
// Hashset
// keySet(), values(), entrySet()

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 귤고르기 {
    public int solution1(int k, int[] tangerine) {
        int result = 0;
        // 각 번호가 몇번 나왔는지 체크하기
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int i = 0; i < tangerine.length; i++){
            if(!(countMap.containsKey(tangerine[i]))){
                countMap.put(tangerine[i], 1);
            }else {
                countMap.put(tangerine[i], countMap.get(tangerine[i]) + 1);
            }
        }
        // 여기 부분에서 종류 최소화를 시작
        int idx = 0;
        int[][] tangerineArray = new int [countMap.size()][2];
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()){
            int size = entry.getKey();
            int count =  entry.getValue();
            tangerineArray[idx][0] = size;
            tangerineArray[idx][1] = count;
            idx++;
        }
        for(int i = 0; i < tangerineArray.length; i++){
            for(int j = i+1; j < tangerineArray.length; j++){
                if(tangerineArray[i][1] < tangerineArray[j][1]){
                    int[] temp = tangerineArray[i];
                    tangerineArray[i] = tangerineArray[j];
                    tangerineArray[j] = temp;
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < tangerineArray.length; i++){
            if(sum < k){
               sum += tangerineArray[i][1];
               result++;
            }else {
                break;
            }
        }
        return result;
    }
    public int solution2(int k, int[] tangerine) {
        int result = 0;
        // 각 번호가 몇번 나왔는지 체크하기
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int i = 0; i < tangerine.length; i++){
            if(!(countMap.containsKey(tangerine[i]))){
                countMap.put(tangerine[i], 1);
            }else {
                countMap.put(tangerine[i], countMap.get(tangerine[i]) + 1);
            }
        }
        // 여기 부분에서 종류 최소화를 시작
        // 여기서 굳이 2차원 배열이 필요할까? key, value중에 value만 쓰는데
        int idx = 0;
        int[] counts = new int [countMap.size()];
        for(int count : countMap.values()){
            counts[idx++] = count;
        }
        // 정렬하고 거꾸로 해보자
        Arrays.sort(counts);
        int sum = 0;
        for(int i = counts.length - 1; i >= 0; i--){
            if(sum < k){
                sum += counts[i];
                result++;
            }else  {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        귤고르기 s = new 귤고르기();
        System.out.println(s.solution1(6,new int[]{1, 3, 2, 5, 4, 5, 2, 3})); //3
        System.out.println(s.solution1(4,new int[]{1, 3, 2, 5, 4, 5, 2, 3})); //2
        System.out.println(s.solution1(2,new int[]{1, 1, 1, 1, 2, 2, 2, 3})); //1

        System.out.println(s.solution2(6,new int[]{1, 3, 2, 5, 4, 5, 2, 3})); //3
        System.out.println(s.solution2(4,new int[]{1, 3, 2, 5, 4, 5, 2, 3})); //2
        System.out.println(s.solution2(2,new int[]{1, 1, 1, 1, 2, 2, 2, 3})); //1
    }
}
