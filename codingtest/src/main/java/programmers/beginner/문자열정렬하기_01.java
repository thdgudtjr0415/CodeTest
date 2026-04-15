package programmers.beginner;

import java.util.*;

//"hi12392" → [1, 2, 2, 3, 9]
//1. 문자열에서 숫자만 골라내기
//2. 오름차순 정렬
//3. int[] 로 반환
// ArrayList로 푸는게 좋을듯?
// 이 문제는 ArrayList로 푸는것과 일반으로 푸는 것 두개로 풀어보자

public class 문자열정렬하기_01 {
    public int[] solution1(String my_string) {
        // 1. 일반적인 풀이
        int count = 0;
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if(c >= '0' && c <= '9'){
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for(int i = 0; i < my_string.length(); i++){
            char c = my_string.charAt(i);
            if(c >= '0' && c <= '9'){
                result[index] = (int)(c -'0');
                index++;
            }
        }
        Arrays.sort(result);
        return result;
    }
    public int[] solution2(String my_string) {
        // ArrayList
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if(c >= '0' && c <= '9'){
                // ArrayList는 .add로 추가해야함 왜냐하면 애초에 정해진 길이가 없어서 그럼
                list.add(c - '0'); // 여기서 숫자만 들어감 하지만 c 는 문자니까 -'0'해서 숫자로 변환
            }
        }
        Collections.sort(list);

        // list는 length아님 size임
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            // list는 꺼낼때 get 주의하기
            result[i] = list.get(i);
        }
        return result;
    }
    public static void main(String[] args) {
        문자열정렬하기_01 s = new 문자열정렬하기_01();
        System.out.println(Arrays.toString(s.solution1("hi12392")));
        System.out.println(Arrays.toString(s.solution1("p2o4i8gj2")));
        System.out.println(Arrays.toString(s.solution1("abcde0")));
        System.out.println(Arrays.toString(s.solution2("hi12392")));
        System.out.println(Arrays.toString(s.solution2("p2o4i8gj2")));
        System.out.println(Arrays.toString(s.solution2("abcde0")));
    }
}
