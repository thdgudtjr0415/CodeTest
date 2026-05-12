package programmers.basics.Day06;

// 1. 반복문의 조건으로 풀기
// 2. hashSet으로 풀어보기

import java.util.HashSet;
import java.util.Set;

public class 주사위게임_02 {
    // 1. 반복문
    public int solution1(int a, int b, int c) {
        int result = 0;
        int sum1 = a+b+c;
        int sum2 = a*a+b*b+c*c;
        int sum3 = a*a*a+b*b*b+c*c*c;
        if(a == b && a == c){
            result = sum1*sum2*sum3;
        }else if(a==b||a==c||b==c){
            result = sum1*sum2;
        }else{
            result = sum1;
        }
        return result;
    }
    // 2. hashSet
    public int solution2(int a, int b, int c) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        set.add(a);
        set.add(b);
        set.add(c);
        int sum1 = a+b+c;
        int sum2 = a*a+b*b+c*c;
        int sum3 = a*a*a+b*b*b+c*c*c;

        // 여기서 size라 함은 주소가 같은 것들이 들어가면 하나로 합쳐짐 즉 수가 같으면 주소 하나로
        // 그렇게 됐을때 size가 1이면 모두 같은것 2면 2개만 같은것, 3이면 모두 같은것
        int size = set.size();
        if(size == 1){
            result = sum1*sum2*sum3;
        }else if(size == 2){
            result = sum1*sum2;
        }else {
            result = sum1;
        }

        return result;
    }
    public static void main(String[] args){
        주사위게임_02 s = new 주사위게임_02();
        System.out.println(s.solution1(2,6,1)); // 9
        System.out.println(s.solution1(5,3,3)); // 473
        System.out.println(s.solution1(4,4,4)); // 110592

        System.out.println(s.solution2(2,6,1)); // 9
        System.out.println(s.solution2(5,3,3)); // 473
        System.out.println(s.solution2(4,4,4)); // 110592
    }
}
