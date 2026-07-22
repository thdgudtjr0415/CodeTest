package programmers.level1.Day31;

import java.util.Arrays;

//드래그는 바탕화면의 격자점 S(lux, luy)를 마우스 왼쪽 버튼으로 클릭한 상태로 격자점 E(rdx, rdy)로 이동
//"점 S에서 점 E로 드래그한다"고 표현
//점 S(lux, luy)에서 점 E(rdx, rdy)로 드래그를 할 때, "드래그 한 거리"는 |rdx - lux| + |rdy - luy|
//시작점S(lux, luy) = 가장 위쪽, 가장 왼쪽
//끝점E(rdx, rdy)   = 가장 아래쪽 +1, 가장 오른쪽 +1

public class 바탕화면정리 {
    public int[] solution(String[] wallpaper) {
        // 여기서  Integer.MAX_VALUE 이거 넣는 이유는 처음에 최솟값 들어올때 편하게 삽입하려고 최댓값넣는거임
        int lux = Integer.MAX_VALUE; int luy = Integer.MAX_VALUE; int rdx = 0; int rdy = 0;
        for(int i = 0; i < wallpaper.length; i++) {
            for(int j = 0; j < wallpaper[i].length(); j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    if(i < lux) lux = i;
                    if(j < luy) luy = j;
                    if(i > rdx) rdx = i;
                    if(j > rdy) rdy = j;
                }
            }
        }
        return new int[]{lux, luy, rdx+1, rdy+1};
    }

    public static void main(String[] args) {
        바탕화면정리 s = new 바탕화면정리();
        System.out.println(Arrays.toString(s.solution(
                new String[]{
                        ".#...",
                        "..#..",
                        "...#."}))); //0,1,3,4
        System.out.println(Arrays.toString(s.solution(
                new String[]{
                        "..........",
                        ".....#....",
                        "......##..",
                        "...##.....",
                        "....#....."}))); //1,3,5,8
        System.out.println(Arrays.toString(s.solution(
                new String[]{
                        ".##...##.",
                        "#..#.#..#",
                        "#...#...#",
                        ".#.....#.",
                        "..#...#..",
                        "...#.#...",
                        "....#...."}))); //0,0,7,9
        System.out.println(Arrays.toString(s.solution(
                new String[]{
                        "..",
                        "#."}))); //1,0,2,1
    }
}
