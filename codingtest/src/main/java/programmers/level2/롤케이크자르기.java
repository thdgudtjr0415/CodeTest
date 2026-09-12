package programmers.level2;

import java.util.HashMap;
import java.util.HashSet;

public class 롤케이크자르기 {
    // 시간 초과
    public int solution1(int[] topping) {
        int answer = 0;
        HashSet<Integer> set1 = new HashSet<>();
        for(int i = 0; i < topping.length-1; i++){
            set1.add(topping[i]);
            HashSet<Integer> set2 = new HashSet<>();
            for(int j = i+1; j < topping.length; j++){
                set2.add(topping[j]);
            }
            if(set1.size() == set2.size()){
                answer++;
            }
        }
        return answer;
    }
    // 미리 HashMap에서 계산을 다 끝내 놓고 하나씩 옮기면서 하는건?
    // solution1 은 2중 반복문이라 오래 걸릴듯 자료구조도 계속 생성 삭제해서 느림
    // 그리고 map에서 숫자 줄이고 0 되면 삭제해야됨 삭제 안하면 size는 아직도 살아있음
    public int solution2(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for(int i = 0; i < topping.length; i++){
            if(!map1.containsKey(topping[i])){
                map1.put(topping[i], 1);
            }else {
                map1.put(topping[i], map1.get(topping[i]) + 1);
            }
        }
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for(int i = 0; i < topping.length; i++){
            if(!map2.containsKey(topping[i])){
                map2.put(topping[i], 1);
            }else {
                map2.put(topping[i], map2.get(topping[i]) + 1);
            }
            map1.put(topping[i], map1.get(topping[i]) - 1);
            if(map1.get(topping[i]) == 0){
                map1.remove(topping[i]);
            }

            if(map1.size() == map2.size()){
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        롤케이크자르기 s = new 롤케이크자르기();
//        System.out.println(s.solution1(new int[]{1, 2, 1, 3, 1, 4, 1, 2})); // 2
//        System.out.println(s.solution1(new int[]{1, 2, 3, 1, 4})); // 0

        System.out.println(s.solution2(new int[]{1, 2, 1, 3, 1, 4, 1, 2})); // 2
        System.out.println(s.solution2(new int[]{1, 2, 3, 1, 4})); // 0
    }
}
