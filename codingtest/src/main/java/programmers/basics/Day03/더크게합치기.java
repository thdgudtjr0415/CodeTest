package programmers.basics.Day03;

public class 더크게합치기 {
    public int solution(int a, int b) {
        int result = 0;
        int alt1 = Integer.parseInt(a + "" + b);
        int alt2 = Integer.parseInt(b + "" + a);
        result = Math.max(alt1, alt2);
        return result;
    }
    public static void main(String[] args) {
        더크게합치기 s = new 더크게합치기();
        System.out.println(s.solution(9,91)); //991
        System.out.println(s.solution(89,8)); //898
    }
}
