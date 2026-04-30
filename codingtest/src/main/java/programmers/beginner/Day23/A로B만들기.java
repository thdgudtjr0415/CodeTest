package programmers.beginner.Day23;

import java.util.Arrays;

public class A로B만들기 {
    public int solution(String before, String after) {
        int result = 0;
        char[] beforeArray = before.toCharArray();
        char[] afterArray = after.toCharArray();
        Arrays.sort(beforeArray);
        Arrays.sort(afterArray);

        // Arrays.equals는 배열 두개가 완전히 같은지 보는 것
        // 즉 순서와 내용이 같을 때 를 보는 메서드이다
        if(Arrays.equals(beforeArray, afterArray)){
            result = 1;
        }

        return result;
    }
    public static void main(String[] args) {
        A로B만들기 s = new A로B만들기();
        System.out.println(s.solution("olleh","hello"));
        System.out.println(s.solution("allpe","apple"));

    }
}
