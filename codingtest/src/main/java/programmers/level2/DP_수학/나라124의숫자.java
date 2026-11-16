package programmers.level2.DP_수학;

// 숫자는 1,2,4 만 사용 가능
// 먼저 들어온 숫자는 몇번째 인건지 알아야함 -> 즉 1자리수 인지 2자리수 인지 3자리수인지
// 개념
// 만약에 int n = 20 이라면
// 3, 9, 27, 81... 이런식으로 되어있으니
// 20 - 3 - 9 = 8 임 -> 이 말은 2번 뺏으니 2자리수 + 1 해서 3자리수의 8번째임
// 0 -> 1, 1 -> 2, 2 -> 4

public class 나라124의숫자 {
    public String solution(int n) {
        String answer = "";
        System.out.println("원래 n : " + n);
        int three = 1; int len = 1; // 자리수(주석 보면 3의 제곱 몇번뺏는지 + 1 해야 진짜 자리수가 나옴)
        while(n > 0){
            three *= 3;
            n -= three;
            len++;
        }
        n += three; three /= 3; len--;  //(정리 한번 해줌) 이때 n은 그 자리수의 몇번째인지를 의미
        System.out.println("자리수 : " + len);
        System.out.println("몇번째 인지 : " + n);
        int num = 1;
        for(int i = 0 ; i < len; i++){
            int finalNum = (n-1) / num % 3;
            num *= 3;
            String temp = "";
            switch (finalNum){
                case 0 : temp = "1"; break;
                case 1 : temp = "2"; break;
                case 2 : temp = "4"; break;
            }
            answer = temp + answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        나라124의숫자 s = new 나라124의숫자();
//        System.out.println(s.solution(1)); // 1
//        System.out.println(s.solution(2)); // 2
//        System.out.println(s.solution(3)); // 4
        System.out.println(s.solution(4)); // 11
        System.out.println(s.solution(11)); // 42
        System.out.println(s.solution(39)); // 444
    }
}

//  1,2,4
//  1 2 3    3개  한자리수

// 11, 12, 14, 21, 22, 24, 41, 42, 44
// 4,  5,  6,  7,  8,  9,  10, 11, 12  -> 4 ~ 12    9개   두자리수
// 1,  2,  3,  4,  5,  6,  7,  8,  9   -> 자리수중 번지수

// 111, 112, 114, 121, 122, 124, 141, 142, 144,
// 13,
// 211, 212, 214, 221, 222, 224, 241, 242, 244,
// 411, 412, 414, 421, 422, 424, 441, 442, 444,   -> 13 ~ 39   27개  3자리수
//                                          39
// 40 ~ 120   81개   4자리수
// 5자리수 -> 243
// 6 ->  729  7 -> 2187  8 -> 6561  9 -> 19683 10 -> 59049 ...

// 만약에 11이 들어온다
// 11 - 3 = 8
// 한번 뺏으니 2자리수의 8번째