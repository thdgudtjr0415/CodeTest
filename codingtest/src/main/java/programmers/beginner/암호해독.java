package programmers.beginner;

public class 암호해독 {
    public String solution(String cipher, int code) {
        String result = "";
        String[] str = cipher.split("");

        for(int i = 1; i <= str.length/code; i++){
            result += str[(code*i)-1];
        }

        return result;
    }
    public static void main(String[] args) {
        암호해독 s = new 암호해독();
        System.out.println(s.solution("dfjardstddetckdaccccdegk",4)); // attack
        System.out.println(s.solution("pfqallllabwaoclk",2)); // fallback
    }
}
