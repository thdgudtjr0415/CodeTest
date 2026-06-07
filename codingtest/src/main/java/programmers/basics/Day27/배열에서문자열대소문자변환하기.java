package programmers.basics.Day27;

import java.util.Arrays;

public class 배열에서문자열대소문자변환하기 {
    public String[] solution(String[] strArr) {
        String[] result = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String words = strArr[i];
            if(i%2==0){
                result[i] = words.toLowerCase();
            }else {
                result[i] = words.toUpperCase();
            }
        }
        return result;
    }
    public static void main(String[] args) {
        배열에서문자열대소문자변환하기 s = new 배열에서문자열대소문자변환하기();
        System.out.println(Arrays.toString(s.solution(new String[]{"AAA","BBB","CCC","DDD"}))); //"aaa","BBB","ccc","DDD"
        System.out.println(Arrays.toString(s.solution(new String[]{"aBc","AbC"}))); // "abc","ABC"
    }
}
