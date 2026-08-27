package programmers.level2.Day11;

// 각 가지수 즉, 1 ~ n개의 까지의 조합의 수
// 예를 들어 5개의 원형 수열 이 있다면 1개씩 조합 부터 5가지 조합 까지 이렇게 해야함
// 하지만 여기서는 부분 역속 수열을 생각해야함, 즉 입출력 예제를 본다면
//  7,9/9,1/1,1/1,4/4,7 이런식으로 연속적으로 되어있는 것들을 더해야함

// 풀이 과정
// 1. 원형 배열이라 끊임 없이 연결될 것이라 %연산자로 0 ~ n-1까지 반복
// 2. int sum을 만들어서 연산이 끝나면 그 값을 HashSet에 add.
// 3. 시작할 지점을 선택한 후 거기서 부터 1,2,3,...., n까지 하나씩 원소를 더 포함시켜가며 합을 갱신

import java.util.HashSet;

public class 연속부분수열합의개수 {
    public int solution1(int[] elements) {
        // HashSet 사용해서 중복 제거 후 제일 마지막에 result를 HashSet의 size만 뱉으면 풀림
        HashSet<Integer> set = new HashSet<>();
        int n = elements.length;
        for(int len = 1; len <= n; len++){        // 길이: n번
            for(int i = 0; i < n; i++){             // 시작점: n번
                int sum = 0;
                for(int k = 0; k < len; k++){        // ← 매번 "처음부터" 길이만큼 다시 더함!
                    int idx = (i+k) % n;
                    sum += elements[idx];
                }
                set.add(sum);
            }
        }
        return set.size();
    }

    // 이런게 있다만 생각하기
    public int solution2(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        int n = elements.length;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int len = 0; len < n; len++){
                int idx = (i + len) % n;
                sum += elements[idx];
                set.add(sum);
            }
        }

        return set.size();
    }

    public static void main(String[] args){
        연속부분수열합의개수 s = new 연속부분수열합의개수();
        System.out.println(s.solution1(new int[]{7,9,1,1,4})); //18
        System.out.println(s.solution2(new int[]{7,9,1,1,4})); //18
    }

}
