package programmers.level2.Day01;

// A는 내림차순, B는 오름 차순으로 하면 끝날 문제

public class 최솟값만들기 {
    public int solution(int []A, int []B) {
        int answer = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = i+1; j < A.length; j++){
                if(A[i] > A[j]){
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
        }
        for(int i = 0; i < B.length; i++){
            for(int j = i+1; j < B.length; j++){
                if(B[i] < B[j]){
                    int temp = B[i];
                    B[i] = B[j];
                    B[j] = temp;
                }
            }
        }
        for(int i = 0; i < A.length; i++){
            answer += A[i] * B[i];
        }
        return answer;
    }
    public static void main(String[] args){
        최솟값만들기 s = new 최솟값만들기();
        System.out.println(s.solution(new int[]{1,4,2}, new int[]{5,4,4})); //29
        System.out.println(s.solution(new int[]{1,2}, new int[]{3, 4})); //10
    }
}
