package programmers.level2;

//U: 위쪽으로 한 칸 가기
//D: 아래쪽으로 한 칸 가기
//R: 오른쪽으로 한 칸 가기
//L: 왼쪽으로 한 칸 가기
// 좌표는 -5 ~ 5
// 문제 풀이 HashSet
// 배열이 필요 없어짐, 왜냐하면 Hashset이 관리할 예정이기 때문 좌표만 보면됨

import java.util.HashSet;

public class 방문길이_HashSet {
    public int solution1(String dirs) {
        HashSet<String> set = new HashSet<String>();
        int[] curr = {0,0};
        int len = dirs.length();

        for(int i=0;i<len;i++){
            char c = dirs.charAt(i);
            int dr = 0, dc = 0;
            switch(c){
                case 'U' -> dr = 1;
                case 'D' -> dr = -1;
                case 'R' -> dc = 1;
                case 'L' -> dc = -1;
            }

            int tr = curr[0] + dr;
            int tc = curr[1] + dc;

            if(tr >= -5 && tr <= 5 && tc >= -5 && tc <= 5){
                set.add(curr[0] + "," + curr[1] + "-" + tr + "," + tc);
                set.add(tr + "," + tc + "-" + curr[0] + "," + curr[1]);
                curr[0] = tr;
                curr[1] = tc;
            }
        }
        int answer = 0;
        answer = set.size()/2;
        return answer;
    }

    // ===== 코드 리뷰 (고칠 것) =====
    // 1. int answer = 0; answer = set.size()/2;  ->  int answer = set.size() / 2; 한 줄로
    // 2. 구분자 "-"는 음수 부호와 모양이 같아서 "0,0--1,0"처럼 읽기 어렵다 -> "|" 같은 다른 구분자로
    //    (지금은 좌표가 한 자리 숫자라 서로 다른 선이 같은 문자열이 되는 일은 없지만, 좌표가 커지면 위험)
    // 3. main의 assert에 직접 만든 케이스 추가
    //    assert s.solution("UDUDUD") == 1;   // 왕복은 선 1개
    //    assert s.solution("URDL") == 4;     // 사각형 한 바퀴

    public int solution2(String dirs) {
        HashSet<String> set = new HashSet<String>();
        int[] curr = {0,0};
        int len = dirs.length();

        for(int i=0;i<len;i++){
            char c = dirs.charAt(i);
            int dr = 0, dc = 0;
            switch(c){
                case 'U' -> dr = 1;
                case 'D' -> dr = -1;
                case 'R' -> dc = 1;
                case 'L' -> dc = -1;
            }

            int tr = curr[0] + dr;
            int tc = curr[1] + dc;

            if(tr >= -5 && tr <= 5 && tc >= -5 && tc <= 5){
                set.add(curr[0] + "," + curr[1] + " ~ " + tr + "," + tc);
                set.add(tr + "," + tc + " ~ " + curr[0] + "," + curr[1]);
                curr[0] = tr;
                curr[1] = tc;
            }
        }
        return set.size()/2;
    }

    public static void main(String[] args){
        방문길이_HashSet s = new 방문길이_HashSet();
//        int r1 = s.solution1("ULURRDLLU");
//        assert r1 == 7 : "결과 = " + r1;
//        int r2 = s.solution1("LULLLLLLU");
//        assert r2 == 7 : "결과 = " + r2;
//        assert s.solution1("UDUDUD") == 1;   // 왕복은 선 1개
//        assert s.solution1("URDL") == 4;     // 사각형 한 바퀴
//        System.out.println(s.solution1("ULURRDLLU")); // 7
//        System.out.println(s.solution1("LULLLLLLU")); // 7

        int r3 = s.solution2("ULURRDLLU");
        assert r3 == 7 : "결과 = " + r3;
        int r4 = s.solution2("LULLLLLLU");
        assert r4 == 7 : "결과 = " + r4;

        assert s.solution2("UDUDUD") == 1;   // 왕복은 선 1개
        assert s.solution2("URDL") == 4;     // 사각형 한 바퀴
    }
}
