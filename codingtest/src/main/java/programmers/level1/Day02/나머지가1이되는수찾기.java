package programmers.level1.Day02;

public class 나머지가1이되는수찾기 {
    public int solution(int n) {
        int result = 0;
        for(int i=1;i<=n;i++){
            if(n%i==1){
                result = i;
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        나머지가1이되는수찾기 s = new 나머지가1이되는수찾기();
        System.out.println(s.solution(10)); //3
        System.out.println(s.solution(12)); //11
    }
}
