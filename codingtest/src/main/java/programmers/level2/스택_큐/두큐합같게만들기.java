package programmers.level2.스택_큐;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 [풀이 흐름]
 1. 두 큐의 합 = 전체 합. 홀수면 나눌 수 없으니 -1, 목표는 전체 합 / 2
 2. 합이 큰 쪽에서 poll -> 작은 쪽에 offer 반복, 같아지면 횟수 반환
 3. 합은 long (원소 10^9 * 최대 60만 개). 합은 변수로 들고 있다가 poll한 값만큼 갱신 (매번 sum() 금지)
 4. 끝나지 않는 경우 (n = 한 큐의 길이): 두 큐는 q1+q2(길이 2n)의 연속 구간이라
    시작/끝이 각각 최대 2n번 움직이면 처음 모양으로 돌아옴 -> 4n번 넘으면 -1
    (2n은 부족: 13번 필요한 입력 존재)
 5. 목표보다 큰 원소가 하나라도 있으면 바로 -1 가능 (이번엔 구현 안 함)

 [Queue 구현체 비교] 변수 타입은 Queue, new 뒤만 다르다
 - ArrayDeque : 배열 기반 FIFO. 보통 가장 빠르고 메모리도 적게 씀. null 불가. -> 이 문제에서 사용
 - LinkedList : 노드(연결 리스트) 기반 FIFO. 원소마다 노드 객체가 생겨 메모리가 더 들고 느린 편. null 가능
 - PriorityQueue : 넣은 순서가 아니라 우선순위(기본 작은 값)순으로 poll. 넣고 빼는 데 O(log n).
                   -> 입력 순서가 중요한 이 문제에서는 사용 불가
*/

// 코드리뷰
// 1. Sum을 반복문 안에서 돌리면 시간초과 및 느림
// 2. solution1은 큐 풀이, solution2는 두 포인터 풀이 (q1+q2 배열 하나, 큐 없이 start/end만 이동)

public class 두큐합같게만들기 {
    public int solution1(int[] queue1, int[] queue2) {
        Queue<Integer> oneQueue = new ArrayDeque<>();
        Queue<Integer> twoQueue = new ArrayDeque<>();
        for(int q : queue1) oneQueue.offer(q);
        for(int q : queue2) twoQueue.offer(q);
        int len =  queue1.length + queue2.length; // 두 큐 길이의 합
        // 배열이면 Arrays.stream(queue1).asLongStream().sum() (int 합이 안 넘치면 asLongStream 생략 가능)
        long oneSum = oneQueue.stream().mapToLong(Integer::longValue).sum();
        long twoSum = twoQueue.stream().mapToLong(Integer::longValue).sum();


        int answer = -1;
        for(int i = 0; i < len*4; i++){
            if(oneSum == twoSum) return i;
            if(oneSum > twoSum){
                int num = oneQueue.poll();
                oneSum -= num;
                twoQueue.offer(num);
                twoSum += num;
            }else {
                int num = twoQueue.poll();
                twoSum -= num;
                oneQueue.offer(num);
                oneSum += num;
            }
        }
        return answer;
    }
    public int solution2(int[] queue1, int[] queue2) {
        int n = queue1.length;
        int len = n * 2; // 두 배열을 합친 전체 길이
        long[] arr = new long[len]; // 두 배열을 이어 붙여서 포인터(start, end)로 계산
        long sum = 0, total = 0;

        for(int i = 0; i < n; i++){
            arr[i] = queue1[i];
            arr[n+i] = queue2[i];
            total += arr[i] + arr[n+i];
            // 큐1의 합만 구하면 됨: total은 변하지 않으니 큐2 합 = total - sum
            sum += arr[i];
        }
        // 전체 합이 홀수면 반으로 나눌 수 없으므로 -1
        if(total % 2 != 0) return -1;
        long target = total/2; // 각 큐가 가져야 할 합

        // 큐1 = arr[start] ~ arr[end-1]
        int start = 0, end = n;
        // count = 지금까지 한 작업 횟수. 작업 전에 확인하므로 len*2번 한 상태까지 보려면 <=
        for(int count = 0; count <= len*2; count++){
            if(sum == target) return count;
            if(sum < target){            // 큐2 맨 앞(arr[end])을 큐1로
                sum += arr[end % len];
                end++;
            }else {                      // 큐1 맨 앞(arr[start])을 큐2로
                sum -= arr[start % len];
                start++;
            }
        }


        return -1;
    }
    public static void main(String[] args){
        두큐합같게만들기 s = new 두큐합같게만들기();
        System.out.println(s.solution2(new int[]{3,2,7,2}, new int[]{4,6,5,1})); //2
        System.out.println(s.solution2(new int[]{1,2,1,2}, new int[]{1,10,1,2})); //7
        System.out.println(s.solution2(new int[]{1,1}, new int[]{1,5})); //-1
    }
}
