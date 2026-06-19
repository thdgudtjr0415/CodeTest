package programmers.level1.Day02;

public class 짝수와홀수 {
    public String solution(int num) {
        return num%2 != 0 ? "Odd" : "Even";
    }
    public static void main(String[] args){
        짝수와홀수 s = new 짝수와홀수();
        System.out.println(s.solution(3));
        System.out.println(s.solution(4));
    }
}
