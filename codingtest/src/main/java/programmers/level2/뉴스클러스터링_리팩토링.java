package programmers.level2;

import java.util.HashMap;
import java.util.HashSet;

public class 뉴스클러스터링_리팩토링 {
    public int solution(String str1, String str2) {
        String[] str1Arr = new String[str1.length()-1];
        String[] str2Arr = new String[str2.length()-1];

        wordSplit(str1, str1Arr);
        wordSplit(str2, str2Arr);

        // 교집합, 합집합 개수 메서드로 따로 빼기, 중복 코드 많음
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        toWordMap(str1Arr, map1);
        toWordMap(str2Arr, map2);

        HashSet<String> allkeys = new HashSet<>();
        allkeys.addAll(map1.keySet());
        allkeys.addAll(map2.keySet());

        int union = 0;
        int intersection = 0;

        // 각 조각별로 min은 교집합, max는 합집합에 누적
        // 결국 이 과정을 하는 이유는 교집합을 구하기 위해 두개를 비교 하여 둘다 값이 올라간다면
        // 즉 {aa,aa} {aa,aa,aa} 일때 합집합은 3개, 교집합은 3개이기 때문에 이 교집합을 구하여
        // 식을 구할 예정이기 때문에 이 과정이 필요
        for(String key : allkeys){
            int count1 = map1.getOrDefault(key,0);
            int count2 = map2.getOrDefault(key,0);
            union += Math.max(count1, count2); // 합집합
            intersection += Math.min(count1, count2); // 교집합
        }

        return union == 0 ? 65536 : (int)((float)intersection / (float) union * 65536);
    }

    private void toWordMap(String[] strArr, HashMap<String, Integer> map) {
        for(int i = 0; i < strArr.length; i++){
            String word = strArr[i];
            if(!word.matches("[a-z]+")) continue;
            map.put(word, map.getOrDefault(word, 0)+1);
        }
    }

    private void wordSplit(String str, String[] strArr) {
        // 전체다 소문자로 만들고 시작
        str = str.toLowerCase();
        for(int i = 0; i < str.length(); i++){
            if(i+1 < str.length()){
                strArr[i] = str.charAt(i) + "" + str.charAt(i+1);
            }
        }
    }

    public static void main(String[] args){
        뉴스클러스터링_리팩토링 s = new 뉴스클러스터링_리팩토링();
        System.out.println(s.solution("FRANCE", "french")); //16384
        System.out.println(s.solution("handshake", "shake hands")); //65536
        System.out.println(s.solution("aa1+aa2", "AAAA12")); //43690
        System.out.println(s.solution("E=M*C^2", "e=m*c^2")); // 65536
        System.out.println(s.solution("AB", "XY")); // 0
    }
}
