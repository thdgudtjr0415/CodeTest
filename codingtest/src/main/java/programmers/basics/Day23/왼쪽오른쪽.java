package programmers.basics.Day23;

import java.util.ArrayList;
import java.util.Arrays;

public class 왼쪽오른쪽 {
    public String[] solution1(String[] str_list) {
        ArrayList<String> list = new ArrayList<String>();
//        int lIdx = Arrays.asList(str_list).indexOf("l");
//        int rIdx = Arrays.asList(str_list).indexOf("r");
//        위랑 똑같은 것임 즉 저 말은 str_list에서 l,r의 인덱스 위치를 찾아주는 것임
        int lIdx = -1;
        int rIdx = -1;
        for(int j = 0; j < str_list.length; j++){if(str_list[j].equals("l")){lIdx = j; break;}}
        for(int j = 0; j < str_list.length; j++){if(str_list[j].equals("r")){rIdx = j; break;}}

        // 1. 둘 다 없으면 빈 배열 (아래 마감 코드가 알아서 처리해주므로 그냥 통과시켜도 됨)
        if (lIdx == -1 && rIdx == -1) {
            return new String[]{};
        }
        // 2. l만 존재하거나 (r이 결석), 혹은 둘 다 존재하는데 l이 먼저 나왔을 때!
        else if (lIdx != -1 && (rIdx == -1 || lIdx < rIdx)) {
            for (int i = 0; i < lIdx; i++) list.add(str_list[i]);
        }
        // 3. r만 존재하거나 (l이 결석), 혹은 둘 다 존재하는데 r이 먼저 나왔을 때!
        else {
            for (int i = rIdx + 1; i < str_list.length; i++) list.add(str_list[i]);
        }
        String[] result = new String[list.size()];
        if(list.isEmpty()) return new String[]{};
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
    public String[] solution2(String[] str_list) {
        for(int i = 0; i < str_list.length; i++){
            if(str_list[i].equals("l")) return Arrays.copyOfRange(str_list,0,i);
            if(str_list[i].equals("r")) return Arrays.copyOfRange(str_list,i+1,str_list.length);
        }
        return new String[]{};
}
    public static void main(String[] args){
        왼쪽오른쪽 s = new 왼쪽오른쪽();
        System.out.println(Arrays.toString(s.solution1(new String[]{"u", "u", "l", "r"}))); // u,u
        System.out.println(Arrays.toString(s.solution1(new String[]{"l"}))); // 공백
        System.out.println(Arrays.toString(s.solution2(new String[]{"u", "u", "l", "r"}))); // u,u
        System.out.println(Arrays.toString(s.solution2(new String[]{"l"}))); // 공백
    }
}
