package programmers.level1.Day28;

public class 성격유형검사하기 {
    public String solution(String[] survey, int[] choices) {
        String result = "";
        char[] alphabet = {'R','T','C','F','J','M','A','N'};
        int [] alphabetIndex = new int[alphabet.length];
        int n = survey.length;
        for(int i = 0; i < n; i++){
            int front = 0;
            int back = 0;
            if(choices[i] == 0){
                continue;
            }else if(choices[i] < 4){
                front = 4 - choices[i];
            }else if(choices[i] > 4){
                back = choices[i] - 4;
            }
            // 누적하는이유는 다른 질문에서 같은 알파벳이 올수도 있기 때문에
            if(front > back){
                for(int j = 0; j < alphabet.length; j++){
                    if(survey[i].charAt(0) == alphabet[j]){
                        alphabetIndex[j] += front;
                    }
                }
            }else if(front < back){
                for(int j = 0; j < alphabet.length; j++){
                    if(survey[i].charAt(1) == alphabet[j]){
                        alphabetIndex[j] += back;
                    }
                }
            }
        }
        for(int j = 1; j < alphabet.length; j+=2){
            if(alphabetIndex[j] > alphabetIndex[j-1]){
                result += alphabet[j];
            }else if(alphabetIndex[j] < alphabetIndex[j-1]){
                result += alphabet[j-1];
            }else {
                result += alphabet[j-1];
            }
        }
        return result;
    }
    public static void main(String[] args){
        성격유형검사하기 s = new 성격유형검사하기();
        System.out.println(s.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5})); // TCMA
        System.out.println(s.solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3})); // RCJA
    }
}
