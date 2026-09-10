package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
    public int[] solution1(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] clear = new boolean[progresses.length];
        int idx = 0;
        while(!clear[clear.length-1]){
            int clearNum =0;
            if(progresses[idx] < 100){
                for(int i = 0; i < progresses.length; i++){
                    progresses[i] += speeds[i];
                }
            }else if(progresses[idx] >= 100){
                clearNum++;
                clear[idx++] = true;
                while(idx < progresses.length && progresses[idx] >= 100){
                    clear[idx++] = true;
                    clearNum++;
                }
            }
            if(clearNum > 0) list.add(clearNum);
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    // 자료구조 중 boolean 배열이 필요할까? 한줄만 쓰고 있어서 불필요할듯
    public int[] solution2(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        int idx = 0;
        while (idx < progresses.length) {
            int clearNum = 0;
            if (progresses[idx] < 100) {
                for (int i = 0; i < progresses.length; i++) {
                    progresses[i] += speeds[i];
                }
            } else if (progresses[idx] >= 100) {
                clearNum++;
                idx++;
                while (idx < progresses.length && progresses[idx] >= 100) {
                    clearNum++;
                    idx++;
                }
            }
            if (clearNum > 0) list.add(clearNum);
        }
        // stream 도 잘 기억해놓기
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    // Queue -> FIFO
    //queue.offer(값);      // 맨 뒤에 추가 (= push 같은 느낌)
    //queue.poll();          // 맨 앞의 것을 꺼내면서 제거 (꺼낸 값을 반환)
    //queue.peek();          // 맨 앞의 것을 확인만 (제거 안 함)
    //queue.isEmpty();       // 비어있는지 확인
    //queue.size();          // 몇 개 들어있는지
    public int[] solution3(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> indexQueue = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++){
            indexQueue.add(i);
        }
        while(!indexQueue.isEmpty()){
            int num = 0;
            if(progresses[indexQueue.peek()] < 100){
                for(int i = 0; i < progresses.length; i++){
                    progresses[i] += speeds[i];
                }
            }else {
                while(!indexQueue.isEmpty() && progresses[indexQueue.peek()] >= 100){
                    indexQueue.poll();
                    num++;
                }
            }
            if(num > 0) list.add(num);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        기능개발 s = new 기능개발();
        System.out.println("solution1");
        System.out.println(Arrays.toString(s.solution1(new int[]{93,30,55}, new int[]{1,30,5}))); // 2,1
        System.out.println(Arrays.toString(s.solution1(new int[]{95,90,99,99,80,99}, new int[]{1,1,1,1,1,1}))); // 1,3,2
        System.out.println();
        System.out.println("solution2");
        System.out.println(Arrays.toString(s.solution2(new int[]{93,30,55}, new int[]{1,30,5}))); // 2,1
        System.out.println(Arrays.toString(s.solution2(new int[]{95,90,99,99,80,99}, new int[]{1,1,1,1,1,1}))); // 1,3,2
        System.out.println();
        System.out.println("solution3");
        System.out.println(Arrays.toString(s.solution3(new int[]{93,30,55}, new int[]{1,30,5}))); // 2,1
        System.out.println(Arrays.toString(s.solution3(new int[]{95,90,99,99,80,99}, new int[]{1,1,1,1,1,1}))); // 1,3,2
    }
}
