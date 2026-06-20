package programmers.level1.Day02;

import java.util.Arrays;

public class x만큼간격이있는n개의숫자 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for(int i=0;i<n;i++){
            answer[i] = (long)x*i+x ;
        }
        return answer;
    }
    public static void main(String[] args) {
        x만큼간격이있는n개의숫자 s = new x만큼간격이있는n개의숫자();
        System.out.println(Arrays.toString(s.solution(2, 5)));
        System.out.println(Arrays.toString(s.solution(4, 3)));
        System.out.println(Arrays.toString(s.solution(-4, 2)));
    }

}
