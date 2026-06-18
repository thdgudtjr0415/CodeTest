package programmers.level1.Day01;

import java.util.Arrays;

//n은 10,000,000,000이하인 자연수입니다. int 는 21억 까지만 가능하다는 거 기억하기

public class 자연수뒤집어배열로만들기 {
    public int[] solution(long n) {
        int[] answer = new int[String.valueOf(n).length()];
        String num = String.valueOf(n);
        int idx = 0;
        for(int i = num.length() - 1; i >= 0; i--){
            // 아스키 코드 조심
            answer[idx++] = num.charAt(i)-'0';
        }
        return answer;
    }
    public static void main(String[] args) {
        자연수뒤집어배열로만들기 s = new 자연수뒤집어배열로만들기();
        System.out.println(Arrays.toString(s.solution(12345))); //5,4,3,2,1
    }
}
