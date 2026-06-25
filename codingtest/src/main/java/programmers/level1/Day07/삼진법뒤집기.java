package programmers.level1.Day07;

//String trinary = Integer.toString(num, 3);   // "1200"

public class 삼진법뒤집기 {
    public int solution(int n) {
        int result = 0;
        String num = "";
        String reNum = "";
        while(n > 0){
            num = (n % 3) + num;
            n /= 3;
        }
        for(int i = num.length()-1; i >= 0; i--){
            reNum += num.charAt(i)+"";
        }
        int k = 1; // 진법 차수
        for(int i = reNum.length()-1; i >= 0; i--){
            int a = Integer.parseInt(reNum.charAt(i)+"");
            result += a*k;
            k *= 3;
        }
        return result;
    }
    public static void main(String[] args){
        삼진법뒤집기 s = new 삼진법뒤집기();
        System.out.println(s.solution(45)); //7
        System.out.println(s.solution(125)); //229
    }
}
