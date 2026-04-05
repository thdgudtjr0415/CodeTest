public class Main {
    public int solution(int n) {
        int answer = 0;

        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.solution(20));   // 6
        System.out.println(m.solution(100));  // 9
    }
}