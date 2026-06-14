package programmers.basics.Day34;

public class 꼬리문자열 {
    public String solution(String[] str_list, String ex) {
        String result = "";
        for(int i = 0; i < str_list.length; i++){
            if(!str_list[i].contains(ex)){
                result += str_list[i]+"";
            }
        }
        return result;
    }
    public static void main(String[] args){
        꼬리문자열 s = new 꼬리문자열();
        System.out.println(s.solution(new String[]{"abc","def","ghi"},"ef")); //"abcghi"
        System.out.println(s.solution(new String[]{"abc", "bbc", "cbc"},"c")); //""
    }
}
