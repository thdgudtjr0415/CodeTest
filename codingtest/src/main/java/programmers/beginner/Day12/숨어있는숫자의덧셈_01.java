package programmers.beginner.Day12;

public class 숨어있는숫자의덧셈_01 {
    public int solution(String my_string) {
        int result = 0;
        for (int i = 0; i < my_string.length(); i++) {
            char c =  my_string.charAt(i);
            if(c >= '0' && c <= '9') {
                result += c - '0';
            }
        }

        return result;
    }

    public static void main(String[] args) {
        숨어있는숫자의덧셈_01 s = new 숨어있는숫자의덧셈_01();
        System.out.println(s.solution("aAb1B2cC34oOp")); //10
        System.out.println(s.solution("1a2b3c4d123")); //16
    }
}
