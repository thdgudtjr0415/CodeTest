package programmers.basics.Day28;

import java.util.Arrays;

public class 공백으로구분하기_02 {
    public String[] solution1(String my_string) {
        String[] arr = my_string.split(" ");
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(!arr[i].equals("")){
                count++;
            }
        }
        String[] result = new String[count];
        int idx = 0;
        for(int i = 0; i < arr.length; i++){
            if(!arr[i].equals("")){
                result[idx++] = arr[i];
            }
        }
        return result;
    }
    public String[] solution2(String my_string) {
        // 정규 표현식
        // 1. trim() : 문자열의 맨 앞과 맨 뒤에 붙은 쓸데없는 공백들 제거
        // 2. split("\\s+") : 공백이 1개 or 여러 개든(연속된 공백 전체)을 공백 없이 나눠줌
        // 여기서 \\s+
        // \\s = 자바에서 공백을 의미하는 특수기호(Space, 탭 등)
        // 여기서 " " 이건 스페이스바 공백 1개를 의미, \\s 이건 공백과 관련된 모든것을 의미
        // + = 1개 이상을 의미
        return my_string.trim().split("\\s+");
    }
    public static void main(String[] args) {
        공백으로구분하기_02 s = new 공백으로구분하기_02();
        System.out.println(Arrays.toString(s.solution1(" i    love  you")));
        System.out.println(Arrays.toString(s.solution1("    programmers  ")));
        System.out.println(Arrays.toString(s.solution2(" i    love  you")));
        System.out.println(Arrays.toString(s.solution2("    programmers  ")));
    }
}
