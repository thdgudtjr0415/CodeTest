package programmers.level2.DP_수학;

import java.util.Arrays;

/*
 * 2 x n 타일링 (프로그래머스 12900)
 *
 * 가로 2, 세로 1 타일로 세로 2, 가로 n인 바닥을 빈틈없이 채우는 방법의 수를
 * 1,000,000,007로 나눈 나머지로 반환한다. (n은 60,000 이하)
 *
 * [규칙] n=1 -> 1, n=2 -> 2, n=3 -> 3, n=4 -> 5 ... 피보나치와 같은 모양
 *        f(n) = f(n-1) + f(n-2)
 *
 * [풀이]
 * - solution1 : 배열에 저장하며 앞에서부터 채우기 (DP)           -> 최종 풀이 (통과)
 * - solution2 : 재귀로 점화식 그대로                              -> 시간 초과 (왜 느린지 정리)
 * - solution3 : [2][n] 배열에 타일을 직접 놓아가며 개수 세기      -> 완전탐색, 작은 n만 가능 (규칙 검증용)
 */
public class 타일링2xn {

    private static final int MOD = 1000000007;

    // ===== 풀이 1 : 배열에 저장하며 앞에서부터 채우기 (통과) =====
    public long solution1(int n) {
        long[] saveArr = new long[n+1];
        for(int i = 1; i <= n; i++){
            if(i <= 2) saveArr[i] = i;
            if(i > 2){
                saveArr[i] = (saveArr[i-1] + saveArr[i-2]) % 1000000007;
            }
        }
        long answer = saveArr[n];
        return answer % 1000000007;
    }

    // ===== 풀이 2 : 재귀 (시간 초과) =====
    // TODO 1. solution2에서 tiling(n)을 호출해서 반환하기
    // TODO 2. tiling에 나머지(% MOD) 처리 추가하기
    // TODO 3. n이 커지면 왜 느린지 직접 확인하고 주석으로 적기 (tiling(5)에서 tiling(3)은 몇 번 계산되나?)
    public int solution2(int n) {
        int[] tileArr = new int[n+1];
        int answer = tiling(n, tileArr);
        System.out.println(Arrays.toString(tileArr));
        return answer;
    }

    private int tiling(int n, int[] tileArr) {
        if(n <= 2) return n;
        if(tileArr[n] != 0){
            return tileArr[n] % 1000000007;
        }else {
            tileArr[n] = (tiling(n-1, tileArr) + tiling(n-2, tileArr)) % 1000000007;
        }
        return tileArr[n];
    }

    // ===== 풀이 3 : [2][n] 배열에 타일을 직접 놓으며 세기 (완전탐색, 작은 n만) =====
    // 0 = 빈 칸, 1 = 타일이 놓인 칸
    // TODO 1. 비어 있는 칸 중 "가장 왼쪽 위 칸"을 찾는다. (열 순서대로 찾아야 한다)
    // TODO 2. 그 칸을 채울 수 있는 방법을 모두 시도한다. (놓을 수 있는 조건 확인: 이미 찬 칸인지, 배열 밖인지)
    // TODO 3. 타일을 놓은 뒤 남은 부분을 다시 같은 방식으로 채운다. (놓고 -> 이어서 채우고 -> 되돌리기)
    // TODO 4. 모든 칸이 채워지면 방법 1개로 센다.
    public int solution3(int n) {
        int[][] tile = new int[2][n];
        return count(tile);
    }

    private int count(int[][] tile) {
        int n = tile[0].length;

        // 1. 가장 먼저 만나는 빈 칸 찾기 (열 순서대로, 같은 열이면 위 칸부터)
        int ei = -1, ej = -1;
        for (int j = 0; j < n && ei == -1; j++) {
            for (int i = 0; i < 2; i++) {
                if (tile[i][j] == 0) {
                    ei = i;
                    ej = j;
                    break;
                }
            }
        }

        // 빈 칸이 없으면 바닥이 다 채워진 것 -> 방법 1개
        if (ei == -1) return 1;

        int result = 0;

        // 2. 세로로 놓기 (윗줄이고, 아래 칸이 비어 있을 때)
        if (ei == 0 && tile[1][ej] == 0) {
            tile[0][ej] = 1;
            tile[1][ej] = 1;
            result += count(tile);   // 이어서 채우기
            tile[0][ej] = 0;         // 되돌리기
            tile[1][ej] = 0;
        }

        // 3. 가로로 놓기 (오른쪽 칸이 배열 안이고, 비어 있을 때)
        if (ej + 1 < n && tile[ei][ej + 1] == 0) {
            tile[ei][ej] = 1;
            tile[ei][ej + 1] = 1;
            result += count(tile);   // 이어서 채우기
            tile[ei][ej] = 0;        // 되돌리기
            tile[ei][ej + 1] = 0;
        }

        return result;
    }

    // 배열 확인용 (디버깅)
    private void tileView(int[][] tile) {
        for(int i = 0; i < tile.length; i++){
            for(int j = 0; j < tile[i].length; j++){
                System.out.print(tile[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        타일링2xn s = new 타일링2xn();
//        System.out.println(s.solution1(4)); //5
//        System.out.println(s.solution1(3)); //3
        System.out.println(s.solution1(50)); //3
        System.out.println(s.solution2(4)); //5
        System.out.println(s.solution2(50)); //5
//        System.out.println(s.solution3(4)); //5
    }
}
