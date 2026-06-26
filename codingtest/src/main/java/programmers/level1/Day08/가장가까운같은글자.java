package programmers.level1.Day08;

import java.util.Arrays;

public class 가장가까운같은글자 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] alphabet = new int[26];
        for(int i = 0; i < s.length(); i++){
            int alphabetIndex = s.charAt(i) - 'a';
            if(alphabet[alphabetIndex] == 0){
                alphabet[alphabetIndex]++;
                answer[i] = -1;
            }else if(alphabet[alphabetIndex] == 1){
                for(int j = 0; j < i; j++){
                    if(s.charAt(j) == s.charAt(i)){
                        answer[i] = i-j;
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        가장가까운같은글자 s = new 가장가까운같은글자();
        System.out.println(Arrays.toString(s.solution("banana"))); //[-1, -1, -1, 2, 2, 2]
        System.out.println(Arrays.toString(s.solution("foobar"))); //[-1, -1, 1, -1, -1, -1]
    }
}
