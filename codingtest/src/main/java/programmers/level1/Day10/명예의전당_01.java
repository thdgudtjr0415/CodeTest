package programmers.level1.Day10;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 명예의전당_01 {
    public int[] solution1(int k, int[] score) {
        int[] result = new int[score.length];
        int[] hallOfFame = new int[k];
        Arrays.fill(hallOfFame, Integer.MAX_VALUE);
        for(int i = 0; i < score.length; i++){
            int currentScore = score[i];
            if(i < k){
                hallOfFame[i] = currentScore;
                Arrays.sort(hallOfFame);
                result[i] = hallOfFame[0]; // 이래야 최하위 점수만 출력됨
            }else {
                if(currentScore > hallOfFame[0]){ // 최하위 점수보다 크면 삽입
                    hallOfFame[0] = currentScore;
                }
                Arrays.sort(hallOfFame);
                result[i] = hallOfFame[0];
            }
        }
        return result;
    }

    // 이번엔 큐 사용
    public int[] solution2(int k, int[] score) {
        int[] result = new int[score.length];
        // 이게 정렬과 쉬프트를 알아서 해주는 클래스임 그래서 뭐가 들어가도 정렬해줌
        PriorityQueue<Integer> hallOfFame = new PriorityQueue<>();
        for(int i = 0; i < score.length; i++){
            // 먼저 기본적으로 큐에 삽입
            hallOfFame.add(score[i]);
            // 큐에 삽입 된 후 알아서 정렬 되어있을테니 제일 작은 점수를 빼줌 poll 하면 알아서 제일 첫번째꺼 빼줌
            if(hallOfFame.size() > k){
                hallOfFame.poll();
            }
            // 현재 주머니 맨 앞에 있는 녀석(.peek())이 무조건 살아남은 꼴찌(최하위)다!
            // 여기서 peek는 get의 느낌이 강하고, poll은 출력도 하지만 없에는 느낌이 강함 둘다 출력은 함
            result[i] = hallOfFame.peek();
        }
        return result;
    }
    public static void main(String[] args){
        명예의전당_01 s = new 명예의전당_01();
        System.out.println(Arrays.toString(s.solution1(3,new int[]{10,100,20,150,1,100,200}))); //[10, 10, 10, 20, 20, 100, 100]
        System.out.println(Arrays.toString(s.solution1(4,new int[]{0,300,40,300,20,70,150,50,500,1000}))); //[0, 0, 0, 0, 20, 40, 70, 70, 150, 300]

        System.out.println(Arrays.toString(s.solution2(3,new int[]{10,100,20,150,1,100,200}))); //[10, 10, 10, 20, 20, 100, 100]
        System.out.println(Arrays.toString(s.solution2(4,new int[]{0,300,40,300,20,70,150,50,500,1000}))); //[0, 0, 0, 0, 20, 40, 70, 70, 150, 300]
    }
}
