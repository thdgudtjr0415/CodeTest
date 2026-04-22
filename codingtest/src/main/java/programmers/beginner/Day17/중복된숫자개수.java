package programmers.beginner.Day17;

public class 중복된숫자개수 {
    public int solution(int[] array, int n) {
        int result = 0;

        for(int i = 0; i < array.length; i++) {
            if(array[i] == n) {
                result++;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        중복된숫자개수 s = new 중복된숫자개수();
        System.out.println(s.solution(new int[]{1, 1, 2, 3, 4, 5},1)); // 2
        System.out.println(s.solution(new int[]{0, 2, 3, 4},1)); // 0
    }
}
