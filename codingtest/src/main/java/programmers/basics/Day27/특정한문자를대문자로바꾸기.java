package programmers.basics.Day27;

public class 특정한문자를대문자로바꾸기 {
    public String solution(String my_string, String alp) {
        return my_string.replaceAll(alp, alp.toUpperCase());
    }
    public static void main(String[] args) {
        특정한문자를대문자로바꾸기 s = new 특정한문자를대문자로바꾸기();
        System.out.println(s.solution("programmers","p"));//Programmers
        System.out.println(s.solution("lowercase","x"));//lowercase
    }
}
