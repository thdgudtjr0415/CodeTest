package programmers.basics.Day04;

public class flag에따라다른값반환하기 {
    public int solution(int a, int b, boolean flag) {
        int result = 0;

        if(flag){
            result = a+b;
        }else{
            result = a-b;
        }

        return result;
    }
    public static void main(String[] args) {
        flag에따라다른값반환하기 s = new flag에따라다른값반환하기();
        System.out.println(s.solution(-4,7,true)); //3
        System.out.println(s.solution(-4,7,false)); //-11

    }
}
