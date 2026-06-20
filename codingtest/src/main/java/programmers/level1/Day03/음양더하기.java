package programmers.level1.Day03;

public class 음양더하기 {
    public int solution(int[] absolutes, boolean[] signs) {
        int result = 0;
        for(int i = 0; i < absolutes.length; i++){
            if(signs[i]){
                result += absolutes[i];
            }else {
                result -= absolutes[i];
            }
        }
        return result;
    }
    public static void main(String[] args){
        음양더하기 s = new 음양더하기();
        System.out.println(s.solution(new int[]{4,7,12}, new boolean[]{true,false,true}));//9
        System.out.println(s.solution(new int[]{1,2,3}, new boolean[]{false,false,true}));//0
    }
}
