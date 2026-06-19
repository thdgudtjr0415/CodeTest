package programmers.level1.Day02;

public class 하샤드수 {
    public boolean solution(int x) {
        boolean answer = true;
        int originX = x;
        int sum = 0;
        while(originX >= 1){
            sum += originX%10;
            originX /= 10;
        }
        if(x%sum != 0){
            answer = false;
        }
        return answer;
    }
    public static void main(String[] args){
        하샤드수 s = new 하샤드수();
        System.out.println(s.solution(10));
        System.out.println(s.solution(12));
        System.out.println(s.solution(11));
        System.out.println(s.solution(13));
    }
}
