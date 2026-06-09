package programmers.basics.Day29;

public class rny_string {
    public String solution(String rny_string) {
        String result = rny_string.replace("m", "rn");
        return result;
    }

    public static void main(String[] args) {
        rny_string s = new rny_string();
        System.out.println(s.solution("masterpiece")); // "rnasterpiece"
        System.out.println(s.solution("programmers")); // "prograrnrners"
        System.out.println(s.solution("jerry")); // "jerry"
        System.out.println(s.solution("burn")); // "burn"
    }
}