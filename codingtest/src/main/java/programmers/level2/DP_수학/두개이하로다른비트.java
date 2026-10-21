package programmers.level2.DP_수학;

import java.util.Arrays;

// x보다 크고 x와 비트가 1~2개 다른 수들 중에서 제일 작은 수
// 그리고 지금 인자들은 1경까지 가능한 수임
// 지금 2,4,6,8,10 같은 경우 f(x)를 하게 된다면 3,5,7,9,11 이 됨 즉 짝수는 2진수로 하면 마지막이 0이라서 +1만하면됨
// 홀수가 문제임

/*
 * [코드 리뷰]
 * 짝수: x + 1 / 홀수: 이진수에서 맨 오른쪽 0과 그 오른쪽 1의 자리를 바꾼다(01 -> 10), 0이 없으면 111 -> 1011
 * 시간복잡도: O(n * 50)
 * [개선할 점] 문자열 없이 비트 연산 한 줄: bit = (x + 1) & ~x; f(x) = x + bit - (bit >> 1)
 */
public class 두개이하로다른비트 {
    public long[] solution1(long[] numbers) {
        long[] answer = new long[numbers.length];
        // 의문점1: while 로 하나씩 올려 찾으면 안 되나? -> x가 크면 3억 번 이상이라 시간 초과
        // 의문점2: 문자열 말고 수로만 구할 수 있나? -> 있다 (위 개선할 점)
        // 의문점3: 왜 long 이어야 하나? -> 최대 10^15 라 int 범위를 넘는다
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] % 2 == 0){ // 짝수 일때
                answer[i] = numbers[i] + 1;
            }else { // 홀수 일때
                String num = Long.toString(numbers[i],2);
                String temp;
                if(!num.contains("0")){
                    temp =  "10" + (num.substring(1));
                    answer[i] = Long.parseLong(temp,2);
                }else {
                    int zeroIdx = num.lastIndexOf("0");
                    // 0 자리 찾기
                    temp = num.substring(0,zeroIdx) + "10" + num.substring(zeroIdx +2);
                    answer[i] = Long.parseLong(temp, 2);
                }
            }
        }
        return answer;
    }
    public long[] solution2(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] % 2 == 0){ // 짝수 일때
                answer[i] = numbers[i] + 1;
            }else { // 홀수 일때
                String num = "0" + Long.toString(numbers[i],2);
                int zeroIdx = num.lastIndexOf("0");
                answer[i] =
                        Long.parseLong(num.substring(0,zeroIdx) +
                                "10" + num.substring(zeroIdx +2), 2);
            }
        }
        return answer;
    }
    public static void main(String[] args){
        두개이하로다른비트 s = new 두개이하로다른비트();
        System.out.println(Arrays.toString(s.solution2(new long[]{2,7}))); //3,11
        System.out.println(Arrays.toString(s.solution2(new long[]{5,19}))); //6, 21
    }
}
