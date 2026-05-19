package programmers.basics.Day11;

public class 글자이어붙여문자열만들기 {
    public String solution(String my_string, int[] index_list) {
        String result = "";

        for(int i=0;i<index_list.length;i++) {
            result += my_string.charAt(index_list[i])+"";
        }

        return result;
    }
    public static void main(String[] args){
        글자이어붙여문자열만들기 s = new 글자이어붙여문자열만들기();
        System.out.println(
                s.solution(new String("cvsgiorszzzmrpaqpe"),
                           new int[]{16,6,5,3,12,14,11,11,17,12,7})); // programmers
        System.out.println(
                s.solution(new String("zpiaz"),
                           new int[]{1,2,0,0,3})); // pizza
    }
}
