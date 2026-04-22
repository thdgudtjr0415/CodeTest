package programmers.beginner.Day17;

// 1. 전체 문자 소문자로 변경
// 2. 알파벳 순서대로 정렬

import java.util.Arrays;

public class 문자열정렬하기_02 {
    public String solution(String my_string) {
        String result = "";
        // 소문자로 바꾸고
        String temp = my_string.toLowerCase();
        // 정렬하려고 배열로 만듦
        char[] arr = temp.toCharArray();
        Arrays.sort(arr);
        // 반복문으로 다시 붙여주기
        for(int i=0;i<arr.length;i++){
            result += arr[i];
        }

        return result;
    }
    public static void main(String[] args) {
        문자열정렬하기_02 s = new 문자열정렬하기_02();
        System.out.println(s.solution("Bcad")); // abcd
        System.out.println(s.solution("heLLo")); // ehllo
        System.out.println(s.solution("Python")); // hnopty

    }
}
