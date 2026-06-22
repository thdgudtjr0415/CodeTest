package programmers.level1.Day04;

// 내적 : a[i] * b[i] 를 끝까지 하면됨 즉 이것도 n까지의 길이가 있다면, 0 ~ n-1 까지를 하면됨

public class 내적 {
    public int solution(int[] a, int[] b) {
        int result = 0;
        for(int i = 0; i < a.length; i++){
            result += a[i] * b[i];
        }
        return result;
    }
    public static void main(String[] args) {
        내적 s = new 내적();
        System.out.println(s.solution(new int[]{1,2,3,4}, new int[]{-3,-1,0,2})); //3
        System.out.println(s.solution(new int[]{-1,0,1}, new int[]{1,0,-1})); //-2
    }
}
