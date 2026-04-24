package programmers.beginner.Day19;

public class 숨어있는숫자의덧셈 {
    public int solution(String my_string) {
        // 1. 소문자와 대문자 알파벳 전체([a-zA-Z])를 기준으로 싹둑!
        // + 기호는 "연속된 알파벳"을 하나로 묶어주는 기호임.
        // 그리고 숫자 판별하는 도구가 Character.isDigit() 이거임 기억하자
        // 문자 판별은 Character.isLetter() -> 특수문자 숫자 안됨(알파벳, 한글 됨)
        String[] my_strings = my_string.split("[a-zA-Z]+");
        int result = 0;
        for(int i = 0; i < my_strings.length; i++) {
            if(!my_strings[i].isEmpty()) {
                result += Integer.parseInt(my_strings[i]);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        숨어있는숫자의덧셈 s = new 숨어있는숫자의덧셈();
        System.out.println(s.solution("aAb1B2cC34oOp")); // 37
        System.out.println(s.solution("1a2b3c4d123Z")); // 133
    }
}
