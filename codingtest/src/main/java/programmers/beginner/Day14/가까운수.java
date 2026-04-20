package programmers.beginner.Day14;

// 이문제는 이렇게 풀어도 되긴 하는데 Math.abs(절대값 구해주는 함수)를 사용하는 방법도 있음
// 그러면 첫 for문이 필요 없어짐

public class 가까운수 {
    public int solution(int[] array, int n) {
        int result = array[0];
        int[] num = new int[array.length];
        for(int i = 0; i < array.length; i++){
            if(array[i] > n){
                num[i] = array[i]-n;
            }else {
                num[i] = n-array[i];
            }
        }
        int min = num[0];
        for(int i = 1; i < num.length; i++){
            if(num[i] < min){
                min = num[i];
                result = array[i];
            }else if(num[i] == min && array[i] < result){
                result = array[i];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        가까운수 s = new 가까운수();
        System.out.println(s.solution(new int[]{3, 10, 28}, 20)); //28
        System.out.println(s.solution(new int[]{10, 11, 12}, 13)); //12
    }
}

