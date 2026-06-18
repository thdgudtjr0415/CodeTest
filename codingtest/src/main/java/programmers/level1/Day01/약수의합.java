package programmers.level1.Day01;

public class 약수의합 {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++){
            if(n%i==0){
                answer += i;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        약수의합 s = new 약수의합();
        System.out.println(s.solution(12)); //28
        System.out.println(s.solution(5)); //6
    }
}
