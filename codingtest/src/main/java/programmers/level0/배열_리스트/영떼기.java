package programmers.level0.배열_리스트;

public class 영떼기 {
    public String solution(String n_str) {
        String result = Integer.parseInt(n_str)+"";
        return result;
    }
    public static void main(String[] args) {
        영떼기 s = new 영떼기();
        System.out.println(s.solution(new String("00010")));
        System.out.println(s.solution(new String("854020")));
    }
}
