package programmers.basics.Day33;

import java.math.BigInteger;

public class 두수의합 {
    public String solution1(String a, String b) {
        String result = "";
        BigInteger aBig = new BigInteger(a);
        BigInteger bBig = new BigInteger(b);
        result = aBig.add(bBig).toString();
        return result;
    }
    public String solution2(String a, String b) {
        String result = "";
        int aIdx = a.length()-1;
        int bIdx = b.length()-1;
        int up = 0;
        while(aIdx >= 0 || bIdx >= 0 || up > 0){
            int aNum = 0;
            int bNum = 0;
            if(aIdx >= 0) aNum = a.charAt(aIdx)-'0';
            if(bIdx >= 0) bNum = b.charAt(bIdx)-'0';
            int sum = aNum+bNum+up;
            result = (sum%10)+result;
            up = sum/10;
            aIdx--;
            bIdx--;
        }
        return result;
    }
    public static void main(String[] args) {
        두수의합 s = new 두수의합();
        System.out.println(s.solution1("582", "734")); //1316
        System.out.println(s.solution1("18446744073709551615", "287346502836570928366")); //305793246910280479981
        System.out.println(s.solution1("0", "0")); // 0
        System.out.println(s.solution2("582", "734")); //1316
        System.out.println(s.solution2("18446744073709551615", "287346502836570928366")); //305793246910280479981
        System.out.println(s.solution2("0", "0")); // 0
    }
}
