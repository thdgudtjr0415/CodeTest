package programmers.basics.Day31;

public class 문자열묶기 {
    public int solution(String[] strArr) {
        int result = 0;
        int[] arr = new int[31];
        for (int i = 0; i < strArr.length; i++) {
            int num = strArr[i].length();
            arr[num]++;
        }
        int max = 0;
        for(int i = 1; i < 31; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        result = max;
        return result;
    }
    public static void main(String[] args) {
        문자열묶기 s = new 문자열묶기();
        System.out.println(s.solution(new String[]{"a","bc","d","efg","hi"})); //2
    }
}
