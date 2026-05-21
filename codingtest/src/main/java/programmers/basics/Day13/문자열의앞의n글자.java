package programmers.basics.Day13;

public class 문자열의앞의n글자 {
    public String solution1(String my_string, int n) {
        String result = "";
        for(int i = 0; i<n; i++){
            result += my_string.charAt(i);
        }
        return result;
    }
    public String solution2(String my_string, int n) {
        String result = "";
        result = my_string.substring(0,n);
        return result;
    }

    public static void main(String[] args) {
        문자열의앞의n글자 s = new 문자열의앞의n글자();
        System.out.println(s.solution1("ProgrammerS123", 11)); // ProgrammerS
        System.out.println(s.solution1("He110W0r1d", 5)); // He110

        System.out.println(s.solution2("ProgrammerS123", 11)); // ProgrammerS
        System.out.println(s.solution2("He110W0r1d", 5)); // He110
    }
}
