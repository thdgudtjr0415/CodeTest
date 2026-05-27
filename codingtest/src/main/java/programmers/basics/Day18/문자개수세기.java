package programmers.basics.Day18;

import java.util.Arrays;

// 아스키 코드에서 A 65, a 97 인거 기억하기

public class 문자개수세기 {
    public int[] solution(String my_string) {
        int[] result = new int[52];
        for(int i = 0; i < my_string.length(); i++){
            char ch  = my_string.charAt(i);
            if(Character.isUpperCase(ch)){
                result[ch - 'A']++;
            }else if(Character.isLowerCase(ch)){
                result[ch - 'a' + 26]++;
            }
        }
        return result;
    }
    public static void main(String[] args){
        문자개수세기 s = new 문자개수세기();
        System.out.println(Arrays.toString(s.solution("Programmers")));
    }
}
