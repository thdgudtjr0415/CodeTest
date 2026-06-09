package programmers.basics.Day29;

public class 간단한식계산하기 {
    public int solution(String binomial) {
        int result = 0;
        String[] arr = binomial.split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[2]);
        String c = arr[1];
        switch (arr[1]){
            case "+": result = a + b; break;
            case "-": result = a - b; break;
            case "*": result = a * b; break;
        }
        return result;
    }

    public static void main(String[] args) {
        간단한식계산하기 s = new 간단한식계산하기();
        System.out.println(s.solution("43 + 12"));
        System.out.println(s.solution("0 - 7777"));
        System.out.println(s.solution("40000 * 40000"));
    }
}
