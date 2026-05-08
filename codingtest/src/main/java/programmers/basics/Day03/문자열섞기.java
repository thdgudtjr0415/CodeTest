package programmers.basics.Day03;

public class 문자열섞기 {
    public String solution(String str1, String str2) {
        String result = "";
        for(int i=0;i<str1.length();i++){
            result += str1.charAt(i);
            result += str2.charAt(i);
        }
        return result;
    }
    public static void main(String[] args) {
        문자열섞기 s = new 문자열섞기();
        System.out.println(s.solution("aaaaa", "bbbbb"));
    }
}
