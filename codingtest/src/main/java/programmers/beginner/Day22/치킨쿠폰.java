package programmers.beginner.Day22;

public class 치킨쿠폰 {
    public int solution(int chicken) {
        int result = 0;
        int coupon = chicken;

        // coupon 이 10 개 면 serviceChicken 1개
        while (coupon >= 10) {
            // serviceChicken 은 10개당 1개
            int serviceChicken = coupon / 10;
            // 치킨은 한개 시킬떄 마다 coupon 1개식 정립하니까 나머지 치킨 이 있다면 쿠폰에 추가
            int remainCoupon = coupon % 10;
            // 그래서 우리가 구하려는 serviceChicken result 에 추가
            result += serviceChicken;
            // 하지만 이게 10개 이상일때도 또 계산해야하기 때문에 받은 serviceChicken 과 remainCoupon 저장
            coupon = serviceChicken + remainCoupon;
        }

        return result;
    }
    public static void main(String[] args) {
        치킨쿠폰 s = new 치킨쿠폰();
        System.out.println(s.solution(100)); //11
        System.out.println(s.solution(1081)); // 120
    }
}
