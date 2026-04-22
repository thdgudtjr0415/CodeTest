package programmers.beginner.Day17;

import java.util.Arrays;

public class 잘라서배열로저장하기 {
    public String[] solution(String my_str, int n) {
        // 꿀팁 공식
        // int size = (my_str.length() + n - 1) / n; -> 이거 올림 공식
        // 이유는 (16 + 6 - 1) / 6 이렇게 되면
        // 원래는 2.~~ 이렇게 나와야하는데 올림 하려고 6-1만큼만 해줘서 3만들어주려고
        // 그리고 substring 을 쓰면 시작 인덱스 부터 end 인덱스(주의할 점은 end 전까지만 포함)까지 지정 가능
        int size = (my_str.length() + (n-1))/n;
        String[] result = new String[size];

        // Math.min 쓴 이유
        // 이미 벌써 6으로 했을때 저게 범위 초과가 될 수있으니 min을 사용해서
        // Math.min((i * n) + n, my_str.length())
        // 이렇게 하면 (i * n) + n or my_str.length()를 비교해서 작은수 선택할꺼니까
        for(int i = 0; i < result.length; i++) {
            result[i] = my_str.substring(i*n, Math.min((i * n) + n, my_str.length()));
        }

        return result;
    }
    public static void main(String args[]){
        잘라서배열로저장하기 s = new 잘라서배열로저장하기();
        System.out.println(Arrays.toString(
                s.solution("abc1Addfggg4556b", 6))); //["abc1Ad", "dfggg4", "556b"]
        System.out.println(Arrays.toString(
                s.solution("abcdef123", 3))); //["abc", "def", "123"]
    }
}
