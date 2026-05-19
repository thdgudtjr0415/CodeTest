package programmers.basics.Day11;

import java.math.BigInteger;

public class 구로나눈나머지 {
    public int solution1(String number) {
        int result = 0;
        int sum = 0;
        for(int i = 0; i < number.length(); i++) {
            sum += number.charAt(i) - '0';
        }
        result = sum % 9;

        return result;
    }
    public int solution2(String number) {
        // 알고만 있기
        // 1. 엄청 큰 숫자가 담긴 문자열을 BigInteger 객체로 변환
        BigInteger bigNum = new BigInteger(number);

        // 2. 나눌 수 9를 BigInteger 객체로 생성
        BigInteger target = BigInteger.valueOf(9);

        // 3. 나머지 연산 수행 (bigNum % 9)
        BigInteger remainder = bigNum.remainder(target);

        // 4. 결과를 int 타입으로 변환해서 반환
        return remainder.intValue();
    }

    public static void main(String[] args) {
        구로나눈나머지 s = new 구로나눈나머지();
        System.out.println(s.solution1("123"));
        System.out.println(s.solution1("78720646226947352489"));
        System.out.println(s.solution2("123"));
        System.out.println(s.solution2("78720646226947352489"));
    }
}
