package programmers.level1.Day16;

// 소수 구하는 건 제곱근 까지만? 구하는 것을 한번 보면 됨
// ex) n = 16 이라면 16 에서 1*16, 2*8, 4*4, 8*2, 16*1 까지만 허용
//

public class 소수찾기 {
    public int solution(int n) {
        int result = 0;
        for(int i = 2; i <= n; i++){
            if(isPrime(i)){
                result++;
            }
        }
        return result;
    }
    public static boolean isPrime(int n) {
        for(int i = 2; i*i <= n; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        소수찾기 s= new 소수찾기();
        System.out.println(s.solution(10)); // 4
        System.out.println(s.solution(5)); // 3
    }
}
