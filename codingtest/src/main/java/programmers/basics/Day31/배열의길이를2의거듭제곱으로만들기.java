package programmers.basics.Day31;

import java.util.Arrays;

public class 배열의길이를2의거듭제곱으로만들기 {
    public int[] solution(int[] arr) {
        int len = 1;
        while(len < arr.length) len*=2;
        int[] result = new int[len];
//        Arrays.fill(result, 0);
        for(int i = 0; i < arr.length; i++) result[i] = arr[i];
        return result;
    }
    public static void main(String[] args) {
        배열의길이를2의거듭제곱으로만들기 s = new 배열의길이를2의거듭제곱으로만들기();
        System.out.println(Arrays.toString(s.solution(new int[]{1,2,3,4,5,6})));
        System.out.println(Arrays.toString(s.solution(new int[]{58,172,746,89})));
    }
}
