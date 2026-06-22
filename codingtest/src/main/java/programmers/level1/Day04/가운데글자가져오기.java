package programmers.level1.Day04;

public class 가운데글자가져오기 {
    public String solution(String s) {
        String answer = "";
        if(s.length()%2!=0){
           answer = String.valueOf(s.charAt(s.length()/2));
        }else {
            answer = s.substring(s.length()/2-1, s.length()/2+1);
        }
        return answer;
    }
    public static void main(String[] args) {
        가운데글자가져오기 s = new 가운데글자가져오기();
        System.out.println(s.solution("abcde"));
        System.out.println(s.solution("qwer"));
    }
}
