package programmers.basics.Day29;

import java.util.Arrays;

public class 문자열잘라서정렬하기 {
    public String[] solution(String myString) {
        String[] arr = myString.split("x");
        Arrays.sort(arr);
        int count = 0;
        for(int i = 0; i < arr.length; i++) if(!arr[i].isEmpty()) count++;
        String[] result = new String[count];
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            if(!arr[i].isEmpty()) result[index++] = arr[i];
        }
        return result;
    }
    public static void main(String[] args) {
        문자열잘라서정렬하기 s = new 문자열잘라서정렬하기();
        System.out.println(Arrays.toString(s.solution("axbxcxdx"))); //a,b,c,d
        System.out.println(Arrays.toString(s.solution("dxccxbbbxaaaa")));//aaaa,bbb,cc,d
        // 반례사례들 때문에 통과 안되서 한번 해보기
        // =========================================================================
        // 🚨 [추가 예시 1] 'x'가 연속으로 등장할 때 (중간에 빈 문자열 찌꺼기 생성)
        // 원래 기대하는 정답: ["a", "b"]
        // 네 코드의 실제 출력: ["", "a", "b"] ➡️ 💥 빈 문자열 ""이 정렬되어 맨 앞에 담김!
        System.out.println("예외 1 (연속 x): " + Arrays.toString(s.solution("axxb")));

        // 🚨 [추가 예시 2] 문자열의 맨 앞이 'x'로 시작할 때 (맨 앞에 빈 문자열 찌꺼기 생성)
        // 원래 기대하는 정답: ["a", "b"]
        // 네 코드의 실제 출력: ["", "a", "b"] ➡️ 💥 맨 앞의 x 때문에 ""이 생성되어 포함됨!
        System.out.println("예외 2 (시작 x): " + Arrays.toString(s.solution("xaxb")));

        // 🚨 [추가 예시 3] 문자열 전체가 'x'로만 이루어져 있을 때
        // 원래 기대하는 정답: [] (단, 빈 문자열은 반환할 배열에 넣지 않습니다 규칙)
        // 네 코드의 실제 출력: [] 처럼 보이지만 자바 기본 split은 맨 뒤 공백을 자동 삭제해서
        // 운 좋게 빈 배열이 나올 순 있으나, 앞/중간 예외와 결합되면 무조건 터짐!
        System.out.println("예외 3 (올 x): " + Arrays.toString(s.solution("xxxx")));
    }
}
