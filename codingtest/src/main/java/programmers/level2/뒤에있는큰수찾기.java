package programmers.level2;

import java.util.Arrays;
import java.util.Stack;

// 1. 자신보다 다음 인덱스가 크면 큰수를 사용해서 result에 담는다.
// 2. 만약 그다음수가 자신보다 작으면 -1을 담는다.
// 3. 혹은 그 다음수가 자신과 같으면 다다음수를 비교해서 그 수가 크면 바로 사용 아니면 -1


public class 뒤에있는큰수찾기 {
    // 코드는 맞지만 시간 초과
    public int[] solution1(int[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            // 마지막 인덱스 일때
            if(i == numbers.length-1){
                answer[i] = -1;
                break;
            }
            // 비교 작업
            // result 로 answer에 담기
            int result = 0;
            int prev = numbers[i];
            // 반복문으로 다음것을 비교
            for(int j = i+1; j < numbers.length; j++){
                int next = numbers[j];
                if(prev < next){
                    result = next;
                    break;
                }else if(prev >= next){
                    // 예외 작업, 앞의 수가 더 컷을 경우
                    int max = 0;
                    for(int k = j+1; k < numbers.length; k++){
                        max = Math.max(numbers[k], max);
                    }
                    // 앞의 numbers[i] 가 제일 큰 경우
                    if(numbers[i] > max){
                        result = -1;
                    // numbers[i] 보다 max 가 큰 경우
                    }else {
                        result = max;
                    }
                }
            }
            answer[i] = result;
        }
        return answer;
    }

    // 3중 반복문으로 인해서 지금 시간이 너무 오래 걸린듯 -> n^3배 만큼 돌아감
    // 그럼 다른 방법은 없나 스택이나 큐? -> 스택으로 해서 peek로 비교
    // 반복문은 한개만
    public int[] solution2(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        // 인덱스로 집어넣기
        for(int i = 0; i < numbers.length; i++){
            while(!stack.isEmpty() && (numbers[stack.peek()] < numbers[i])){
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int num = stack.pop();
            answer[num] = -1;
        }
        return answer;
    }

    public static void main(String[] args){
        뒤에있는큰수찾기 s = new 뒤에있는큰수찾기();
        System.out.println(Arrays.toString(s.solution2(new int[]{2, 3, 3, 5}))); //3,5,5,-1
        System.out.println(Arrays.toString(s.solution2(new int[]{9,1,5,3,6,2}))); // -1,5,6,6,-1,-1

//        int[] r1 = s.solution2(new int[]{2, 3, 3, 5});
//        assert Arrays.equals(r1, new int[]{3, 5, 5, -1}) : "r1 : 결과 = " + Arrays.toString(r1);
//        int[] r2 = s.solution2(new int[]{9, 1, 5, 3, 6, 2});
//        assert Arrays.equals(r2, new int[]{-1, 5, 6, 6, -1, -1}) : "r2 결과 = " + Arrays.toString(r2);
//        int[] r3 = s.solution2(new int[]{1, 5, 3, 3});
//        assert Arrays.equals(r3, new int[]{5, -1, -1, -1}) : "r3 결과 = " + Arrays.toString(r3);
    }
}
