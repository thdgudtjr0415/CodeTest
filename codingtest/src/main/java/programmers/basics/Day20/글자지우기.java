package programmers.basics.Day20;


public class 글자지우기 {
    public String solution(String my_string, int[] indices) {
        String result = "";
        String[] words = my_string.split("");
        for(int i = 0; i < indices.length; i++){
            int index = indices[i];
            words[index] = "";
        }
        result = String.join("", words);
        return result;
    }
    public static void main(String[] args) {
        글자지우기 s = new 글자지우기();
        System.out.println(s.solution("apporoograpemmemprs",
                new int[]{1, 16, 6, 15, 0, 10, 11, 3})); // programmers
    }
}