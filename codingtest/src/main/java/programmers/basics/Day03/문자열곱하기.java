package programmers.basics.Day03;

public class 문자열곱하기 {
    // 반복문으로
    public String solution1(String my_string, int k) {
        String result = "";
        for (int i = 0; i < k; i++) {
            result += my_string;
        }
        return result;
    }
    //repeat으로 str.repeat(int타입) 이면 괄호만큼 반복해서 나옴
    public String solution2(String my_string, int k) {
        String result = my_string;
        return result.repeat(k);
    }
    public static void main(String[] args) {
        문자열곱하기 s = new 문자열곱하기();
        System.out.println(s.solution1("string",3)); //stringstringstring
        System.out.println(s.solution1("love",10)); //lovelovelovelovelovelovelovelovelovelove
        System.out.println(s.solution2("string",3)); //stringstringstring
        System.out.println(s.solution2("love",10)); //lovelovelovelovelovelovelovelov
    }
}
