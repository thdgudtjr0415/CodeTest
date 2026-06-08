package programmers.basics.Day28;

import java.util.Arrays;

public class ad제거하기 {
    public String[] solution1(String[] strArr) {
        int count = 0;
        for(String str:strArr) if(!str.contains("ad")) count++;
        String[] result = new String[count];
        int idx = 0;
        for(int i = 0; i < strArr.length; i++){
            if(!strArr[i].contains("ad")){
                result[idx++] = strArr[i];
            }
        }
        return result;
    }
    public String[] solution2(String[] strArr) {
        return Arrays.stream(strArr) // 1. 배열을 컨베이어 벨트(스트림)에 하나씩 올린다.
                // 2. 각 문자열(str)을 검사해 "ad"가 포함되지 않은(!), 즉 참(True)인 데이터만 통과시킨다.
                .filter(str -> !str.contains("ad"))
                // 3. 통과한 알맹이들의 개수에 딱 맞게 새로운 String 배열을 만들어 리턴한다.
                .toArray(String[]::new);
    }
    public static void main(String[] args) {
        ad제거하기 s = new ad제거하기();
        System.out.println(Arrays.toString(s.solution1(new String[]{"and","notad","abcd"})));
        System.out.println(Arrays.toString(s.solution1(new String[]{"there","are","no","a","ds"})));
        System.out.println(Arrays.toString(s.solution2(new String[]{"and","notad","abcd"})));
        System.out.println(Arrays.toString(s.solution2(new String[]{"there","are","no","a","ds"})));
    }
}
