package programmers.level1.Day14;

import java.util.Arrays;

public class 덧칠하기 {
    public int solution(int n, int m, int[] section) {
        // nM의 벽 길이, m의 페인트칠 할수 있는 거리, 칠해야하는 번호, n은 1 부터 n까지 1m 씩 쪼갬
        int result = 0;
        int maxLen = 0;
        for(int i=0;i<section.length;i++){
            if(section[i] > maxLen){
                result++;
                maxLen = section[i] + m-1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        덧칠하기 s = new 덧칠하기();
        System.out.println(s.solution(8,4, new int[]{2,3,6})); //2
        System.out.println(s.solution(5,4, new int[]{1,3})); //1
        System.out.println(s.solution(4,1, new int[]{1,2,3,4})); //4
    }
}
