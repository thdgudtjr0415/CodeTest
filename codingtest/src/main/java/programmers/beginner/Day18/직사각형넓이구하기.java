package programmers.beginner.Day18;

//꼭짓점의 좌표 [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]

public class 직사각형넓이구하기 {
    public int solution(int[][] dots) {
        int result = 0;
        // 직접 하나하나 설정해보기
        int maxX = dots[0][0];
        int minX = dots[0][0];
        int maxY = dots[0][1];
        int minY = dots[0][1];

        for(int i = 0; i < dots.length; i++) {
            maxX = Math.max(maxX, dots[i][0]);
            minX = Math.min(minX, dots[i][0]);
            maxY = Math.max(maxY, dots[i][1]);
            minY = Math.min(minY, dots[i][1]);
        }

        result = Math.abs(maxX - minX) * Math.abs(maxY - minY);

        return result;
    }
    public static void main(String[] args) {
        직사각형넓이구하기 s = new 직사각형넓이구하기();
        System.out.println(s.solution(
                new int[][]{{1, 1}, {2, 1}, {2, 2}, {1, 2}})); // 1
        System.out.println(s.solution(
                new int[][]{{-1, -1}, {1, 1}, {1, -1}, {-1, 1}})); // 4
    }
}
