package programmers.level2.Day07;

import java.util.Arrays;

public class 구명보트 {
    public int solution1(int[] people, int limit) {
        int answer = 0;
        // 정렬해서 제일 무거운 사람 과 제일 가벼운 사람 합쳐서 limit넘는지 확인
        Arrays.sort(people);
        int start = 0;
        int end = people.length - 1;

        while(start<=end){
            if(people[end] + people[start] <= limit){
                answer++;
                start++;
                end--;
            }else if(people[end] + people[start] > limit){
                answer++;
                end--;
            }
        }
        return answer;
    }

    public int solution2(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int start = 0;
        int end = people.length - 1;

        while(start<=end){
            // 먼저 start == end 인 경우는 승객이 1명만 남은 경우임으로 그부분 생각
            if(start == end){
                answer++;
                break;
            }
            // 지금 잘 짜여져 있지만 코드가 중복인 줄들이 있으니 줄여보자
            // answer++, end--, 이코드들이 중복되어었음
            if(people[end] + people[start] <= limit) {
                start++;
            }
            answer++;
            end--;
        }
        return answer;
    }
    public static void main(String[] args) {
        구명보트 s = new 구명보트();
//        System.out.println(s.solution1(new int[]{70,50,80,50}, 100)); //3
//        System.out.println(s.solution1(new int[]{70,80,50}, 100)); //3

        System.out.println(s.solution2(new int[]{70,50,80,50}, 100)); //3
        System.out.println(s.solution2(new int[]{70,80,50}, 100)); //3
    }
}
