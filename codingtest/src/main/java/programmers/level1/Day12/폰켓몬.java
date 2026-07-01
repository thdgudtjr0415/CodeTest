package programmers.level1.Day12;

import java.util.HashSet;

public class 폰켓몬 {
    public int solution(int[] nums) {
        // 최대한 다른 숫자를 가지고 가야함
        int getPhone = nums.length/2;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
//        for(int i = 0; i < nums.length; i++){
//            set.add(nums[i]);
//        }
        return Math.min(set.size(), getPhone);
    }
    public static void main(String[] args){
        폰켓몬 s = new 폰켓몬();
        System.out.println(s.solution(new int[]{3,1,2,3})); // 2
        System.out.println(s.solution(new int[]{3,3,3,2,2,4})); // 3
        System.out.println(s.solution(new int[]{3,3,3,2,2,2})); // 2
    }
}
