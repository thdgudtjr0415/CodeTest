package programmers.basics.Day34;

public class 정수찾기 {
    public int solution(int[] num_list, int n) {
        int result = 0;
        for(int i = 0; i < num_list.length; i++){
            if(num_list[i] == n){
                result = 1;
            }
        }
        return result;
    }
    public static void main(String[] args){
        정수찾기 s = new 정수찾기();
        System.out.println(s.solution(new int[]{1,2,3,4,5}, 3)); //1
        System.out.println(s.solution(new int[]{15,98,23,2,15}, 20)); //0
    }
}
