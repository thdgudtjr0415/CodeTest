package programmers.beginner.Day10;

public class 점의위치구하기 {
    public int solution(int[] dot) {
        int result = 0;

            if(dot[0] > 0 && dot[1] > 0){
                result = 1;
            }else if(dot[0] < 0 && dot[1] > 0){
                result = 2;
            }else if(dot[0] < 0 && dot[1] < 0){
                result = 3;
            }else if(dot[0] > 0 && dot[1] < 0){
                result = 4;
            }


        return result;
    }

    public static void main(String[] args) {
        점의위치구하기 p = new 점의위치구하기();
        System.out.println(p.solution(new int[]{2, 4}));
        System.out.println(p.solution(new int[]{-7, 9}));
    }
}
