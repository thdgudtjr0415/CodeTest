package programmers.level1.Day01;

public class 정수제곱근판별 {
    public long solution(long n) {
        // 지금 제한 사항 n은 1이상, 50,000,000,000,000 이하인 양의 정수입니다.
        // Math.pow(4,3)= 4*4*4 , Math.sqrt(16) 16의 제곱근 = 4;
        // 이게 만든 제곱근 계산식 즉 원래 pow는 제곱 계산하는건데 뒷자리에 1.0 / n 을 하면 제곱근 됨
        double x = Math.pow(n, 1.0 / 2.0);
        if(x % 1 != 0){
            return -1;
        }
        long answer = (long)Math.pow(x+1, 2);
        return answer;
    }
    public static void main(String[] args) {
        정수제곱근판별 s = new 정수제곱근판별();
        System.out.println(s.solution(121)); //144
        System.out.println(s.solution(3)); //-1
    }
}
