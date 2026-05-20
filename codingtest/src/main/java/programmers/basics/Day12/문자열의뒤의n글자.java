package programmers.basics.Day12;

public class 문자열의뒤의n글자 {
    public String solution(String my_string, int n) {
        String result = "";

        // substring(start, end) -> start <= index < end 잘 기억하기
        result = my_string.substring(my_string.length()-n, my_string.length());

        return result;
    }
    public static void main(String[] args){
        문자열의뒤의n글자 s = new 문자열의뒤의n글자();
        System.out.println(s.solution("ProgrammerS123", 11));
        System.out.println(s.solution("He110W0r1d", 5));
    }
}
