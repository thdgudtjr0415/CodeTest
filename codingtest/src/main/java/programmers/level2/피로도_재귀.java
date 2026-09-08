package programmers.level2;

// ["최소 필요 피로도", "소모 피로도"]
// 재귀 쪽 구조
// 만약 (더 시도할 던전이 하나도 없다면):
//    return count
//아니면:
//    최선의 값 = 0 (또는 시작값)
//    각각의 안 쓴 던전에 대해:
//        만약 지금 피로도로 갈 수 있다면:
//            그 던전을 쓰기로 하고
//            재귀 호출해서 값을 받아옴
//            최선의 값 = Math.max(최선의 값, 받아온 값)
//            되돌리기 (그 던전을 다시 안 쓴 걸로)
//    return 최선의 값
public class 피로도_재귀 {
    public int solution(int k, int[][] dungeons){
        // 완전 탐색
        int count = 0;
        boolean[] use =  new boolean[dungeons.length];
        return dfs(dungeons, use, k, count);
    }
    public int dfs(int[][] dungeons, boolean[] use, int k, int count){
        if(dungeons.length == count){
            return count;
        }else {
            // 재귀라서 다음 단계에서 이어서 하기 위해 best = count로 함
            int best = count;
            for(int i = 0; i < dungeons.length; i++){
                if(!use[i] && k >= dungeons[i][0]){
                    use[i] = true;
                    int result = dfs(dungeons, use, k-dungeons[i][1], count + 1);
                    best = Math.max(best, result);
                    use[i] = false;
                }
            }
            return best;
        }
    }

    public static void main(String[] args){
        피로도_재귀 s = new 피로도_재귀();
        System.out.println(s.solution(80, new int[][]{{80,20},{50,40},{30,10}})); // 3
    }
}
