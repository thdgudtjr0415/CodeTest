package programmers.basics.Day34;

public class 부분문자열 {
    public int solution(String str1, String str2) {
        int result = 0;
        if(str2.contains(str1)){
            result = 1;
        }
        return result;
    }
    public static void main(String[] args) {
        부분문자열 s = new 부분문자열();
        System.out.println(s.solution("abc", "aabcc")); //1
        System.out.println(s.solution("tbt", "tbbttb")); //0
    }
}
