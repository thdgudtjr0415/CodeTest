package programmers.level1.Day09;

public class 숫자문자열과영단어 {
    public int solution(String s) {
        String[] num = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        for(int i = 0; i < num.length; i++){
            s = s.replace(num[i], Integer.toString(i));
        }
        int result = Integer.parseInt(s);
        return result;
    }
    public static void main(String[] args) {
        숫자문자열과영단어 s = new 숫자문자열과영단어();
        System.out.println(s.solution("one4seveneight"));
        System.out.println(s.solution("23four5six7"));
        System.out.println(s.solution("2three45sixseven"));
        System.out.println(s.solution("123"));
    }
}
