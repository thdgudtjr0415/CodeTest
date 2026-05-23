package programmers.basics.Day15;

public class 문자열뒤집기 {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder();
        String result = "";
        sb.append(my_string);
        String words = new StringBuilder(sb.substring(s,e+1)).reverse().toString();
        result = String.valueOf(sb.replace(s,e+1,words));
        return result;
    }
    public static void main(String[] args) {
        문자열뒤집기 s = new 문자열뒤집기();
        System.out.println(s.solution("Progra21Sremm3",6,12)); // ProgrammerS123
        System.out.println(s.solution("Stanley1yelnatS",4,10)); // Stanley1yelnatS

    }
}
