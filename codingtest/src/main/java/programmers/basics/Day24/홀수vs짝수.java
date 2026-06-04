package programmers.basics.Day24;

public class 홀수vs짝수 {
    public int solution(int[] num_list) {
        int odd = 0;
        int even = 0;
        for(int i = 0; i < num_list.length; i++){
            if(i % 2 == 0){
                odd += num_list[i];
            }else {
                even += num_list[i];
            }
        }
        int result = Math.max(odd, even);
        return result;
    }
    public static void main(String[] args){
        홀수vs짝수 s = new 홀수vs짝수();
        System.out.println(s.solution(new int[]{4, 2, 6, 1, 7, 6})); // 17
        System.out.println(s.solution(new int[]{-1, 2, 5, 6, 3})); // 8
    }
}