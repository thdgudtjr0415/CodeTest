package programmers.level1.Day22;

//바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
//빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
//이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
//그럼 여분을 챙겨온 아이가 도난(lost)배열에 들어가가 된다면 체육복은 1개인것이라서 그대로

// 문제 풀이 순서
// 1. int 배열 n개를 만들어서 모든 아이들에게 체육복 1을 부여
// 2. lost 배열을 만난다면 -1, reserve를 찾는다면 +1
// 3. 그래서 가까운 아이에게 빌려주는 것까지

import java.util.Arrays;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n];
        Arrays.fill(students, 1);
        for(int i = 0; i < reserve.length; i++) {
            students[reserve[i]-1]++;
        }
        for(int i = 0; i < lost.length; i++) {
            students[lost[i]-1]--;
        }
        // 여기 반복문에서 엄청 헷갈리는데 i번 째의 각 앞 뒤를 확인 하기 위해서는 양 끝쪽 방들을 잘 보기
        // 즉 ArrayIndexOutOfBoundsException 안터지게 조심
        for(int i = 0; i < students.length; i++) {
            if(students[i] == 0){
                if(i-1 >= 0 && students[i-1] > 1){
                    students[i-1]--;
                    students[i]++;
                }else if(i+1 < students.length && students[i+1] > 1){
                    students[i+1]--;
                    students[i]++;
                }
            }
        }
        for(int i = 0; i < students.length; i++) {
            if(students[i] > 0){
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        체육복 s = new 체육복();
        System.out.println(s.solution(5, new int[]{2,4}, new int[]{1,3,5})); // 5
        System.out.println(s.solution(5, new int[]{2,4}, new int[]{3})); // 4
        System.out.println(s.solution(3, new int[]{3}, new int[]{1})); // 2
    }
}
