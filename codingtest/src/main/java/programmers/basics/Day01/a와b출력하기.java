package programmers.basics.Day01;

import java.util.Scanner;

public class a와b출력하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 다음줄로 보내는 \n는 무조건 "" 이거 같이 써서 "\n" 이렇게 해주도록 하자
        System.out.println("a = "+ a + "\n" + "b = " + b);
    }
}
