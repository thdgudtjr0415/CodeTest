package programmers.beginner.Day9;

/*
 * 개미 군단 - 최소 병력으로 hp 처치
 * 장군개미: 5, 병정개미: 3, 일개미: 1
 * hp를 5 → 3 → 1 순으로 나눠서 최소 마릿수 구하기
 * count를 올리면서 작업하면 될듯?
 */

public class 개미군단 {
    public int solution(int hp) {
        int result = 0;
        int general = hp/5;
        int general1 = hp%5;
        int soldier = general1/3;
        int worker = general1%3;
        result = general + soldier + worker;
        return result;

    }

    // 입출력 하는 곳
    public static void main(String[] args) {
        개미군단 p = new 개미군단();
        System.out.println(p.solution(23));
        System.out.println(p.solution(24));
        System.out.println(p.solution(999));
    }
}
