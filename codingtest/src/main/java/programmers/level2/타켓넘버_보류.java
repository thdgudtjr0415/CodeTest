package programmers.level2;

// 최단거리, 최소횟수 -> 큐, BFS
// 모든 경우의수 , 몇가지 방법인지? -> 재귀, 백트래킹, DFS


//numbers 배열과 target을 DFS 메서드에 집어 넣기
//DFS 메서드 만들어서 재귀를 되도록 코드를 작성 후 나오는 횟수 반환
//나온 그 횟수를 answer에 삽입하여 제출

public class 타켓넘버_보류 {
    public int solution(int[] numbers, int target) {
        int idx = 0;
        int sum = 0;
        int count = dfs(numbers, target, idx, sum);
        return count;
    }

    private int dfs(int[] numbers, int target, int idx, int sum) {
        if(idx == numbers.length){
            if(sum == target){
                return 1;
            }else {
                return 0;
            }
        }
        int plus = dfs(numbers, target, idx+1, sum + numbers[idx]);
        int minus = dfs(numbers, target, idx+1, sum - numbers[idx]);

        return plus + minus;
    }

    public static void main(String[] args) {
        타켓넘버_보류 s = new 타켓넘버_보류();
        System.out.println(s.solution(new int[]{1,1,1,1,1}, 3)); //5
        System.out.println(s.solution(new int[]{4,1,2,1}, 4)); //2
    }
}
