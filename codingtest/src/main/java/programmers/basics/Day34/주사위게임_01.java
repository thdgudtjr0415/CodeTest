package programmers.basics.Day34;

public class 주사위게임_01 {
    public int solution(int a, int b) {
        int result = 0;
        if(a%2!=0 && b%2!=0){
            result = a*a + b*b;
        }else if(a%2==0 && b%2==0){
            result = Math.abs(a-b);
        }else {
            result = 2 * (a+b);
        }
        return result;
    }
    public static void main(String[] args){
        주사위게임_01 s = new 주사위게임_01();
        System.out.println(s.solution(3,5)); //34
        System.out.println(s.solution(6,1)); //14
        System.out.println(s.solution(2,4)); //2
    }
}
