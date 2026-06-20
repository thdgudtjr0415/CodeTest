package programmers.level1.Day03;

public class 두정수사이의합 {
    public long solution1(int a, int b) {
        long answer = 0;
        if(b > a){
            for(int i = a; i <= b; i++){
                answer += i;
            }
        }else if(a > b){
            for(int i = a; i >= b; i--){
                answer += i;
            }
        }else if(b == a) {
            answer = a;
        }
        return answer;
    }
    public long solution2(int a, int b) {
        long answer = 0;
        long max = Math.max(a, b);
        long min = Math.min(a, b);
        for(long i = min; i <= max; i++){
            answer += i;
        }
        return answer;
    }
    public static void main(String[] args){
        두정수사이의합 s = new 두정수사이의합();
        System.out.println(s.solution1(3,5)); //12
        System.out.println(s.solution1(3,3)); //3
        System.out.println(s.solution1(5,3)); //12
        System.out.println(s.solution2(3,5)); //12
        System.out.println(s.solution2(3,3)); //3
        System.out.println(s.solution2(5,3)); //12
    }
}
