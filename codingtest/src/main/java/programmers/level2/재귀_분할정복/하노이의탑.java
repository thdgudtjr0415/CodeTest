package programmers.level2.재귀_분할정복;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//1. 작은 원판 n-1개를 1번 기둥에서 2번 기둥으로 옮긴다
//2. 가장 큰 원판을 1번 기둥에서 3번 기둥으로 옮긴다
//3. 작은 원판 n-1개를 2번 기둥에서 3번 기둥으로 옮긴다


public class 하노이의탑 {
    public int[][] solution(int n) {
        List<int[]> list = new ArrayList<>();
        int from = 1;
        int to = 3;
        moveDisks(n, from, to, list);
        return list.stream().toArray(int[][]::new);
    }

    private void moveDisks(int n, int from, int to, List<int[]> list) {
        if(n == 1){
            list.add(new int[]{from, to});
            return;
        }else if(n >= 2){
            // 쉬어가는 기둥
            int rest = 6 - (from + to);
            // 1단계: 작은 원판 n-1개를 from -> rest
            moveDisks(n-1, from, rest, list);
            // 2단계: 가장 큰 원판을 from -> to
            list.add(new int[]{from, to});
            // 3단계: 작은 원판 n-1개를 rest -> to
            moveDisks(n-1, rest, to, list);
        }
    }

    public static void main(String[] args) {
        하노이의탑 s = new 하노이의탑();
        System.out.println(Arrays.deepToString(s.solution(2))); // [[1, 2], [1, 3], [2, 3]]
        System.out.println(Arrays.deepToString(s.solution(3))); // [[1,3], [1,2], [3,2], [1,3], [2,1], [2,3], [1,3]]
    }
}
// 원판 1개 일때 1 -> 3 {1,3}
// 원판 2개 일떄 1,2(작은거) / 1,3(큰것) / 2,3(작은것)
// 원판 3개 일때 1,3 소 / 1,2 중 / 3,2 소 / 1,3 대 / 2,1 소 / 2,3 중/ 1,3 소