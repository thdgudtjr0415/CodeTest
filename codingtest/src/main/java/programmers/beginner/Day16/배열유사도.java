package programmers.beginner.Day16;

public class 배열유사도 {
    public int solution(String[] s1, String[] s2) {
        int result = 0;

        for(int i = 0; i < s1.length; i++){
            for(int j = 0; j < s2.length; j++){
                if(s1[i].equals(s2[j])){
                    result++;
                }
            }
        }

        return result;
    }
    public static void main(String args[]){
        배열유사도 s = new 배열유사도();
        System.out.println(s.solution(new String[]{"a", "b", "c"},
                new String[]{"com", "b", "d", "p", "c"})); // 2
        System.out.println(s.solution(new String[]{"n", "omg"},
                new String[]{"m", "dot"})); // 0
    }
}
