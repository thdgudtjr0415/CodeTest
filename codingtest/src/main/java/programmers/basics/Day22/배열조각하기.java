package programmers.basics.Day22;

import java.util.Arrays;

// 말장난 같지만 여기서 짝수 인덱스와 홀수 인덱스를 말하는 것은 query의 인덱스를 말함

public class 배열조각하기 {
    public int[] solution(int[] arr, int[] query) {
        int firstIdx = 0;
        int lastIdx = arr.length - 1;

        for(int i = 0; i < query.length ; i++){
            int num =  query[i];
            if(i%2 ==0){
                // 이거의 이유는 첫번째인덱스들의 변화가 이뤄질꺼기 때문에 firstIdx를 더해줘야함
                lastIdx = firstIdx + num;
            }else {
                firstIdx = firstIdx + num;
            }
        }
        int[] result = new int[lastIdx - firstIdx + 1];
        int idx = 0;
        for(int i = firstIdx; i <= lastIdx; i++) result[idx++] = arr[i];
        return result;
    }
    public static void main(String[] args){
        배열조각하기 s = new 배열조각하기();
        System.out.println(Arrays.toString(
                s.solution(new int[]{0,1,2,3,4,5}, new int[]{4,1,2})));//1,2,3
    }
}
