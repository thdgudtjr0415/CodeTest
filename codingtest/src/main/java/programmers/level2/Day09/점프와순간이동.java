package programmers.level2.Day09;

// 이 문제는 거꾸로 생각해보자

public class 점프와순간이동 {
    public int solution(int n) {
        int battery = 0;
        while(n > 0){
            if(n%2 != 0){
                battery++;
                n--;
            }else {
                n/=2;
            }
        }
        return battery;
    }
    public static void main(String[] args){
        점프와순간이동 s = new 점프와순간이동();
        System.out.println(s.solution(5)); //2
        System.out.println(s.solution(6)); //2
        System.out.println(s.solution(5000)); //5
    }
}
