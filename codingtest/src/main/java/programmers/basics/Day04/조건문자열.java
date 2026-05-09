package programmers.basics.Day04;

public class 조건문자열 {
    public int solution(String ineq, String eq, int n, int m) {
        int result = 0;
        // 먼저 문자열들 합해서 연산자 합쳐 놓기
        String op = ineq+eq;
        // 연산자의 가지수가 4가지 밖에 없으니까 직접 하는게 제일 빠를듯
        if(op.equals(">=")){
            if(n>=m) result = 1;
        }else if(op.equals("<=")){
            if(n<=m) result = 1;
        }else if(op.equals(">!")){
            if(n>m) result = 1;
        }else if(op.equals("<!")){
            if(n<m) result = 1;
        }

        return result;
    }
    public static void main(String[] args) {
        조건문자열 s= new 조건문자열();
        System.out.println(s.solution("<","=",20,50)); //1
        System.out.println(s.solution(">","!",41,78)); //0
    }
}
