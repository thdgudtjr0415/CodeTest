package programmers.basics.Day27;

public class 대문자로바꾸기 {
    public String solution(String myString) {
        String result = myString.toUpperCase();
        return result;
    }
    public static void main(String[] args){
        대문자로바꾸기 s = new 대문자로바꾸기();
        System.out.println(s.solution("aBcDeFg"));
        System.out.println(s.solution("AAA"));
    }
}
