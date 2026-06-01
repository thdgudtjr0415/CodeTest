package programmers.basics.Day21;

public class 첫번째로나오는음수 {
    public int solution(int[] num_list) {
        // 기본 default -1
        int result = -1;
        for (int i = 0; i < num_list.length; i++) {
            if(num_list[i] < 0){
                result = i;
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        첫번째로나오는음수 s = new 첫번째로나오는음수();
        System.out.println(s.solution(new int[]{12,4,15,46,38,-2,15}));
        System.out.println(s.solution(new int[]{13,22,53,24,15,6}));

    }
}
