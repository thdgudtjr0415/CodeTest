package programmers.level2.구현_시뮬레이션;

// m 명 늘어날때마다 서버 1대 증설, 어느 시간대 이용자가 m명 미만이라면
//어느 시간대의 이용자가 n x m명 이상 ~ (n + 1) x m명 미만이라면 최소 n대의 증설된 서버가 운영 중
// players의 길이 24 는 0시 부터 24시 까지
// k는 서버를 증설하고 켜놓는 시간
// 서버는 players / 이용자(m) 개의 서버가 운영되고 있어야한다


public class 서버증설횟수 {
    public int solution(int[] players, int m, int k) {
        int[] serverCount = new int[24];  // i시에 켜져 있는 서버 수
        int answer = 0;

        for(int i = 0; i < players.length; i++){
            int add = 0;
            int server = serverCount[i];
            int player = players[i];

            if((server + 1) * m <= player){
                add = player / m - server;   // 증설 필요 횟수
                if(add > 0){
                    answer += add;
                }
                for(int j = 0; j < k; j++){
                    if(i+j < 24){
                        serverCount[i+j] += add;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        서버증설횟수 s = new 서버증설횟수();
        System.out.println(s.solution(
                new int[]{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5},
                3, 5)); // 7
        System.out.println(s.solution(
                new int[]{0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0},
                5, 1)); // 11
        System.out.println(s.solution(
                new int[]{0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                1, 1)); // 12
    }
}
