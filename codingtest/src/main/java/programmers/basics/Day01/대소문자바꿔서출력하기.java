package programmers.basics.Day01;

import java.util.Scanner;

public class 대소문자바꿔서출력하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String z = "";

        for(int i = 0; i < a.length(); i++){
            char c =  a.charAt(i);
            // 대문자인지 소문자인지 판별하는것 isLowerCase(), isUpperCase()
            if(Character.isUpperCase(c)){
                z += Character.toLowerCase(c);
            }else {
                z += Character.toUpperCase(c);
            }
        }
        System.out.println(z);
    }
}
