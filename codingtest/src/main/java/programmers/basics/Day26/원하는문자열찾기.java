package programmers.basics.Day26;


public class 원하는문자열찾기 {
    public int solution1(String myString, String pat) {
        int result = 0;
        char[] myArr = myString.toCharArray();
        char[] patArr = pat.toCharArray();
        for(int i=0;i<myArr.length;i++){
            if(Character.isUpperCase(myArr[i])) myArr[i] = Character.toLowerCase(myArr[i]);
        }
        for(int i=0;i<patArr.length;i++){
            if(Character.isUpperCase(patArr[i])) patArr[i] = Character.toLowerCase(patArr[i]);
        }
        String myStr = new String(myArr);
        String patStr = new String(patArr);
        if(myStr.contains(patStr)){
            result = 1;
        }
        return result;
    }
    public int solution2(String myString, String pat) {
        // 숏컷
        String myStr = myString.toLowerCase();
        String patStr = pat.toLowerCase();
        return myStr.contains(patStr) ? 1 : 0;
    }
    public static void main(String[] args) {
        원하는문자열찾기 s = new 원하는문자열찾기();
        System.out.println(s.solution1("AbCdEfG", "aBc")); //1
        System.out.println(s.solution1("aaAA", "aaaaa")); //0
        System.out.println(s.solution2("AbCdEfG", "aBc")); //1
        System.out.println(s.solution2("aaAA", "aaaaa")); //0
    }
}
