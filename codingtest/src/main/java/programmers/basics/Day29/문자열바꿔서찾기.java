package programmers.basics.Day29;

public class 문자열바꿔서찾기 {
    public int solution(String myString, String pat) {
        String youString = myString.replace("A","+").replace("B","A").replace("+", "B");
        int result = 0;
        if(youString.contains(pat)) result = 1;
        return result;
    }
    public static void main(String[] args) {
        문자열바꿔서찾기 s = new 문자열바꿔서찾기();
        System.out.println(s.solution("ABBAA", "AABB"));
        System.out.println(s.solution("ABAB", "ABAB"));
    }
}
