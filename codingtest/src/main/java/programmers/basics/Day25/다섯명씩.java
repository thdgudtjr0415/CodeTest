package programmers.basics.Day25;

import java.util.Arrays;

public class 다섯명씩 {
    public String[] solution(String[] names) {
        String[] result = new String[((names.length - 1) / 5) + 1];
        for(int i = 0; i < result.length; i++) result[i] = names[i*5];
        return result;
    }
    public static void main(String[] args){
        다섯명씩 s = new 다섯명씩();
        System.out.println(Arrays.toString(
                s.solution(new String[]{"nami", "ahri", "jayce", "garen", "ivern", "vex", "jinx"})));

    }
}
