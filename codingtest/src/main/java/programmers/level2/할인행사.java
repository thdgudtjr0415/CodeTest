package programmers.level2;

import java.util.Arrays;

public class 할인행사 {
    // 원본 코드
    public int solution1(String[] want, int[] number, String[] discount) {
        int result = 0;
        for(int i = 0; i <= discount.length-10; i++){
            // 10개 씩 담을 배열 만들기
            String[] tenday = new String[10];
            // 이 배열은 원하는 제품의 개수가 같은지 확인하는 배열
            int[] wantNum = new int[number.length];
            // 10개 씩 배열 담기
            for(int j = 0; j < 10; j++){
                tenday[j] = discount[i+j];
            }
            // 이제 want에서 한개씩 뽑아서 개수가 같은지 확인
            for(int k = 0; k < want.length; k++){
                String temp = want[k];
                for(int l = 0; l < 10; l++){
                    if(temp.equals(tenday[l])){
                        wantNum[k]++;
                    }
                }
            }
            if(Arrays.equals(wantNum, number)){
                result++;
            }
        }
        return result;
    }
    // 코드 리뷰
    // tenday 배열이 꼭 필요할까? + Arrays.equals(arr1,arr2)를 사용했는데 이것도 굳이? 중간에 틀리면 break
    public int solution2(String[] want, int[] number, String[] discount) {
        int result = 0;
        for(int i = 0; i <= discount.length-10; i++){
            // 이 배열은 원하는 제품의 개수가 같은지 확인하는 배열
            int[] wantNum = new int[number.length];
            boolean flag = true;
            // 이제 want에서 한개씩 뽑아서 개수가 같은지 확인
            for(int k = 0; k < want.length; k++){
                String temp = want[k];
                for(int l = 0; l < 10; l++){
                    if(temp.equals(discount[i+l])){
                        wantNum[k]++;
                    }
                }
                if(wantNum[k] != number[k]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args){
        할인행사 s = new 할인행사();
        System.out.println(s.solution1(
                new String[]{"banana", "apple", "rice", "pork", "pot"},
                new int[]{3, 2, 2, 2, 1},
                new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"})); // 3
        System.out.println(s.solution1(
                new String[]{"apple"},
                new int[]{10},
                new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"})); // 0

        System.out.println(s.solution2(
                new String[]{"banana", "apple", "rice", "pork", "pot"},
                new int[]{3, 2, 2, 2, 1},
                new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"})); // 3
        System.out.println(s.solution2(
                new String[]{"apple"},
                new int[]{10},
                new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"})); // 0
    }

}
