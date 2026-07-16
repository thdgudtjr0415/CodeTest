package programmers.level1.Day27;

import java.util.ArrayList;
import java.util.Stack;

// 이 문제는 딱 봐도 Stack문제 이지만 처음 풀때 이해하지 못해서 ArrayList로 먼저 풀었음

public class 크레인인형뽑기게임 {
    // ArrayList
    public int solution1(int[][] board, int[] moves) {
        ArrayList<Integer> list = new ArrayList<>();
        int result = 0;
        int n = board.length;
        for(int i = 0; i < moves.length; i++){
            int peek = moves[i] - 1; // 인덱스 때문에 -1 해줌
            int pass = 0;
            int tempPeek = 0;
            for(int j = 0; j < n; j++){
                if(board[pass][peek] == 0 && pass <= n-1){ // 여기 그냥 n넣어 버리면 인덱스 범위 초과
                    pass++;
                }else if(board[pass][peek] > 0){
                    tempPeek = board[pass][peek];
                    board[pass][peek] = 0;
                    break;
                }else if(pass == n-1 && board[pass][peek] == 0){
                    break;
                }
            }
            if(tempPeek > 0){
                list.add(tempPeek);
            }
            if(list.size() > 1 && list.get(list.size()-1).equals(list.get(list.size()-2))){
                // subList -> 보고 있으라는 이야기, subList(시작, 끝미만) 으로 생각하자.
               list.subList(list.size()-2, list.size()).clear();
               result+=2;
            }
        }
        return result;
    }
    // Stack
    public int solution2(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int n = board.length;
        for(int i = 0; i < moves.length; i++){
            int peek = moves[i] - 1; // 인덱스 때문에 -1 해줌
            int pass = 0;
            int tempPeek = 0;
            for(int j = 0; j < n; j++){
                if(board[pass][peek] == 0 && pass <= n-1){ // 여기 그냥 n넣어 버리면 인덱스 범위 초과
                    pass++;
                }else if(board[pass][peek] > 0){
                    tempPeek = board[pass][peek];
                    board[pass][peek] = 0;
                    break;
                }else if(pass == n-1 && board[pass][peek] == 0){
                    break;
                }
            }
//            if(tempPeek > 0){
//                stack.push(tempPeek);
//            }
//            // 여기서 stack도 get을 사용할 수 있지만 가장 마지막에 들어 온것을 확인하는 peek
//            if(!stack.isEmpty() && stack.peek().equals(stack.get(stack.size()-2))){
//                stack.pop();
//                stack.pop();
//                result += 2;
//            }

            if (tempPeek > 0) {
                // 스택이 비어있지 않고, 맨 위에 있는 인형이 방금 뽑은 인형과 같다면?
                if (!stack.isEmpty() && stack.peek().equals(tempPeek)) {
                    stack.pop(); // 원래 있던 인형을 터트려 버린다! (방금 뽑은 인형은 넣지도 않음)
                    result += 2;
                } else {
                    stack.push(tempPeek); // 다르면 그제서야 안전하게 쌓는다.
                }
            }
        }
        System.out.println(stack);
        return result;
    }
    public static void main(String[] args){
        크레인인형뽑기게임 s = new 크레인인형뽑기게임();
        System.out.println(s.solution1(
                new int[][]{
                        {0,0,0,0,0},
                        {0,0,1,0,3},
                        {0,2,5,0,1},
                        {4,2,4,4,2},
                        {3,5,1,3,1}},
                new int[]{1,5,3,5,1,2,1,4}));  // 4
        System.out.println(s.solution2(
                new int[][]{
                        {0,0,0,0,0},
                        {0,0,1,0,3},
                        {0,2,5,0,1},
                        {4,2,4,4,2},
                        {3,5,1,3,1}},
                new int[]{1,5,3,5,1,2,1,4}));  // 4
    }

}
