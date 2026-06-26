package programmers.level1.Day08;

public class 시저함호 {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ' '){
                sb.append(' ');
            }else if(ch >= 'a' && ch <= 'z'){
                sb.append((char)((ch - 'a' + n)%26 + 'a'));
            }else if(ch >= 'A' && ch <= 'Z'){
                sb.append((char)((ch - 'A' + n)%26 + 'A')); // 이런거 유용할 듯 참고하기
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        시저함호 s = new 시저함호();
        System.out.println(s.solution("AB",1)); //BC
        System.out.println(s.solution("z",1)); //a
        System.out.println(s.solution("a B z",4)); //e F d
    }
}
