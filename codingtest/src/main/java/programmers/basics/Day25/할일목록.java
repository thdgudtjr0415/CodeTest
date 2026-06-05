package programmers.basics.Day25;

import java.util.Arrays;

public class 할일목록 {
    public String[] solution(String[] todo_list, boolean[] finished) {
        int count=0;
        for(boolean fail:finished){if(!fail){count++;}}
        String[] result = new String[count];
        int idx=0;
        for(int i=0;i<todo_list.length;i++){
            if(!finished[i]){
                result[idx++]=todo_list[i];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        할일목록 s = new 할일목록();
        System.out.println(Arrays.toString(s.solution(
                new String[]{"problemsolving", "practiceguitar", "swim", "studygraph"},
                new boolean[]{true, false, true, false}))); // "practiceguitar", "studygraph"
    }
}
