package programmers.level1.Day09;

import java.util.Arrays;

public class 문자열내마음대로정렬하기 {
    public String[] solution(String[] strings, int n) {
        String[] answer = strings.clone();
        for(int i = 0; i < answer.length; i++){
            for(int j = i+1; j < answer.length; j++){
                if(answer[i].charAt(n) > answer[j].charAt(n)){
                    String temp = answer[j];
                    answer[j] = answer[i];
                    answer[i] = temp;
                }else if(answer[i].charAt(n) == answer[j].charAt(n)){
                    // compareTo 해서 0보다 크면 answer가 사전순으로 뒤에 있다는 뜻
                    if(answer[i].compareTo(answer[j]) > 0){
                        String temp = answer[j];
                        answer[j] = answer[i];
                        answer[i] = temp;
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        문자열내마음대로정렬하기 s = new 문자열내마음대로정렬하기();
        System.out.println(Arrays.toString(s.solution(new String[]{"sun", "bed", "car"},1))); // ["car", "bed", "sun"]
        System.out.println(Arrays.toString(s.solution(new String[]{"abce", "abcd", "cdx"},2))); // ["abcd", "abce", "cdx"]
    }
}
