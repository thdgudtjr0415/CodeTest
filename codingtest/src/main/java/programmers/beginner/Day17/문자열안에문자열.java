package programmers.beginner.Day17;

public class 문자열안에문자열 {
    public int solution(String str1, String str2) {
        int result = 0;

        // String 에서 contains쓰면 포함되어있는지 안되어있는지 확인해줌
        if(str1.contains(str2)){
            result = 1;
        }else {
            result = 2;
        }

        return result;
    }
    public static void main(String[] args) {
        문자열안에문자열 s = new 문자열안에문자열();
        System.out.println(s.solution("ab6CDE443fgh22iJKlmn1o", "6CD")); //1
        System.out.println(s.solution("ppprrrogrammers", "pppp")); //1
        System.out.println(s.solution("AbcAbcA", "AAA")); //1
    }
}
