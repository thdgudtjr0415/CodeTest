package programmers.basics.Day01;

import java.util.Scanner;

public class 문자열반복해서출력하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.print(str);
        }
        // 혹은 다른 풀이로
        System.out.println();
        // "문자열".repeat(반복할_횟수)
        System.out.println(str.repeat(n));
    }
}
