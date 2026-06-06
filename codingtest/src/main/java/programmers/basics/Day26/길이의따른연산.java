package programmers.basics.Day26;

public class 길이의따른연산 {
    public int solution(int[] num_list) {
        int result = 0;
        if(num_list.length >= 11){
            for(int i = 0; i < num_list.length; i++){
                result += num_list[i];
            }
        }else {
            result = 1;
            for(int i = 0; i < num_list.length; i++){
                result *= num_list[i];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        길이의따른연산 s = new 길이의따른연산();
        System.out.println(s.solution(new int[]{3, 4, 5, 2, 5, 4, 6, 7, 3, 7, 2, 2, 1}));//51
        System.out.println(s.solution(new int[]{2,3,4,5}));//120
    }
}
