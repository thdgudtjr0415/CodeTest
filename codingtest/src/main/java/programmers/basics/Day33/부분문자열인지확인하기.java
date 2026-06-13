package programmers.basics.Day33;

public class 부분문자열인지확인하기 {
    public int solution(String my_string, String target) {
        StringBuilder sb = new StringBuilder(my_string);
        int result = 0;
        if(my_string.contains(target)){
            result = 1;
        }
        return result;
    }
    public static void main(String[] args) {
        부분문자열인지확인하기 s = new 부분문자열인지확인하기();
        System.out.println(s.solution("banana", "ana")); //1
        System.out.println(s.solution("banana", "wxyz")); //0

    }
}
