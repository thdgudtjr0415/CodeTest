package programmers.level2.구현_시뮬레이션;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 맨해튼 거리
// 두 테이블 T1, T2가 행렬 (r1, c1), (r2, c2)에 각각 위치하고 있다면,
// T1, T2 사이의 맨해튼 거리는 |r1 - r2| + |c1 - c2| 입니다. ↩
// 거리 두기를 위해 응사자들 끼리 맨해튼 거리가 2 이하로 앉지 말기
// 단 응시자가 앉아 있는 사이에 파티션으로 막혀 있는 경우 가능

// 맨해튼 거리는 2 이하로 앉지 않기 즉 3부터 가능
// p는 앉아있는 자리, 0은 빈 테이블, x 는 파티션
// 거리두기 잘 하고 있으면 1, 아니면 0

public class 거리두기확인하기 {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for(int idx = 0; idx < places.length; idx++){
            List<int[]> list = new ArrayList<>();
            String[] arr = places[idx];
            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < arr.length; j++){
                    if(arr[i].charAt(j) == 'P'){
                        list.add(new int[]{i, j});
                    }
                }
            }
            boolean safe = isSafe(arr, list);
            if(safe){
                answer[idx] = 1;
            }else {
                answer[idx] = 0;
            }

        }
        return answer;
    }
    // 거리두기 맨해튼 거리 몇인지
    private int getDistance(int[] a, int[] b){
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
    // 거리두기 잘 지켰는지 확인하는 메서드
    private boolean isSafe(String[] arr, List<int[]> list){
        for(int i = 0; i < list.size(); i++){
            int[] p1 = list.get(i);
            for(int j = i+1; j < list.size(); j++){
                int[] p2 = list.get(j);
                int distance = getDistance(p1, p2);
                if(distance == 1){
                    return false;
                }else if(distance == 2){
                    // 이 경우는 P?P(가로방향, 세로방향)
                    // (P?, ?P) or (?P, P?)인 경우 밖에 없음
                    if(p1[0] == p2[0]){
                        int[] x1 = {p1[0], p2[1]-1};
                        if(arr[x1[0]].charAt(x1[1]) != 'X'){
                            return false;
                        }
                    }else if(p1[1] == p2[1]) {
                        int[] x1 = {p2[0]-1, p2[1]};
                        if(arr[x1[0]].charAt(x1[1]) != 'X'){
                            return false;
                        }
                    }else { // (P?, ?P) or (?P, P?)인 경우 ex(0,0), (1,1) or (0,1), (1,0)
                        int[] x1 = {p1[0], p2[1]};
                        int[] x2 = {p2[0], p1[1]};
                        if(arr[x1[0]].charAt(x1[1]) != 'X' || arr[x2[0]].charAt(x2[1]) != 'X'){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }


    private void view(String[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length(); j++){
                System.out.print(arr[i].charAt(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        거리두기확인하기 s = new 거리두기확인하기();
        System.out.println(Arrays.toString(s.solution(new String[][]{
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        }))); // [1, 0, 1, 1, 1]
    }
}
