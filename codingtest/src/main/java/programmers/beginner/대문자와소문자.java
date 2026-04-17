package programmers.beginner;

public class 대문자와소문자 {
    public String solution(String my_string) {
        String result = "";

        // 주의! 전체 문자를 바꿀때는 그냥 str.toLowerCase();,str.toUpperCase(); 이런식으로 쓰지만
        // 지금 문제의 경우에는 Character.toLowerCase(),Character.toUpperCase(); 이렇게 써야함
        for(int i = 0; i < my_string.length(); i++){
            char c =  my_string.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                result += Character.toLowerCase(c);
            }else if(c >= 'a' && c <= 'z'){
                result += Character.toUpperCase(c);
            }
        }


        return result;
    }
    public static void main(String[] args) {
        대문자와소문자 s = new 대문자와소문자();
        System.out.println(s.solution("cccCCC")); //CCCccc
        System.out.println(s.solution("abCdEfghIJ")); //ABcDeFGHij
    }
}
