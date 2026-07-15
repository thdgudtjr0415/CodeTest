package programmers.level1.Day26;

import java.util.Arrays;
import java.util.HashMap;

public class 달리기경주 {
    /**
     * [방식 1] 단순 2중 루프 탐색 (구현은 맞으나 시간 초과 대상)
     * - 시간 복잡도: O(N * M) -> 최대 50,000 * 1,000,000 = 500억 번 연산으로 실격
     */
    public String[] solution1(String[] players, String[] callings) {
        String[] result = new String[players.length];
        for(int i = 0; i < callings.length; i++){
            String callPlayer = callings[i];
            // 정렬 코드 처럼 tmep 써서 바꿔주기
            for(int j = 1; j < players.length; j++){
                if(players[j].equals(callPlayer)){
                    String tempPlayer = players[j-1];
                    players[j-1] =  players[j];
                    players[j] = tempPlayer;
                    // 찾았으면 break;로 멈춰서 나오기
                    break;
                }
            }
        }
        // 향상된 반복문 사용해보기
        int idx = 0;
        for(String player : players){
            result[idx] = player;
            idx++;
        }
        return result;
    }
    /**
     * [방식 2] HashMap을 활용한 역인덱싱 최적화 (통과 완료)
     * - 시간 복잡도: O(N + M) -> 등수 조회를 O(1)로 단축하여 총 약 105만 번 연산으로 해결
     */
    public String[] solution2(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>(); // 여기에 이름이랑 처음 등수들 넣기
        for(int i = 0; i < players.length; i++){
            map.put(players[i], i);
        }
        for(int i = 0; i < callings.length; i++){
            String callPlayer = callings[i];
            int currentIdx = map.get(callPlayer); // 현재 callilngs로 뽑힌 사람의 등수
            int frontIdx = currentIdx-1; // 앞사람 등수

            // 여기서 본래의 players 배열 건드려서 순서 바꿔주기
            String frontPlayer = players[frontIdx];
            players[frontIdx] = players[currentIdx];
            players[currentIdx] = frontPlayer;

            // 이제 바꿔줬으니 등수 업데이트
            map.put(callPlayer, frontIdx);
            map.put(frontPlayer, currentIdx);
        }
        String[] result = new String[players.length];
        for(int i = 0; i < players.length; i++){
            result[i] = players[i];
        }
        return result;
    }
    public static void main(String[] args){
        달리기경주 s = new 달리기경주();
        System.out.println(Arrays.toString(s.solution1(new String[]{"mumu", "soe", "poe", "kai", "mine"},
                new String[]{"kai", "kai", "mine", "mine"}))); //["mumu", "kai", "mine", "soe", "poe"]
        System.out.println(Arrays.toString(s.solution2(new String[]{"mumu", "soe", "poe", "kai", "mine"},
                new String[]{"kai", "kai", "mine", "mine"}))); //["mumu", "kai", "mine", "soe", "poe"]
    }
}
