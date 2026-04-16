package programmers.beginner;

import java.util.Arrays;

public class 배열원소의길이 {
    public int[] solution(String[] strlist) {
        int[] result = new int[strlist.length];

        // 여기서는 쉽게 String 배열의 각 번쨰에서 그냥 길이 구해주면 끝
        for(int i=0;i<strlist.length;i++){
            result[i] = strlist[i].length();
        }

        return result;
    }
    public static  void main(String[] args) {
        배열원소의길이 s = new 배열원소의길이();
        System.out.println(Arrays.toString(
                s.solution(new String[]{"We", "are", "the", "world!"}))); // 2,3,3,6
        System.out.println(Arrays.toString(
                s.solution(new String[]{"I", "Love", "Programmers."}))); // 1,4,12

    }
}
