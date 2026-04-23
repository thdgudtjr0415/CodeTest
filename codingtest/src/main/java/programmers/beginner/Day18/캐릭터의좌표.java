package programmers.beginner.Day18;

import java.util.Arrays;

public class 캐릭터의좌표 {
    public int[] solution(String[] keyinput, int[] board) {
        int[] result = new int[2];
        int x = 0;
        int y = 0;
        int maxX = (board[0]-1)/2;
        int maxY = (board[1]-1)/2;

        // 이때 조건 줄때 주의할 점
        // 처음엔 abs로 절대값으로 했지만 그건 오류가 날 수 있다는 점 알아두기
        for(int i = 0; i < keyinput.length; i++){
            if(keyinput[i].equals("left")){
                if(x > -maxX) x--;
            }else if(keyinput[i].equals("right")){
                if(x < maxX) x++;
            }else if(keyinput[i].equals("up")){
                if(y < maxY) y++;
            }else if(keyinput[i].equals("down")) {
                if(y > -maxY) y--;
            }
            result[0] = x;
            result[1] = y;
        }

        return result;
    }
    public static void main(String[] args) {
        캐릭터의좌표 s = new 캐릭터의좌표();
        System.out.println(Arrays.toString(
                s.solution(new String[]{"left", "right", "up", "right", "right"}, new int[]{11, 11}))); // 2,1
        System.out.println(Arrays.toString(
                s.solution(new String[]{"down", "down", "down", "down", "down"}, new int[]{7, 9}))); // 0,-4
    }
}
