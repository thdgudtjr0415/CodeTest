package programmers.basics.Day28;

public class 문자열이몇번등장하는지세기 {
    public int solution1(String myString, String pat) {
        int result = 0;
        int len = myString.length() - pat.length() + 1;
        String[] myStrings = new String[len];
        for(int i=0;i<len;i++){
            myStrings[i] = myString.substring(i,i + pat.length());
        }
        for(int j = 0; j < myStrings.length; j++){
            if(myStrings[j].equals(pat)){
                result++;
            }
        }
        return result;
    }
    public int solution2(String myString, String pat) {
        int result = 0;
        int len = myString.length() - pat.length() + 1;
        for(int i=0;i<len;i++){
            String words = myString.substring(i,i + pat.length());
            if(words.equals(pat)){
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        문자열이몇번등장하는지세기 s = new 문자열이몇번등장하는지세기();
        System.out.println(s.solution1("banana","ana"));
        System.out.println(s.solution1("aaaa","aa"));
        System.out.println(s.solution2("banana","ana"));
        System.out.println(s.solution2("aaaa","aa"));
    }
}
