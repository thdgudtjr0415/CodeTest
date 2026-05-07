package programmers.basics.Day02;

import java.util.Scanner;

public class 홀작구분하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n%2==0){
            System.out.println(n + " is even");
        }else {
            System.out.println(n + " is odd");
        }
    }
}
