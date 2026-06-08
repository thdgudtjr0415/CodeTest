package programmers.basics.Day28;

public class 특정문자열로끝나는가장긴부분문자열찾기 {
    public String solution(String myString, String pat) {
        String result = "";
        int idx = 0;
        if(pat.length() > 1){
            idx = myString.lastIndexOf(pat) + pat.length() -1;
        }else {
            idx = myString.lastIndexOf(pat);
        }
        for(int i = 0; i <= idx; i++){
            result += myString.charAt(i);
        }
        return result;
    }
    public static void main(String[] args) {
        특정문자열로끝나는가장긴부분문자열찾기 s = new 특정문자열로끝나는가장긴부분문자열찾기();
        System.out.println(s.solution("AbCdEFG","dE"));
        System.out.println(s.solution("AAAAaaaa","a"));
    }
}
