package programmers.level2.Day08;

// 칸의 수 n개, 한번에 뛸때는 1 또는 2로 전진
// 마지막에 1234567로 나눈 나머지 리턴
// n=1 일때 (1) 1개 / n=2일때 (1,1), (2) 2개
// 그럼 n=3일때는 3칸 도착 방법 = 2칸 도착 방법 + 1칸 도착 방법
// f(3) =  f(1) + f(2)

public class 멀리뛰기 {
    // 초기 코드
    public long solution1(int n) {
        long result = 0;
        long fnOne = 1;
        long fnTwo = 2;
        if(n == 1) return 1;
        if(n == 2) return 2;
        for(long i = 3; i <= n; i++){
            long fn = (fnOne + fnTwo) % 1234567;
            fnOne = fnTwo;
            fnTwo = fn;
            result = fn;
        }
        return result;
    }
    // 리뷰후 수정
    // 1. %1234567 인데 굳이 long일 필요 없음
    // 2. int result 도 굳이 코드 줄수만 늘어남
    public int solution2(int n) {
        int fnOne = 1;
        int fnTwo = 2;
        if(n == 1) return 1;
        if(n == 2) return 2;
        for(int i = 3; i <= n; i++){
            int fn = (fnOne + fnTwo) % 1234567;
            fnOne = fnTwo;
            fnTwo = fn;
        }
        return fnTwo;
    }
    public static void main(String[] args){
        멀리뛰기 s = new 멀리뛰기();
        System.out.println(s.solution1(4)); //5
        System.out.println(s.solution1(3)); //3

        System.out.println(s.solution2(4)); //5
        System.out.println(s.solution2(3)); //3
    }
}
