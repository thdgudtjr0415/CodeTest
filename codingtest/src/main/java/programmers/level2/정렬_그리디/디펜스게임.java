package programmers.level2.정렬_그리디;

// 준호는 처음에 병사 n명을 가지고 있습니다.
// 매 라운드마다 enemy[i]마리의 적이 등장합니다.
// 남은 병사 중 enemy[i]명 만큼 소모하여 enemy[i]마리의 적을 막을 수 있습니다.
// 게임에는 무적권이라는 스킬이 있으며, 무적권을 사용하면 병사의 소모없이 한 라운드의 공격을 막을 수 있음
// 무적권은 최대 k번 사용, 최대한 많은 라운드를 진행

import java.util.PriorityQueue;

public class 디펜스게임 {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(); // 뭘 넣든 작은 값부터 나옴
        int answer = 0;
        if(enemy.length <= k) return enemy.length;
        // 무적권 사용
        for(int i = 0; i < enemy.length; i++){
            if(pQueue.size() < k){
                pQueue.offer(enemy[i]);
            }else {
                if(pQueue.peek() < enemy[i]){
                    n -= pQueue.poll();
                    pQueue.offer(enemy[i]);
                }else {
                    n -= enemy[i];
                }
            }
            if(n < 0) return i;
        }
        return enemy.length;
    }

    public static void main(String[] args) {
        디펜스게임 s = new 디펜스게임();
        System.out.println(s.solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1})); // 5
        System.out.println(s.solution(2, 4, new int[]{3, 3, 3, 3})); // 4
    }
}
