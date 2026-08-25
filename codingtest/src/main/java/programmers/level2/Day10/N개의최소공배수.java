package programmers.level2.Day10;

// lcm = Least(최소) Common(공통) Multiple(배수)
// gcd = Greatest(최대) Common(공통) Divisor(약수)
// 최소 공배수 = a x b / 최대공약수

public class N개의최소공배수 {
    public int solution(int[] arr) {
        // 최소공배수 담아 놓을 변수 먼저 생성
        int lcmNum = 1;
        for(int i = 0; i < arr.length; i++){
            lcmNum = lcm(lcmNum, arr[i]);
        }
        return lcmNum;
    }

    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b,  a % b);
    }
    // 위에 최대 공약수 먼저 만들어 놓은 것을 적용한 것이기 때문에 본 코드에서 최대공약수 안구해도됨
    public int lcm(int a, int b){
//        return a * b / gcd(a, b);
        return a / gcd(a, b) * b ; // 오버 플로우 나면 이걸로 해야함 순서 변경해도 * / 연산자라 상관없음
    }
    public static void main(String[] args) {
        N개의최소공배수 s = new N개의최소공배수();
        System.out.println(s.solution(new int[]{2,6,8,14})); //168
        System.out.println(s.solution(new int[]{1,2,3})); // 6
    }
}
