package programmers.level1.Day01;

import java.util.Arrays;

public class 정수내림차순으로배치하기 {
    public long solution1(long n) {
        String num = String.valueOf(n);
        char[] arr = num.toCharArray();
        Arrays.sort(arr);
        String result = "";
        for(int i = arr.length-1; i >= 0; i--){
            result += arr[i];
        }
        long answer = Long.parseLong(result);
        return answer;
    }
    // 버블 정렬
    public long solution2(long n) {
        String num = String.valueOf(n);
        char[] arr = num.toCharArray();
        for(int i = 0; i < arr.length; i++){
            for(int j = 1; j < arr.length; j++){
                if(arr[j-1] < arr[j]){
                    char temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        // 🌟 2. for문 대신 new String(arr)로 한 방에 조립하기!
        String result = new String(arr);
        long answer = Long.parseLong(result);
        return answer;
    }
    public static void main(String[] args) {
        정수내림차순으로배치하기 s = new 정수내림차순으로배치하기();
//        System.out.println(s.solution1(118372));
        System.out.println(s.solution2(118372));
    }
}
