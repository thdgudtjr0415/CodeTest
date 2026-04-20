package programmers.beginner.Day15;

// 영어가 싫은 머쓱이는 영어로 표기되어있는 숫자를 수로 바꾸려고 합니다.
// 문자열 numbers가 매개변수로 주어질 때,
// numbers를 정수로 바꿔 return 하도록 solution 함수를 완성해 주세요.
// 제한사항
// numbers는 소문자로만 구성되어 있습니다.
// numbers는 "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" 들이 공백 없이 조합되어 있습니다.
// 1 ≤ numbers의 길이 ≤ 50
// "zero"는 numbers의 맨 앞에 올 수 없습니다.

// 풀이법
// 영어 단어를 숫자로 교체 replace
//numbers = numbers.replace("zero", "0");
//numbers = numbers.replace("one",  "1");
//numbers = numbers.replace("two",  "2");
public class 영어가싫어요 {
    public long solution(String numbers) {
        // 0~9까지
        long result = 0;
        // 혹시 모르니까 원본 복사해서 사용하기
        String num = numbers;
        String[] word = {"zero","one","two","three","four",
                "five","six","seven","eight","nine"};

        // replace 사용할때는 변수 = 변수.replace 이렇게 사용해야함 같은 변수를 써야함
        for (int i = 0; i < word.length; i++){
            num = num.replace(word[i], String.valueOf(i));
        }
        result = Long.parseLong(num);

        return result;
    }
    public static void main(String[] args) {
        영어가싫어요 s = new 영어가싫어요();
        System.out.println(s.solution("onetwothreefourfivesixseveneightnine")); // 123456789
        System.out.println(s.solution("onefourzerosixseven")); // 14067

    }
}
