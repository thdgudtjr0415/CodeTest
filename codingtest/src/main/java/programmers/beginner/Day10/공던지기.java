package programmers.beginner.Day10;

// 머쓱이는 친구들과 동그랗게 서서 공 던지기 게임을 하고 있습니다.
// 공은 1번부터 던지며 오른쪽으로 한 명을 건너뛰고 그다음 사람에게만 던질 수 있습니다.
// 친구들의 번호가 들어있는 정수 배열 numbers와 정수 K가 주어질 때,
// k번째로 공을 던지는 사람의 번호는 무엇인지 return 하도록 solution 함수를 완성해보세요.

// 2 < numbers의 길이 < 100
// 0 < k < 1,000
// numbers의 첫 번째와 마지막 번호는 실제로 바로 옆에 있습니다.
// numbers는 1부터 시작하며 번호는 순서대로 올라갑니다.

public class 공던지기 {
    public int solution(int[] numbers, int k) {
        // 이건 간단하게 %로 나머지 구할 수있고
        // 굳이 배열 늘려서 안만들어도 됨
        // 그래서 결국 (i-1)*2랑 같은 내용이니 여기에 주어진 k 만 넣으면 끝
        int result = numbers[((k-1)*2)%numbers.length];;


        return result;
        }

    public static void main(String[] args) {
        공던지기 s = new 공던지기();
        System.out.println(s.solution(new int[]{1, 2, 3, 4}, 2)); // result 3
        System.out.println(s.solution(new int[]{1, 2, 3, 4, 5, 6}, 5)); // 3
        System.out.println(s.solution(new int[]{1, 2, 3}, 3));  // 2
    }
}
