package programmers.beginner.Day24;
import java.util.Arrays;

// 여기서는 연속된 수의 합을 구하는 공식을 찾는게 빠를듯
// num 3, total 12 라고 가정햇을때
// -> x, x+1, x+2 를 더한 값이 12 가 나와야함
// 그렇다면 3x + 3 = 12 가 나오게 되고
// x = 3이 도출 되면서 값은 3, 4, 5 가 나옴

public class 연속된수의합 {
    public int[] solution(int num, int total) {
        int[] result = new int[num];
        // 3x + 3 에서 3 부분
        int constantTerm = 0;
        // 3x + 3 에서 3 부분(일반 상수항)
        for(int i = 0; i < num; i++){
            constantTerm += i;
        }
        // 3x + 3 에서 3x 부분
        int startX = (total - constantTerm)/num;

        for(int i = 0; i < num; i++){
            result[i] = startX + i;
        }
        return result;
    }
    public static void main(String[] args) {
        연속된수의합 s = new 연속된수의합();
        System.out.println(Arrays.toString(s.solution(3, 12))); //3,4,5
        System.out.println(Arrays.toString(s.solution(5, 15))); //1,2,3,4,5
        System.out.println(Arrays.toString(s.solution(4, 14))); //2,3,4,5
        System.out.println(Arrays.toString(s.solution(5, 5))); //-1,0,1,2,3

    }
}
