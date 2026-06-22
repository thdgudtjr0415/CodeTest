package programmers.level1.Day04;

public class 콜라츠추측 {
    public int solution(int num) {
        int result = 0;
        long n = num; // 오버플로우 방지
        if(num==0) return 0;

        while(n > 1){
            if(n%2 ==0){
                n = n/2;
            }else {
                n = n*3 + 1;
            }
            result++;
            if(result == 500){
                return -1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        콜라츠추측 s = new 콜라츠추측();
        System.out.println(s.solution(6));
        System.out.println(s.solution(16));
        System.out.println(s.solution(626331));
    }
}
