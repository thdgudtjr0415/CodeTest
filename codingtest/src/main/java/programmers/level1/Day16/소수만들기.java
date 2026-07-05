package programmers.level1.Day16;

public class 소수만들기 {
    public int solution(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            int sumNum = 0;
            for(int j = i+1; j < nums.length; j++){
                for(int k = j+1; k < nums.length; k++){
                    sumNum = nums[i] + nums[j] + nums[k];
                    boolean isPrime = true;
                    for(int l = 2; l*l <= sumNum; l++){
                        if(sumNum % l == 0){
                            isPrime = false;
                            break;
                        }
                    }
                    if(isPrime){
                        result++;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        소수만들기 s = new 소수만들기();
        System.out.println(s.solution(new int[]{1,2,3,4})); //1
        System.out.println(s.solution(new int[]{1,2,7,6,4})); //4
    }
}
