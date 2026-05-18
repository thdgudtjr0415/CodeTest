package programmers.basics.Day10;

import java.util.HashSet;

/*
* 여기선 2가지 방식으로 풀어봅시다
* 1. 기본 반복문
* 2. HashSet<> -> 이건 주소값들이 들어가니 size가 1이면 모두 같은것
* */
public class 주사위게임_03 {
    public int solution(int a, int b, int c, int d) {
        int result = 0;
        HashSet<Integer> set = new HashSet<>();
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);
        int[] count = new int[7]; // 0은 생략하고 인덱스 1~ 6까지만 쓸 생각
        int[] dice = {a, b, c, d};

        // dice배열에 맞게 count 방들을 ++ 해서 올림 그럼 이제 count배열에 있는수는 중복수
//        for(int num : dice){
//            count[num]++;
//        }
        for(int i = 0; i < dice.length; i++){
            int num = dice[i];
            count[num]++;
        }

        // 여기서 부터 조건문
        // 모두 다를때
        if(set.size() == 4){
            result = Math.min(Math.min(a,b),Math.min(c,d));
        }
        // 모두 같을때
        if(set.size() == 1){
            result = 1111*a;
        }
        // 3개가 같을때
        if(set.size() == 2){
            int p1 = 0, q1 = 0;
            // 여기서
            boolean isThreeOne = false;
            for(int i = 0; i < count.length; i++){
                if(count[i] == 3){
                    p1 = i;
                    isThreeOne = true;
                }else if(count[i] == 1){
                    q1 = i;
                }
            }
            if(isThreeOne){
                result = (int) Math.pow((10*p1+q1),2);
            }else {
                int p2 =  0, q2 = 0;
                for(int i = 0; i < count.length; i++){
                    if(count[i] == 2){
                        if(p2 == 0){
                            p2 = i;
//                        }else if(q2 == 0){ 이렇게 하거나 아래처럼
                        }else {
                            q2 = i;
                        }
                    }
                }
                result = (p2+q2) * Math.abs(p2-q2);
            }
        }

        if(set.size() == 3){
            int q3 = 0, r = 0; // 혼자 나온 애들 담을 바구니 두 개
            for(int i = 0; i < count.length; i++){
                // 빈도수가 딱 1인 놈(혼자 나온 주사위 눈)을 찾으면!
                if(count[i] == 1){
                    if(q3 == 0) q3 = i; // 첫 번째 바구니 비었으면 q3에 담고
                    else r = i;         // 이미 차 있으면 r에 담기!
                }
            }
            result = q3 * r; // 혼자 나온 두 수의 곱 구하기
        }

        return result;
    }
    public static void main(String[] args) {
        주사위게임_03 s = new 주사위게임_03();
        System.out.println(s.solution(2, 2, 2, 2)); // 2222
        System.out.println(s.solution(4, 1, 4, 4)); // 1681
        System.out.println(s.solution(6, 3, 3, 6)); // 27
        System.out.println(s.solution(2, 5, 2, 6)); // 30
        System.out.println(s.solution(6, 4, 2, 5)); // 2

    }
}
