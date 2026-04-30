package programmers.beginner.Day23;

public class k의개수 {
    public int solution(int i, int j, int k) {
        int result = 0;

        // 먼저 k를 char 로 만들기
        char kChar = String.valueOf(k).charAt(0);

        // 그리고 i ~ j 까지 숫자를 비교 할껀데
        for(int a = i; a <= j; a++){
            // i를 String으로 만들어서 k랑 비교 할꺼임 이유는 두자리 이상부터는 char가 안됨
            String number = String.valueOf(a);
            for(int b = 0; b < number.length(); b++){
                if(number.charAt(b) == kChar){
                    result++;
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        k의개수 s = new k의개수();
        System.out.println(s.solution(1,13,1)); // 6
        System.out.println(s.solution(10,50,5)); // 5
        System.out.println(s.solution(3,10,2)); // 0
    }
}