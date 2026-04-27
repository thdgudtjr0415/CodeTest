package programmers.beginner.Day20;

/* 주석.
 * 3의 배수와 3을 안쓴다
 * 1,2,4,5,7,8,10,11,13,14,16,17,19,20,22,23...
 * */

public class 저주의숫자3 {
    public int solution(int n) {
        int result = 0;

        for(int i=1;i<=n;i++){
            result++;

            // 여기서는 while 쓰는게 좋을 듯
            while(result%3==0 || String.valueOf(result).contains("3")){
                result++;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        저주의숫자3 s = new 저주의숫자3();
        System.out.println(s.solution(15));
        System.out.println(s.solution(40));
    }
}
