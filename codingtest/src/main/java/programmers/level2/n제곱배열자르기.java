package programmers.level2;

import java.util.Arrays;

public class n제곱배열자르기 {
    public int[] solution(int n, long left, long right) {
        int[] result = new int[Math.toIntExact(right - left + 1)];
        int idx = 0;
        for(long i = left; i <= right; i++) {
            long row = i/n;
            long col = i%n;
            result[idx++] = (int) Math.max(row+1, col+1);
        }
        return result;
    }

    public static void main(String[] args) {
        n제곱배열자르기 s = new n제곱배열자르기();
        System.out.println(Arrays.toString(s.solution(3,2,5))); //3,2,2,3
        System.out.println(Arrays.toString(s.solution(4,7,14))); //4,3,3,3,4,4,4,4
    }
}
