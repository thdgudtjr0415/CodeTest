package programmers.level2.투포인터;

import java.util.Arrays;

//start, end, sum을 준비하고 answer는 {0, 길이 - 1}로 둔다.
//합이 k보다 작으면 끝을 늘리면서 그 원소를 더하고, k보다 크면 시작을 옮기면서 그 원소를 뺀다.
//합이 k와 같으면 지금 구간이 기록된 구간보다 짧을 때만 answer를 바꾼다.
//이 문제는 포인터 위치 잘 확인하면서 계산하기

class 연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {
        // 제일 긴 경우로 해놓고 해당 답을 찾을 때마다 갱신하는 걸로
        int[] answer = {0, sequence.length-1};
        int n = sequence.length;
        int start = 0;
        int end = 0;
        int sum = sequence[0];

        while(start != n && end != n){
            if(sum < k){ // 작을때
                if(end < n-1){
                    sum += sequence[++end];
                }else {
                    break;
                }
            }else if(sum > k){ // 클때
                if(start < n-1){
                    sum -= sequence[start++];
                }else {
                    break;
                }
            }else { // 같을때
                if(answer[1] - answer[0] > end - start){
                    answer[0] = start;
                    answer[1] = end;
                }else if(answer[1] - answer[0] == end - start){
                    if(start < answer[0]){
                        answer[0] = start;
                        answer[1] = end;
                    }
                }
                sum -= sequence[start++];
            }
        }
        return answer;
    }

    public static void main(String[] args){
        연속된부분수열의합 s = new 연속된부분수열의합();
        System.out.println(Arrays.toString(s.solution(new int[]{1,2,3,4,5}, 7))); // 2,3
        System.out.println(Arrays.toString(s.solution(new int[]{1,1,1,2,3,4,5}, 5))); // 6,6
        System.out.println(Arrays.toString(s.solution(new int[]{2,2,2,2,2}, 6))); // 0,2
    }
}
