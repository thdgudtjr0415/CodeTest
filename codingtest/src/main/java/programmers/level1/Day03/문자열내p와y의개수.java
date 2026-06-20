package programmers.level1.Day03;

public class 문자열내p와y의개수 {
    boolean solution(String s) {
        boolean answer = false;
        int countP = 0;
        int countY = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'p' ||   s.charAt(i) == 'P' ){
                countP++;
            }else if(s.charAt(i) == 'y'  ||   s.charAt(i) == 'Y' ){
                countY++;
            }
            if(countP == countY){
                answer = true;
            }else {
                answer = false;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        문자열내p와y의개수 s = new 문자열내p와y의개수();
        System.out.println(s.solution("pPoooyY"));
        System.out.println(s.solution("Pyy"));
    }
}
