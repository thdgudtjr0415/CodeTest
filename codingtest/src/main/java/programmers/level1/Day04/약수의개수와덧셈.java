package programmers.level1.Day04;

public class 약수의개수와덧셈 {
    public int solution(int left, int right) {
        int result = 0;
        for(int i = left; i <= right; i++){
            int count = 0;
            for(int j = 1;  j <= i; j++ ){
                for(int k = i; k >= 0; k--){
                    if(j*k == i){
                        count++;
                    }
                }
            }
           if(count%2 == 0){
               result += i;
           }else {
               result -= i;
           }
        }
        return result;
    }
    public static void main(String[] args) {
        약수의개수와덧셈 s = new 약수의개수와덧셈();
        System.out.println(s.solution(13,17)); //43
        System.out.println(s.solution(24,27)); //52
    }
}
