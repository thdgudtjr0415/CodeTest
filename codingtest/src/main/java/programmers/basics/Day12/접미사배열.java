package programmers.basics.Day12;

import java.util.Arrays;

public class 접미사배열 {
    public String[] solution(String my_string) {
        String[] result = new String[my_string.length()];

        for (int i = 0; i < my_string.length(); i++) {
            // substring(i)만 하면 i부터 끝까지 자르기
            result[i] = my_string.substring(i); // i번 울타리부터 맨 끝까지 자르기
        }
        Arrays.sort(result);
        return result;
    }
    public static void main(String[] args) {
        접미사배열 s = new 접미사배열();
        System.out.println(Arrays.toString(s.solution("banana")));
        System.out.println(Arrays.toString(s.solution("programmers")));
    }
}
