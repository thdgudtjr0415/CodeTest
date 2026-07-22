package programmers.level1.Day07;

public class 삼총사_backtracking {
    // 전역 변수로 result 을 정의 내려서 다른 메서드들도 사용 가능하게 하기
    public static int result = 0;

    public int solution(int[] number) {
        result = 0;
        boolean[] visited = new boolean[number.length];
        backtracking(number, visited, 0,0,0);
        return result;
    }

    private void backtracking(int[] number, boolean[] visited, int start, int count, int sum) {
        if(count == 3){
            if(sum == 0){
                result++;
            }
            return;
        }
        for(int i = start; i < number.length; i++){
            visited[i] = true;
            backtracking(number, visited, i + 1, count + 1, sum + number[i]);
            visited[i] = false;
        }
    }

    public static void main(String[] args){
        삼총사_backtracking s = new 삼총사_backtracking();
        System.out.println(s.solution(new int[]{-2,3,0,2,-5})); //2
//        System.out.println(s.solution(new int[]{-3,-2,-1,0,1,2,3})); //5
//        System.out.println(s.solution(new int[]{-1,1,-1,1})); //0
    }
}
