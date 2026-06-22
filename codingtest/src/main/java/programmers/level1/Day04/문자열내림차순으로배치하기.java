package programmers.level1.Day04;

public class 문자열내림차순으로배치하기 {
    public String solution(String s) {
        char[] word = s.toCharArray();
        for(int i = 0; i < word.length; i++){
            for(int j = i+1; j < word.length; j++){
                if(word[i] < word[j]){
                    char temp = word[j];
                    word[j] = word[i];
                    word[i] = temp;
                }
            }
        }
        String answer = new String(word);
        return answer;
    }
    public static void main(String[] args) {
        문자열내림차순으로배치하기 s = new 문자열내림차순으로배치하기();
        System.out.println(s.solution("Zbcdefg")); //gfedcbZ
    }
}
