package programmers.beginner.Day22;

// 이때 여기서
// 2진수 전용 메서드 Integer.toBinaryString(number);
// 이건 숫자를 2진수로 바꿔주는 것
// Integer.toString(number, 진법)
// 이건 보면 알겠지만 숫자가 들어오면 다음의 진법의 숫자로 변환해줌

// 다만 쓸때 무슨 진법이 들어올지 모른다면 Integer.toString(number, 진법) 이걸 쓰는게 좋고
// 정해져 있는 진법이라면 toBinaryString(2진법), toOctalString(8진법), toHexString(16진법) 을 쓰는게 좋음

public class 이진수더하기 {
    public String solution1(String bin1, String bin2) {
        String result = "";

        // Integer.parseInt(문자열, 진법);
        int binary1 = Integer.parseInt(bin1, 2);
        int binary2 = Integer.parseInt(bin2, 2);

        int num = binary1 + binary2;

        result = Integer.toBinaryString(num);

        return result;
    }
    public String solution2(String bin1, String bin2) {
        StringBuilder sb = new StringBuilder();
        // 일의 자리부터 계산해서 나중에 reverse로 뒤집어 주기 하려고
        int i = bin1.length() - 1;
        int j = bin2.length() - 1;

        // 받아올림(Carry)을 기억할 변수
        int carry = 0;
        // while문 조건 잘 보기
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry; // 이번 자리의 덧셈은 이전 자리에서 넘어온 받아올림

            // bin1에 아직 읽을 숫자가 남아있다면 더하기
            if (i >= 0) {
                // 숫자로 만들려고 '0' 을 뺌
                sum += bin1.charAt(i) - '0';
                i--; // 앞으로 한 칸 이동
            }

            // bin2에 아직 읽을 숫자가 남아있다면 더하기
            if (j >= 0) {
                sum += bin2.charAt(j) - '0';
                j--; // 앞으로 한 칸 이동
            }

            // 이진수 덧셈의 핵심 논리
            // 더한 값이 0, 1, 2, 3 중 하나가 나옵니다.
            sb.append(sum % 2); // 2로 나눈 나머지가 현재 자리에 남을 진짜 값
            carry = sum / 2;    // 2로 나눈 몫이 다음 자리로 넘어갈 받아올림 값
        }

        // 5. 맨 뒤(일의 자리)부터 더해서 쌓았으므로, 거꾸로 뒤집어서 반환!
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        이진수더하기 s = new 이진수더하기();
        System.out.println(s.solution1("10", "11")); // 101
        System.out.println(s.solution1("1001", "1111")); // 11000
        System.out.println(s.solution2("10", "11")); // 101
        System.out.println(s.solution2("1001", "1111")); // 11000

    }
}
