package programmers.beginner.Day15;

public class 인덱스바꾸기 {
    public String solution(String my_string, int num1, int num2) {
        String result = "";
        // 이러면 공백 포함 배열로 모두 들어가기
        String[] arr = my_string.split("");

        String c = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = c;

        for(int i = 0; i < arr.length; i++){
            result += arr[i];
        }
        return result;
    }
    public static void main(String[] args) {
        인덱스바꾸기 s = new 인덱스바꾸기();
        System.out.println(s.solution("hello", 1, 2)); // hlelo
        System.out.println(s.solution("I love you", 3, 6)); // I l veoyou
    }
}
