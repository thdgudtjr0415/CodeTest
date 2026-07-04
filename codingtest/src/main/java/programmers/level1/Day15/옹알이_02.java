package programmers.level1.Day15;

public class 옹알이_02 {
    public int solution(String[] babbling) {
        String[] babyWords = new String[]{"aya", "ye", "woo", "ma"};
        String[] wordwords = new String[]{"ayaaya", "yeye", "woowoo", "mama"};
        int result = 0;
        for(int i = 0 ; i < babbling.length; i++){
            boolean flag = false;
            for(int j = 0 ; j < wordwords.length ; j++){
                if(babbling[i].contains(wordwords[j])){
                    flag = true;
                    break;
                }
            }
            if(flag) continue;

            for(int j = 0 ; j < babyWords.length; j++){
                    babbling[i] = babbling[i].replace(babyWords[j], " ");
            }
            if(babbling[i].trim().isEmpty()){
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args){
        옹알이_02 s = new 옹알이_02();
        System.out.println(s.solution(new String[]{"aya", "yee", "u", "maa"})); //1
        System.out.println(s.solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"})); //2
    }
}
