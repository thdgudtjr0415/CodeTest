package programmers.basics.Day26;

import java.util.Arrays;

public class 조건에맞게수열변환하기_02 {
    public int solution(int[] arr) {
        int result = 0;
        //compare1 != compare2 이렇게 비교하는 건 주소 값 비교임 주의하기
        int[] compare2 = arr.clone();
        while(true){
            // 직전 상태 백업
            int[] compare1 = compare2.clone();
            for(int i=0;i<compare2.length;i++){
                // 여기서 주의해야 할 것은 compare2를 update해줘야 비교 가능
                int num = compare2[i];
                if(num >= 50 && num%2 == 0){
                    compare2[i] = num/2;
                }else if(num < 50 && num%2 == 1){
                    compare2[i] = num*2 + 1;
                }
            }
            if(Arrays.equals(compare1,compare2)) break;
            result++;
        }
        return result;
    }
    public static void main(String[] args) {
        조건에맞게수열변환하기_02 s = new 조건에맞게수열변환하기_02();
        System.out.println(s.solution(new int[]{1, 2, 3, 100, 99, 98}));
    }
}
