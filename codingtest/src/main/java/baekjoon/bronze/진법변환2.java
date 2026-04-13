package baekjoon.bronze;
import java.util.*;

/*
* 이건 진법변환1의 반대 버전이다.
* 데이터 타입 주의 하고 한번 거꾸로 해보자
* 3. 10 진법은 999라고 한다면 9x10² + 9x10¹ + 9x10⁰
* 4. = Z×36⁴ + Z×36³ + Z×36² + Z×36¹ + Z×36⁰
      = 35×36⁴ + 35×36³ + ...
* 여기서 힌트는
* 11 / 2 = 5 ... 나머지 1
* 5  / 2 = 2 ... 나머지 1
* 2  / 2 = 1 ... 나머지 0
* 1  / 2 = 0 ... 나머지 1
* 나머지를 거꾸로 읽으면 → 1011
* 아래의 내용을 이해하면 풀수 잇음
* while(n > 0){
    int remainder = n % m;   // 나머지 구하기
    n = n / m;               // n을 m으로 나누기

    // 나머지가 0~9 이면 → 숫자 문자
    // 나머지가 10~35 이면 → 'A'~'Z'
    // result = 새문자 + result;  ← 앞에 붙이기!
}
*
* */

public class 진법변환2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String result = "";

        // 여기는 while 문을 써서 계속 나눠서 0이 나올때 까지
        int remain = 0;
        while(n > 0){
            remain = n%m;
            n =  n/m;

            // 이 부분은 9 초과 하면 문자로 바꾸는 것
            if(remain <= 9){
                result = remain + result;
            }else {
                result =(char)('A' + (remain - 10)) + result;
            }
        }
        System.out.println(result);

    }
}
