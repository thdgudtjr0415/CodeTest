package programmers.level2.DP_수학;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// [풀이 순서]
// 1. 순번은 0부터 셈 -> 순번 = k - 1
// 2. 그룹 크기(첫 자리가 같은 줄의 개수) = (남은 사람 수 - 1)! -> n=4면 6 -> 2 -> 1
// 3. 순번 / 그룹 크기의 몫 = 남은 숫자 목록의 인덱스 -> 그 숫자를 고름
// 4. 고른 숫자는 목록에서 뺌
// 5. 순번 % 그룹 크기의 나머지 = 다음 자리의 새 순번
// 6. 2~5를 자리마다 반복함 (마지막 자리는 숫자가 1개만 남음)
// ※ k는 최대 20!까지 커질 수 있어서 long 사용

public class 줄서는방법 {
    public int[] solution(int n, long k) {
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[n];
        for(int i = 0; i < n; i++) list.add(i+1);
        k--;
        for(int i = 0; i < n; i++){
            int index = Math.toIntExact((k) /factorial(n -i- 1));
            long remain = ((k) % factorial(n -i- 1));
            k= remain;
            answer[i] = list.get(index);
            list.remove(index);
        }

        return answer;
    }
    private long factorial(int num){
        long n = 1;
        for(long i = 1; i <= num; i++) n = n*i;
        return n;
    }

    public static void main(String[] args) {
        줄서는방법 s = new 줄서는방법();
        System.out.println(Arrays.toString(s.solution(3, 5))); // [3, 1, 2]
    }
}
//1, 23,32 -> 3명 1일때 2 * 3 -> 6 -> 3!
//2, 13,31
//3, 12,21
// 123,132,213,231,312,321 중에 k번째(5)는 312 인데 인덱스 4인 것이 정답임
// (5-1)/ (3-1)! = 2(인덱스임) -> 3, 나머지는 0
// 3쪽에는 2가지 밖에 없음 남은 것은 1,2
// 위에 나머지 0/(2-1)! = 0,  그럼 -> 1
// 그리고 나머지 2 붙임

//1, 234,243,324,342,423,432 4명, 1일때 6 * 4 -> 24
//2, 134,143,314,341,413,431
//3, 124,142,214,241,412,421 -> 여기에 13번째
//4, 123,132,213,231,312,321
// 여기서 13 번째를 찾아보면 답은 3124
// 첫째 자리 = (13-1)/24 -> 0 번째?
// 둘째 자리 =
// 셋쨰 자리 =
