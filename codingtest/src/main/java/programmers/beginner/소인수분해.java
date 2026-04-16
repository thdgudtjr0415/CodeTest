package programmers.beginner;

import java.util.ArrayList;
import java.util.Arrays;

public class 소인수분해 {
    public int[] solution(int n) {
        // 처음에 크기 모르니까 ArrayList써서 담기
        ArrayList<Integer> list = new ArrayList<>();
        // 여기부분이 중요한데 1은 나눠봤자 의미 없으니 2 부터 시작
        for(int i = 2; i <= n; i++){
            // if로 나눴을때 나머지가 0인것 찾기
            if(n % i == 0) {
                // 찾았으면 그걸로 list에 담기
                list.add(i);
                // 그런데 나누고나서 또 나뉠수도 있으니 while로 계속 나눠보기
                while (n % i == 0) {
                    n /= i;
                }
                // 그래서 나머지가 0이 아니면 다음으로 넘어감
            }
        }
        // 그래서 이제 list의 사이즈가 나왔으니 result의 크기 정해주기
        int[] result = new int[list.size()];
        // 이부분은 list를 result에 담는 과정
        for(int j = 0; j < list.size(); j++){
            result[j] = list.get(j);
        }

        return result;
    }
    public static void main(String[] args) {
        소인수분해 s = new 소인수분해();
        System.out.println(Arrays.toString(s.solution(12))); // 2, 3
        System.out.println(Arrays.toString(s.solution(17))); // 17
        System.out.println(Arrays.toString(s.solution(420))); // 2,3,5,7
    }
}
