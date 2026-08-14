package programmers.level2.Day03;

import java.util.Arrays;

// 1. 0 빼기 + 뺀 개수 세기 (누적)
// 2. 남은 1의 개수(길이)를 이진수 문자열로 변환 -> 이게 다음 사이클의 새 s가 됨
// 3. 사이클 카운트 +1
// 4. s가 "1"이 될 때까지 1~3 반복
// result = {총 사이클 수, 총 제거된 0의 개수}

public class 이진변환반복하기 {
    public int[] solution(String s) {
        int zeroCount = 0;
        int cycle = 0;
        while(!(s.equals("1"))){
            int before = s.length();
            String temp = s.replaceAll("0","");
            int after = temp.length();
            zeroCount += before - after;
            s = Integer.toString(after,2);
            cycle++;
        }
        return new int[]{cycle, zeroCount};
    }


    public static void main(String[] args){
        이진변환반복하기 s = new 이진변환반복하기();
        System.out.println(Arrays.toString(s.solution("110010101001"))); //3,8
        System.out.println(Arrays.toString(s.solution("01110"))); // 3,3,
        System.out.println(Arrays.toString(s.solution("1111111"))); // 4,1
    }
}
