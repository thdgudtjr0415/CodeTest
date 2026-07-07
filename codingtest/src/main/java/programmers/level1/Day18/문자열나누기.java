package programmers.level1.Day18;

public class 문자열나누기 {
    public int solution(String s) {
        int result = 0;
        for(int i =  0; i < s.length(); i++) {
            int xCount = 0;
            int dCount = 0;
            char x =  s.charAt(i);
            for(int j = i; j < s.length(); j++) {
                if(s.charAt(j) == x){
                    xCount++;
                }else {
                    dCount++;
                }
                if(xCount == dCount){
                    break;
                }
            }
            result++;
            i += xCount+dCount-1;
        }
        return result;
    }
    public static void main(String[] args){
        문자열나누기 s = new 문자열나누기();
        System.out.println(s.solution("banana")); // 3
        System.out.println(s.solution("abracadabra")); // 6
        System.out.println(s.solution("aaabbaccccabba")); // 3
    }
}
