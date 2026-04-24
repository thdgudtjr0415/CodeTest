package programmers.beginner.Day19;

// 가장 긴 변의 길이는 두변의 길이의 합보다 작아야한다 그래서 그 숫자들의 갯수
// 즉 경우의 수가 2가지
// 1. 아직 안나온 나머지 변의 길이가 제일 클때
// 2. 배열중의 가장 큰 수가 가장 긴 변일때
/*
 * 3, 6 을 예시로
 * 6이 가장 클때 나머지 변은 3+x > 6이어야 한다
 * x 가 제일 클때는 3+6 > x
 * 수식은 3+6 > x > 6-3
 * 이걸 배열로 하면 side[0], side[1]
 * 이때는 큰수는 변경 가능하니 작은수를 minside로 고정
 *  */
public class 삼각형의완성조건_02 {
    public int solution(int[] sides) {
        int result = 0;
        // maxSide 초기값
        int side1 = Math.min(sides[0], sides[1]);
        int side2 = Math.max(sides[0], sides[1]);
        // 1. 배열보다 클때 이 경우
        // restSide 보단 +1 부터 minSide + restSide -1
        int maxSide = side1 + side2 - 1;
//        result += maxSide - side2;
        // 경우수 2. 배열중에 제일 큰수 나왓을때 그럼 middleSide가 나옴
//                11 = 7 + x(5부터 11 까지 가능가능) 즉 7+x > 11 되어야하니까
        int middleSide = side2 - side1 +1;
//        result += side2 - middleSide+1;
        // 즉 정리하면
        result = maxSide - side2 + side2 - middleSide+1;
        return result;
    }

    public static void main(String[] args) {
        삼각형의완성조건_02 s = new 삼각형의완성조건_02();
        System.out.println(s.solution(new int[]{1,2})); //1
        System.out.println(s.solution(new int[]{3,6})); //5
        System.out.println(s.solution(new int[]{11,7})); //13
    }
}
