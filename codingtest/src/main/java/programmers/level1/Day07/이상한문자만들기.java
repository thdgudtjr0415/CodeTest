package programmers.level1.Day07;

public class 이상한문자만들기 {
    public String solution(String s) {
        String answer = "";
        int idx = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                answer += " ";
                idx = 0;
            }else {
                if(idx%2 == 0){
                    answer += Character.toUpperCase(s.charAt(i));
                    idx++;
                }else  {
                    answer += Character.toLowerCase(s.charAt(i));
                    idx++;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        이상한문자만들기 s = new 이상한문자만들기();
        System.out.println(s.solution("try hello world")); // "TrY HeLlO WoRlD"
    }
}
