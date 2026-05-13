package programmers.basics.Day07;

import java.util.Arrays;

public class 수열과구간쿼리_03 {
    public int[] solution(int[] arr, int[][] queries) {
        // 원본 배열 안 건드리려고 복사본 만듦
        int[] result = arr.clone();

        /*
        // 일반 반복문 방식
        for(int i = 0; i < queries.length; i++){
            // 쿼리 배열의 i번째 줄에서 각각 방 번호 꺼내기
            int a = queries[i][0];
            int b = queries[i][1];

            // 바로 방 번호(인덱스)로 접근해서 스왑
            int temp = result[a];
            result[a] = result[b];
            result[b] = temp;
        }
        */

        // 향상된 반복문 사용 (2차원 배열 queries에서 1차원 배열 query를 하나씩 꺼냄)
        // 이렇게 되면 int i = 0; i < queries.length ... 처럼 queries에서 하나씩 빼옴
        // 그럼 1단계는 [0,3] 2단계는 [1,2] 이런식으로 뽑혀 나와서 시작할꺼임
        for(int[] query : queries) {
            // query[0], query[1]에 담긴 숫자가 문제에서 말한 방 번호(인덱스)임
            int a = query[0];
            int b = query[1];

            int temp = result[a];      // a번 방 사람 잠시 밖(temp)으로 빼둠
            result[a] = result[b];     // 빈 a번 방에 b번 방 사람 집어넣음
            result[b] = temp;          // 밖에 있던(temp) 사람을 b번 방에 넣음
        }

        return result;
    }

    public static void main(String[] args){
        수열과구간쿼리_03 s = new 수열과구간쿼리_03();
        System.out.println(Arrays.toString(
                s.solution(new int[]{0,1,2,3,4}, new int[][]{{0,3},{1,2},{1,4}})));
    }
}