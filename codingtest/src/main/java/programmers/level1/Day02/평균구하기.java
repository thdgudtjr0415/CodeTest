package programmers.level1.Day02;

public class 평균구하기 {
    public double solution(int[] arr) {
        int num = 0;
        for(int i = 0; i < arr.length; i++){
            num += arr[i];
        }
        double answer = (double) num/arr.length;
        return answer;
    }
    public static void main(String[] args) {
        평균구하기 s = new 평균구하기();
        System.out.println(s.solution(new int[]{1,2,3,4})); //2.5
        System.out.println(s.solution(new int[]{5,5})); //5
    }
}
