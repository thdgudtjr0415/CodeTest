package programmers.basics.Day25;

public class n보다커질때까지더하기 {
    public int solution(int[] numbers, int n) {
        int result = 0;
        int idx = 0;
        while(result<=n){
            result += numbers[idx++];
        }
        return result;
    }
    public static void main(String[] args) {
        n보다커질때까지더하기 s = new n보다커질때까지더하기();
        System.out.println(s.solution(new int[]{34, 5, 71, 29, 100, 34},123)); //139
        System.out.println(s.solution(new int[]{58, 44, 27, 10, 100},139)); //239
    }
}
