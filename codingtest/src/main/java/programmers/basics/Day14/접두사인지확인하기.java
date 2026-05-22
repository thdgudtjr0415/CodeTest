package programmers.basics.Day14;


public class 접두사인지확인하기 {
    public int solution(String my_string, String is_prefix) {
        int result = 0;
        String[] words = new String[my_string.length()];
        for (int i = 1; i <= words.length; i++) {
            words[i-1] = my_string.substring(0,i);
            if(words[i-1].equals(is_prefix)){
                result = 1;
                break;
            }
        }


        return result;
    }
    public static void main(String[] args) {
        접두사인지확인하기 s = new 접두사인지확인하기();
        System.out.println(s.solution(new String("banana"),new String("ban")));
        System.out.println(s.solution(new String("banana"),new String("nan")));
        System.out.println(s.solution(new String("banana"),new String("abcd")));
        System.out.println(s.solution(new String("banana"),new String("bananan")));
    }
}
