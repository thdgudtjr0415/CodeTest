package programmers.basics;

//문제: 재귀로 계단 오르는 방법의 수 구하기
//계단이 총 n칸 있을 때, 한 번에 1칸 또는 2칸씩 오를 수 있다면,
//꼭대기(n칸)까지 오르는 방법이 몇 가지인지 재귀 함수로 구하세요.
//메서드: climbStairs(int n)
//조건:
//for문이나 while문을 쓰지 않고, 오직 재귀 호출만으로 구해야 해요.
//n이 0이면(이미 꼭대기에 있는 것과 같음) 1가지 방법이 있다고 봐요.
//n이 음수가 되면(1칸 남았는데 2칸을 올라버린 경우) 0가지로 처리해야 해요.
//climbStairs(2)
// 결과: 2   (1+1 또는 2, 두 가지 방법)
//climbStairs(3)
// 결과: 3   (1+1+1, 1+2, 2+1 세 가지 방법)
//climbStairs(4)
// 결과: 5
public class 재귀_계단오르기 {
    public int climbStairs(int n) {
        int result = 0;

        if(n == 0){
            return 1;
        }else if(n < 0){
            return 0;
        }

        result = climbStairs(n-1) + climbStairs(n-2);

        return result;
    }
    public static void main(String[] args){
        재귀_계단오르기 s = new 재귀_계단오르기();
        System.out.println(s.climbStairs(2)); //2
        System.out.println(s.climbStairs(3)); //3
        System.out.println(s.climbStairs(4)); //5
    }
}