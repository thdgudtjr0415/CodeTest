package programmers.basics.Day04;

public class n의배수 {
    public int solution(int num, int n) {
        int result = 0;

        if(num%n == 0) result = 1;

        return result;
    }
    public static void main(String args[]){
        n의배수 s = new n의배수();
        System.out.println(s.solution(98,2));
        System.out.println(s.solution(34,3));
    }
}