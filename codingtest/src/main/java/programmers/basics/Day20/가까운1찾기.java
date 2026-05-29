package programmers.basics.Day20;

public class 가까운1찾기 {
    public int solution(int[] arr, int idx) {
        // 기본 실패시 -1
        int result = -1;
        for(int i = 0 ; i < arr.length; i++){
            if(i >= idx && arr[i] == 1){
                result = i;
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        가까운1찾기 s = new 가까운1찾기();
        System.out.println(s.solution(new int[]{0,0,0,1}, 1)); // 3
        System.out.println(s.solution(new int[]{1,0,0,1,0,0}, 4)); // -1
        System.out.println(s.solution(new int[]{1,1,1,1,0}, 3)); // 3
    }
}
