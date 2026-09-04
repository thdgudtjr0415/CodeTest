package programmers.level2;

import java.util.HashMap;

public class 의상 {
    public int solution(String[][] clothes) {
        // HashMap으로 의상 종류 개수 대로 넣기
        HashMap<String, Integer> map = new HashMap<>();
        int answer = 1;
        for(int i = 0; i < clothes.length; i++){
            String key = clothes[i][1];
            if(!map.containsKey(key)){
                map.put(key,1);
            }else {
                map.put(key,map.get(key)+1);
            }
        }
        if(map.size() == 1) return clothes.length;
        // 여기서 왜 1을 더하고 모두 곱하는 거냐면
        // 1. 1을 더하는 이유는 안 입는 경우, 즉 선택을 안하는 경우라서 +1을 더해야함
        // 2. 그렇다면 마지막에 -1을 하는 이유는 모두 선택을 안한다는 가정인데
        // 가지수를 셀때 각 항목에 대해서 모두 곱하면 되지만
        // 문제에서 말한 무조건 최소 한개의 의상은 입는다 라는 조건 때문에 -1을 해야함
        for(int num : map.values()){
            answer *= (num+1);
        }
        return answer-1;
    }
    public static void main(String[] args){
        의상 s = new 의상();
        System.out.println(s.solution(new String[][]{
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}})); //5
        System.out.println(s.solution(new String[][]{
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}})); //3

        System.out.println(s.solution(new String[][]{
                {"yellow_hat", "headgear"},
                {"green_turban", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"red_scarf", "face"}}));  //11  (종류가 3개 이상일 때 검증용 — headgear 2개, eyewear 1개, face 1개)
    }
}
