package programmers.basics.Day04;

public class 공배수 {
    public int solution(int number, int n, int m) {
        int result = 0;

        if(number%n==0&&number%m==0){
            result = 1;
        }else {
            result = 0;
        }

        return result;
    }
    public static void main(String[] args){
        공배수 s = new 공배수();
        System.out.println(s.solution(60,2,3)); // 1
        System.out.println(s.solution(55,10,5)); // 0
    }
}
