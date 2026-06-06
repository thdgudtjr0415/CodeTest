package programmers.basics.Day26;

public class 일로만들기 {
    public int solution(int[] num_list) {
        int result = 0;
        for(int i=0;i<num_list.length;i++){
            int num = num_list[i];
            while(num > 1){
                result++;
                if(num%2==-0){
                    num/=2;
                }else {
                    num = (num-1)/2;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        일로만들기 s =new 일로만들기();
        System.out.println(s.solution(new int[]{12,4,15,1,14})); //11
    }
}
