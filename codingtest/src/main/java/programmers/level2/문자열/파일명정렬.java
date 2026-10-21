package programmers.level2.문자열;

import java.util.Arrays;

// 정렬 조건
// HEAD, NUMBER, TAIL 이라는 구분으로 파일명이 있음
// HEAD 는 처음 숫자가 나오기 전까지의 문자열
// NUMBER 는 다음 문자열이 나오기 전까지의 숫자 (0으로 시작 가능)
// TAIL은 나머지 문자열
// 1. 먼저 HEAD를 기준으로 사전순으로 정렬 대소문자 구분X
// 2. 그 다음으로 NUMBER로 정렬
// 3. 모두 같다면 입력 순서로 들어옴

// compareTo
//"A".compareTo("B")  음수: A가 B보다 앞이다
//"B".compareTo("B")  0   : 둘이 같다
//"C".compareTo("B")  양수: C가 B보다 뒤다

public class 파일명정렬 {
    public String[] solution(String[] files) {
        Arrays.sort(files, (a, b) -> {
            String[] x = headNumberTail(a);
            String[] y = headNumberTail(b);
            // HEAD → NUMBER 순으로 비교, 둘 다 같으면 0 (Arrays.sort는 안정 정렬이라 입력 순서 유지)
            int headCompare = x[0].compareTo(y[0]);
            if (headCompare != 0) return headCompare; // HEAD가 다르면 그 결과를 바로 반환
            // parseInt가 앞의 0을 없애줘서 "012"와 "12"가 같은 값(12)이 된다
            return Integer.compare(Integer.parseInt(x[1]), Integer.parseInt(y[1]));
        });

        return files;
    }

    // 파일명을 {HEAD, NUMBER, TAIL}로 자른다 (비교용이라 대문자로 통일해서 대소문자를 무시한다)
    private String[] headNumberTail(String file){
        file = file.toUpperCase(); // HEAD를 대소문자 구분 없이 비교하려고 통일 (원본 files는 그대로)
        int i = 0;
        while(i < file.length() && !Character.isDigit(file.charAt(i))) i++;
        int j = i;
        while(j < file.length() && Character.isDigit(file.charAt(j))) j++;
        return new String[]{file.substring(0, i), file.substring(i, j), file.substring(j)};
    }
    public static void main(String[] args){
        파일명정렬 s = new 파일명정렬();
        //["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]
        System.out.println(Arrays.toString(s.solution(
                new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
        //["A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"]
        System.out.println(Arrays.toString(s.solution(
                new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
    }
}
