package programmers.basics.Day04;

// 홀수일 때는 홀수의 합들을 나타냄
// 짝수일 때는 모든 짝수의 제곰의 합을 구함

public class 홀짝에따라다른값반환하기 {
    public int solution(int n){
        int result = 0;
        if(n%2!=0){
            for(int i =1; i <= n; i+=2){
                    result += i;
            }
        }else{
            for(int i = 2; i <= n; i+=2){
                //Math.pow(밑, 지수) 쓰면 편함 이거 거듭제곱근 쓸때 필요
//                    result += i*i;
                result += Math.pow(i,2);
            }
        }

        return result;
    }
    public static void main (String[] args) {
        홀짝에따라다른값반환하기 s = new 홀짝에따라다른값반환하기();
        System.out.println(s.solution(7)); // 16
        System.out.println(s.solution(10)); // 220
    }
}
