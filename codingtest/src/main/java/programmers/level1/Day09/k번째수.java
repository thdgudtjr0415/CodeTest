package programmers.level1.Day09;

import java.util.Arrays;

public class k번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int a = 0; a < commands.length; a++){
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];
            int[] arr = new int[j-i+1];
            int idx = 0;
            for(int b = i-1; b <= j-1;  b++){
                arr[idx++] = array[b];
            }
            Arrays.sort(arr);
            answer[a] = arr[k-1];
        }
        return answer;
    }
    public static void main(String[] args){
        k번째수 s = new k번째수();
        System.out.println(Arrays.toString(s.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));
    }
}
