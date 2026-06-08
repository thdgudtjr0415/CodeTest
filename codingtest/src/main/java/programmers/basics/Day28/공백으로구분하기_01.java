package programmers.basics.Day28;

import java.util.Arrays;

public class 공백으로구분하기_01 {
    public String[] solution(String my_string) {
        return my_string.split(" ");
    }
    public static void main(String[] args) {
        공백으로구분하기_01 s = new 공백으로구분하기_01();
        System.out.println(Arrays.toString(s.solution("i love you")));
        System.out.println(Arrays.toString(s.solution("programmers")));
    }
}
