package programmers.beginner.Day20;


public class 평행 {
    public int solution(int[][] dots) {
        int result = 0;
        // 쉽게 생각하면 3개의 세트만 남음
        // 인덱스 0,1 하면 나머지 2,3 남고
        // 인덱스 0,2 하면 나머지 1,3
        // 익덱스 0,3 하면 나머지 1,2
        // 이렇게 3개의 세트만 비교하면 될듯 이런건 직접하는게 편할 수 잇음
        if(slope(dots[0],dots[1]) == slope(dots[2],dots[3]))return 1;
        if(slope(dots[0],dots[2]) == slope(dots[1],dots[3]))return 1;
        if(slope(dots[0],dots[3]) == slope(dots[1],dots[2]))return 1;
        return result;
    }

    // 새로운 메서드를 사용해서 기울기를 구해보자 여기서 주의점은 double 데이터 타입 잘 지켜주기
    public static double slope(int[] dot1, int[] dot2) {
        return (double)(dot2[1] - dot1[1]) / (dot2[0] - dot1[0]);
    }

    public static void main(String[] args) {
        평행 s = new 평행();
        System.out.println(s.solution(new int[][]{{1, 4}, {9, 2}, {3, 8}, {11, 6}})); //1
        System.out.println(s.solution(new int[][]{{3,5}, {4,1}, {2,4}, {5,10}})); //1
    }
}
