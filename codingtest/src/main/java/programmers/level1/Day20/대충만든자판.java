package programmers.level1.Day20;

import java.util.Arrays;
import java.util.HashMap;

public class 대충만든자판 {
    public int[] solution(String[] keymap, String[] targets) {
        int[] result = new int [targets.length];
        // hashmap은 key, value 저장
        HashMap<Character, Integer> keyMapStore = new HashMap<>();
        for(int i = 0; i < keymap.length; i++){
            for(int j = 0; j < keymap[i].length(); j++){
                char c = keymap[i].charAt(j);
                int clicks = j + 1; // 실제로 누르는건 인덱스 + 1이라서
                // 여기는 hashmap에 넣을 것들 정리하는것
                // !keyMapStore.containsKey(c) : char c를 받아오는데 없으면
                // clicks < keyMapStore.get(c) : 만약에 기존에 hashmap에 있는데 이번에 들어온게 clicks보다 작다면(클릭의 최솟값 찾는게 문제)
                if(!keyMapStore.containsKey(c) || clicks < keyMapStore.get(c)){
                    keyMapStore.put(c, clicks);
                }
            }
        }
        for(int i = 0; i < targets.length; i++){
            int sum = 0;

            for(int j = 0; j < targets[i].length(); j++){
                char targetChar = targets[i].charAt(j);
                if(keyMapStore.containsKey(targetChar)){
                    sum += keyMapStore.get(targetChar);
                }else {
                    sum = -1;
                    break;
                }
            }
            result[i] = sum;
        }
        return result;
    }
    public static void main(String[] args){
        대충만든자판 s = new 대충만든자판();
        System.out.println(Arrays.toString(s.solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD","AABB"}))); // 9,4
        System.out.println(Arrays.toString(s.solution(new String[]{"AA"}, new String[]{"B"}))); // -1
        System.out.println(Arrays.toString(s.solution(new String[]{"AGZ", "BSSS"}, new String[]{"ASA","BGZ"}))); // 4,6
    }
}
