package programmers.beginner.Day24;

// 이 경우는 등차수열 혹은 등비수열이 아닌 경우는 없다고함 즉
// 1씩 더하는 등차수열 1,2,3,4 ...
// 2씩 곱하는 등비수열 2,4,8,16...


public class 다음에올숫자 {
    public int solution(int[] common) {
        int result = 0;

        if(common[1]-common[0] == common[2]-common[1]){
            result = common[common.length-1] + (common[1]-common[0]);
        }else{
            result = common[common.length-1] * (common[1]/common[0]);
        }

        return result;
    }
    public static void main(String[] args) {
        다음에올숫자 s = new 다음에올숫자();
        System.out.println(s.solution(new int[]{1,2,3,4})); // 5
        System.out.println(s.solution(new int[]{2,4,8})); // 16
    }
}
