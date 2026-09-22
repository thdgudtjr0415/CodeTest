package programmers.level2;

// 알파벳 모음 A, E, I, O, U만 사용하여 만들수 있는 길이 5 이하의 모든 단어
// 첫 단어 A, 다음 AA 마지막 단어는 UUUUU
// 지금 반복 2개 밖에 없음
// 1. temp.length()가 0이 아닌이상 카운트는 1 늘어남 즉 단어가 도착하면 idx는 ++ 됨
// 2. 다섯갈래로 되어있음(지금 길이는 5까지니까)
//  AAAA에 도착하면 A,E,I,O,U를 하나씩 하고

//dfs("")
//  dfs("A")        → idx=1
//    dfs("AA")     → idx=2
//      dfs("AAA")  → idx=3
//        dfs("AAAA")     → idx=4
//          dfs("AAAAA")  → idx=5   (길이 5, 더 못 붙임, return)
//          dfs("AAAAE")  → idx=6   (길이 5, return)
//          dfs("AAAAI")  → idx=7
//          dfs("AAAAO")  → idx=8
//          dfs("AAAAU")  → idx=9
//        dfs("AAAE")     → idx=10
//

public class 모음사전 {
    int index = 0; // 사전 인덱스
    public int solution(String word) {
        char[] arr = {'A', 'E', 'I', 'O', 'U'}; // 모음 배열
        String temp = ""; // 이제 단어 채워갈 temp 공간

        dfs(temp, arr, word); // 완전탐색 dfs

        return index;
    }

    private void dfs(String temp, char[] arr, String word) {


    }


    public static void main(String[] args) {
        모음사전 s = new 모음사전();
//        int r1 = s.solution("AAAAE");
//        assert r1 == 6 : "결과 = " + r1;
        System.out.println(s.solution("AAAAE")); //6
//        System.out.println(s.solution("AAAE")); //10
//        System.out.println(s.solution("I")); //1563
//        System.out.println(s.solution("EIO")); //1189
    }
}
