package programmers.level2.DP_수학;

// 버튼: -1, +1, -10, +10, -100, +100 ... (절댓값이 10의 거듭제곱)
// 아이디어: 일의 자리부터 한 자리씩 0으로 만든다.
//   - 일의 자리가 5보다 크면 올려서(+) 0 만들기가 더 적게 든다. (올리면 윗자리가 1 커진다)
//   - 5보다 작으면 내려서(-) 0 만들기가 더 적게 든다.
//   - 정확히 5이면 올려도 내려도 5번이라, 다음(십의) 자리를 보고 정한다.
class 마법의엘리베이터 {
    public int solution1(int storey) {
        int answer = 0; // 누른 버튼 횟수(마법의 돌 개수)

        while (storey != 0) {
            int oneNum = storey % 10; // 현재 일의 자리
            int afterSum;         // 일의 자리를 0으로 만들기 위해 더할 값 (+면 올림, -면 내림), = 0; 안해도 됨

            if (oneNum > 5) {
                afterSum = 10 - oneNum; // 올리기: 예) 6 -> +4
            } else if (oneNum < 5) {
                afterSum = -oneNum;     // 내리기: 예) 4 -> -4
            } else {
                // 일의 자리가 5일 때: 십의 자리를 본다
                int tenNum = storey % 100 / 10;
                if (tenNum >= 5) {
                    afterSum = 5;  // 십의 자리가 크면 올리는 게 이득(또는 같음)
                } else {
                    afterSum = -5; // 십의 자리가 작으면 내리는 게 이득
                }
            }

            storey = (storey + afterSum) / 10; // 일의 자리를 0으로 만든 뒤, 한 자리 줄이기 (올림이면 윗자리에 반영됨)
            answer += Math.abs(afterSum);      // 누른 횟수는 항상 양수로 더하기
        }
        return answer;
    }

    public int solution2(int storey) {
        int answer = 0; // 누른 버튼 횟수(마법의 돌 개수)

        while (storey != 0) {
            int oneNum = storey % 10; // 현재 일의 자리
            int tenNum = storey % 100 / 10; // 현재 십의 자리
            int afterSum;         // 일의 자리를 0으로 만들기 위해 더할 값 (+면 올림, -면 내림), = 0; 안해도 됨

            if (oneNum > 5 || (oneNum == 5 && tenNum >= 5)) {
                afterSum = 10 - oneNum; // 올리기
            } else {
                afterSum = -oneNum;     // 내리기
            }

            storey = (storey + afterSum) / 10; // 일의 자리를 0으로 만든 뒤, 한 자리 줄이기 (올림이면 윗자리에 반영됨)
            answer += Math.abs(afterSum);      // 누른 횟수는 항상 양수로 더하기
        }
        return answer;
    }

    public static void main(String[] args) {
        마법의엘리베이터 s = new 마법의엘리베이터();
        System.out.println(s.solution2(16));   // 6
        System.out.println(s.solution2(2554)); // 16
    }
}
