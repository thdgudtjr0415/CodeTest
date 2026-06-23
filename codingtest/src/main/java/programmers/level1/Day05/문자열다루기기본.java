package programmers.level1.Day05;

public class 문자열다루기기본 {
    public boolean solution(String s) {
        boolean answer = true;
        if(!(s.length() == 4 || s.length() == 6)) answer = false;
        for(int i = 0; i < s.length(); i++){
            int c = s.charAt(i);
            if(!(c >= 48 && c <= 57)){
                answer = false;
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        문자열다루기기본 s = new 문자열다루기기본();
        System.out.println(s.solution("a234"));
        System.out.println(s.solution("1234"));
    }
}
