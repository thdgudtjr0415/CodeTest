package programmers.level1.Day07;

public class 삼총사 {
    public int solution(int[] number) {
        int result = 0;
        for(int i = 0; i < number.length; i++){
            for(int j = i+1; j < number.length; j++){
                for(int k = j+1; k < number.length; k++){
                    if(number[i] + number[j] + number[k] == 0){
                        result++;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        삼총사 s = new 삼총사();
        System.out.println(s.solution(new int[]{-2,3,0,2,-5})); //2
        System.out.println(s.solution(new int[]{-3,-2,-1,0,1,2,3})); //5
        System.out.println(s.solution(new int[]{-1,1,-1,1})); //0
    }
}
