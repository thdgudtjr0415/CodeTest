package programmers.basics.Day03;
/*
 * [문자열 결합 치트키: String.join]
 * for문이나 StringBuilder 없이 배열을 한 번에 문자열로 합치는 메서드.
 * * 1. 기본 결합 (구분자 없음)
 * String.join("", arr);      // 결과: "abc"
 * * 2. 특정 문자(구분자) 끼워 넣기
 * String.join(" -> ", arr);  // 결과: "a -> b -> c"
 */
public class 문자리스트를문자열로변환하기 {
    // 반복문으로
    public String solution1(String[] arr) {
        String result = "";

        for(int i = 0; i < arr.length; i++){
            result += arr[i];
        }
        return result;
    }

    public String solution2(String[] arr) {
        String result = "";
        result = String.join("", arr);
        return result;
    }
    public static void main(String[] args) {
        문자리스트를문자열로변환하기 s = new 문자리스트를문자열로변환하기();
        System.out.println(s.solution1(new String[]{"a","b","c"}));
        System.out.println(s.solution2(new String[]{"a","b","c"}));
    }
}
