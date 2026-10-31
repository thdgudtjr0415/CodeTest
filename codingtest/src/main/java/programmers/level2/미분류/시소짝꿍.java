package programmers.level2.미분류;

// 중심으로부터 2(m), 3(m), 4(m) 거리의 지점에 좌석
//180 → 1/2배
//240 → 2/3배
//270 → 3/4배
//360 → 1배
//480 → 4/3배
//540 → 3/2배
//720 → 2배

import java.util.HashMap;

class 시소짝꿍 {
    public long solution(int[] weights) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long answer = 0;

        for(int i = 0; i < weights.length; i++){
            int num = weights[i];
            map.put(num, map.getOrDefault(num, 0) +1);
        }

        // 가능한 비율은 1/2, 2/3, 3/4, 1, 4/3, 3/2, 2배.
        // 중복을 피하려고 가벼운 쪽에서 무거운 쪽만 찾는다 → 1배, 2배, 3/2배, 4/3배 네 가지
        for(int num : map.keySet()){
            long cnt = map.get(num);
            answer += cnt * (cnt-1) /2;
            if(map.containsKey(num*2)){
                answer += cnt * map.get(num*2);
            }
            if((num*3)%2 == 0 && map.containsKey((num*3)/2)){
                answer += cnt * map.get((num*3)/2);
            }
            if((num*4)%3 == 0 && map.containsKey((num*4)/3)){
                answer += cnt * map.get((num*4)/3);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        시소짝꿍 s = new 시소짝꿍();
        System.out.println(s.solution(new int[]{100, 180, 360, 100, 270})); // 4
    }
}
