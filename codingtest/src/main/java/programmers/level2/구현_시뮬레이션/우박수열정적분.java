package programmers.level2.구현_시뮬레이션;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//1-1. 입력된 수가 짝수라면 2로 나눕니다.
//1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
//2.결과로 나온 수가 1보다 크다면 1번 작업을 반복합니다.

public class 우박수열정적분 {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> list = new ArrayList<>();
        list.add(k);
        while(k != 1){
            if(k % 2 == 0){
                k = k /2;
            }else {
                k = k*3 + 1;
            }
            list.add(k);
        }
        int n = list.size()-1; // 1될 때까지 계산한 횟수
        for(int i = 0; i < ranges.length; i++){
            int[] range = ranges[i];
            int start = range[0];
            int end = n + range[1];
            if(start > end){
                answer[i] = -1; // answer가 double이라 알아서 -1.0
            }else {
                // 구간으로 따지기 0~1, 1~2 이런식으로 그럼 마지막은 빼야함
                for(int j = start; j < end; j++){
                    int[] curPoint = {j, list.get(j)};
                    int[] nextPoint = {j+1, list.get(j+1)};
                    answer[i] += curPoint[1] + (double)(nextPoint[1]-curPoint[1])/2;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        우박수열정적분 s = new 우박수열정적분();
        System.out.println(Arrays.toString(s.solution(5, new int[][]{{0,0},{0,-1},{2,-3},{3,-3}}))); // [33.0, 31.5, 0.0, -1.0]
        System.out.println(Arrays.toString(s.solution(3, new int[][]{{0,0},{1,-2},{3,-3}}))); // [47.0, 36.0, 12.0]
    }
}
