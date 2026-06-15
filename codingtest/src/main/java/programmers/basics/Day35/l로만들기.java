package programmers.basics.Day35;

public class l로만들기 {
    public String solution(String myString) {
        String result = "";
        for(int i = 0; i < myString.length(); i++){
            char c = myString.charAt(i);
            if(c < 'l'){
                result += 'l';
            }else {
                result += c;
            }
        }
        return result;
    }
    public static void main(String[] args){
        l로만들기 s = new l로만들기();
        System.out.println(s.solution("abcdevwxyz")); //"lllllvwxyz"
        System.out.println(s.solution("jjnnllkkmm")); //"llnnllllmm"
    }
}
