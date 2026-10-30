
//-1, +1, -10, +10, -100, +100 등과 같이 절댓값이 10c (c ≥ 0 인 정수) 형태인 정수들이 적힌 버튼

import java.util.Arrays;

public class 마법의엘리베이터 {
    public int solution(int storey) {
        int answer = 0;
        while(storey != 0){
            // 1의 자리 판별, 5보다 크면 10 - num 해서 그만큼 answer에 더함
            // 5보다 작으면 절대값 만큼 더하고 
            // 5면 이제 십의 자리수를 판별
            int oneNum = storey%10;
            int afterSum = 0;
            if(oneNum > 5){
                afterSum = 10 - oneNum;
            }else if(oneNum < 5){
                afterSum = -oneNum;
            }else{
                // 10의 자리
                // 10의 자리수에 따라 1의 자리를 어떠헥 할지 
                int tenNum = storey%100/10;
                if(tenNum >= 5){
                    afterSum = 5;
                }else{
                    afterSum = -5;
                }
            }
            storey = (storey + afterSum)/10;
            answer += Math.abs(afterSum);
        }
        return answer;
    }
    public static void main(String[] args){
        마법의엘리베이터 s = new 마법의엘리베이터();
        System.out.println(s.solution(16));//6
        System.out.println(s.solution(2554));//16
    }
}
