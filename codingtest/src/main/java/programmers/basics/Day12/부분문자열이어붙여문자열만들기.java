package programmers.basics.Day12;

public class 부분문자열이어붙여문자열만들기 {
    public String solution(String[] my_strings, int[][] parts) {
        String result = "";
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < parts.length; i++){
            String temp = my_strings[i];
            int index1 = parts[i][0];
            int index2 = parts[i][1];
            sb.append(temp.substring(index1, index2+1));
        }
        result = sb.toString();
        return result;
    }
    public static void main(String[] args){
        부분문자열이어붙여문자열만들기 s = new 부분문자열이어붙여문자열만들기();
        System.out.println(s.solution(
                new String[]{"progressive", "hamburger", "hammer", "ahocorasick"},
                new int[][]{{0,4},{1,2},{3,5},{7,7}}));
    }
}
