package programmers.beginner.Day17;

// 제곱수라면 1 아니면 2
public class 제곱수판별하기 {
    public int solution(int n) {
        int result = 0;
        double num = Math.sqrt(n);
        // Math.sqrt는 제곱근 구하는 공식임 그래서 정수이거나 int 이면 참이게 만들면 될듯
//        Math.sqrt(n);

        if(num == (int)num){
            result = 1;
        }else {
            result = 2;
        }
        return result;
    }
    public static void main(String[] args) {
        제곱수판별하기 s = new 제곱수판별하기();
        System.out.println(s.solution(144)); //1
        System.out.println(s.solution(976)); //2
    }
}
