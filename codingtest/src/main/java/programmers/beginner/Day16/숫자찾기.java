package programmers.beginner.Day16;

public class 숫자찾기 {
    public int solution(int num, int k) {
        int result = -1;
        String[] arr = String.valueOf(num).split("");

        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals(String.valueOf(k))){
                result = i+1;
                break;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        숫자찾기 s = new 숫자찾기();
        System.out.println(s.solution(29183, 1)); // 3
        System.out.println(s.solution(232443, 4)); // 4
        System.out.println(s.solution(123456, -7)); // -1
    }
}
