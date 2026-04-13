package baekjoon.bronze;
import java.util.*;
/*
 * 1. ZZZZZ 이건 숫자 / 36 진법
 * 2. 이 ZZZZZ 를 10 진법으로 바꾸자
 * 3. 10 진법은 999라고 한다면 9x10² + 9x10¹ + 9x10⁰
 * 4. = Z×36⁴ + Z×36³ + Z×36² + Z×36¹ + Z×36⁰
      = 35×36⁴ + 35×36³ + ...
 * 5. 아스키 코드 Z - 'A' +10 해야 A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35 가 됨
*/

// 입력 ZZZZZ 36
// 출력 60466175

public class 진법변환1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int B = sc.nextInt();
        int result = 0;

        for(int i = 0; i < N.length(); i++){
            char c = N.charAt(N.length()-1-i);
            int digit = 0;

            // 0 ~ Z 까지 숫자로 변환
            if(c >= '0' && c <= '9'){
                digit = c -'0';
            }else{
                digit = c - 'A' +10;
            }

            // 거듭제곱근 계산하는 방법
            int num = 1;
            for(int j = 0; j < i; j++){  // i=0이면 num=1
                num *= B;
            }
            result += digit*num;

        }
        System.out.println(result);
    }
}