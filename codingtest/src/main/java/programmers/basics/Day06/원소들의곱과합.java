package programmers.basics.Day06;

public class 원소들의곱과합 {
    public int solution(int[] num_list) {
        int result = 0;
        int mulResult = 1;
        int squareOfSum = 0;
        for(int i = 0; i < num_list.length; i++){
            mulResult *= num_list[i];
            squareOfSum += num_list[i];
        }
        int squareOfSum2 = squareOfSum*squareOfSum;
//        int squareOfSum2 = (int) Math.pow(squareOfSum,2);

//        if(mulResult < squareOfSum2){
//            result = 1;
//        }else {
//            result = 0;
//        }
        result = (mulResult < squareOfSum) ? 1 : 0;
        return result;
    }
    public static void main(String[] args){
        원소들의곱과합 s = new 원소들의곱과합();
        System.out.println(s.solution(new int[]{3,4,5,2,1})); //1
        System.out.println(s.solution(new int[]{5,7,8,3})); //0
    }
}
