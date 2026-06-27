package programmers.level1.Day08;

public class 푸드파이터대회 {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < food.length; i++){
            if(food[i]%2 != 0){
                food[i]--;
            }
            for(int j = 0; j < food[i]/2; j++){
                sb.append(i);
            }
        }
        StringBuilder sb2 = new StringBuilder(sb);
        sb.append("0");
        sb2.reverse();
        sb.append(sb2);
        return sb.toString();
    }
    public static void main(String[] args){
        푸드파이터대회 s = new 푸드파이터대회();
        System.out.println(s.solution(new int[]{1,3,4,6})); // "1223330333221"
        System.out.println(s.solution(new int[]{1,7,1,2})); // "111303111"
    }
}
