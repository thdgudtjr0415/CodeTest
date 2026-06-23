package programmers.level1.Day05;

public class 부족한금액계산하기 {
    public long solution(int price, int money, int count) {
        // result 는 금액이 부족한 상태
        long result = 0;
        long sumCount = 0;
        for(int i = 1; i <= count; i++){
            sumCount += (long) i *price;
        }
        if(money-sumCount < 0){
            result = sumCount-money;
        }else {
            result = 0;
        }
        return result;
    }
    public static void main(String[] args) {
        부족한금액계산하기 s = new 부족한금액계산하기();
        System.out.println(s.solution(3, 20, 4)); //10
    }

}
