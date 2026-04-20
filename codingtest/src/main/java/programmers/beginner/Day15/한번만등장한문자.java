package programmers.beginner.Day15;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 한번만등장한문자 {
    public String solution1(String s) {
        String result = "";
        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = 0;
            for(int j = 0; j < s.length(); j++) {
                if(c == s.charAt(j)) {
                    count++;
                }
            }
            if(count == 1) {
                list.add(c);
            }
        }
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) {
            result += list.get(i);
        }

        return result;
    }
    public String solution2(String s) {
        // int 배열
        //for(int n : numbers)
        // String 배열
        //for(String s : words)
        // ArrayList
        //for(Integer n : list)

        String result = "";
        char[] arr = s.toCharArray();
        // 미리 정렬해놓기
        Arrays.sort(arr);

        // 2. 한 번만 등장한 문자만 추가
        // 향상된 for문
        // arr의 원소를 하나씩 c에 담아서 반복하겠다는 뜻
//        for(char c : arr){ 이때는 index 즉 arr[i] 이런게 필요 없을때 사용
        for(int i = 0; i < arr.length; i++) {
            char c = arr[i];
            // indexOf는 처음 나오는 인덱스 위치 (숫자), lastIndexOf 마지막으로 나온 숫자
            // 즉 이 두개가 일치하면 한번만 나왔다는것을 의미
            if(s.indexOf(c) == s.lastIndexOf(c)){  // 처음과 마지막 위치가 같으면 1번만 등장!
                result += c;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        한번만등장한문자 s = new 한번만등장한문자();
        System.out.println(s.solution1("abcabcadc"));
        System.out.println(s.solution1("abdc"));
        System.out.println(s.solution1("hello"));
        System.out.println(s.solution2("abcabcadc"));
        System.out.println(s.solution2("abdc"));
        System.out.println(s.solution2("hello"));
    }
}
