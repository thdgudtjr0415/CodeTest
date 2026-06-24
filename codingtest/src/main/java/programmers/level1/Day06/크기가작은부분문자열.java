package programmers.level1.Day06;

public class 크기가작은부분문자열 {
    public int solution(String t, String p) {
        int len = t.length() - p.length() + 1;
        String[] words = new String[len];
        for(int i = 0; i < len; i++){
            words[i] = t.substring(i, i+p.length());
        }
        int result = 0;
        // 입력 부분에서 String으로들어오는 t가 21억 이상일 수 있음 확인하기
        for(int i = 0; i < words.length; i++){
            long tNum = Long.parseLong(words[i]);
            long pNum = Long.parseLong(p);
            if(tNum <= pNum){
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        크기가작은부분문자열 s = new 크기가작은부분문자열();
        System.out.println(s.solution("3141592", "271")); // 2
        System.out.println(s.solution("500220839878", "7")); //8
        System.out.println(s.solution("10203", "15")); // 3
    }
}
