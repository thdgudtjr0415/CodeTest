package programmers.basics.Day12;

import java.util.Arrays;

public class 접미사인지확인하기 {
    public int solution(String my_string, String is_suffix) {
        int result = 0;
        String[] my_strings = new String[my_string.length()];
        for(int i = 0; i < my_strings.length; i++){
            my_strings[i] = my_string.substring(i);
        }
        for(int i = 0; i < my_strings.length; i++){
            if(my_strings[i].equals(is_suffix)){
                result = 1;
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        접미사인지확인하기 s = new 접미사인지확인하기();
        System.out.println(s.solution("banana", "ana")); // 1
        System.out.println(s.solution("banana", "nan")); // 0
        System.out.println(s.solution("banana", "wxyz")); // 0
        System.out.println(s.solution("banana", "abanana")); // 0
    }
}
