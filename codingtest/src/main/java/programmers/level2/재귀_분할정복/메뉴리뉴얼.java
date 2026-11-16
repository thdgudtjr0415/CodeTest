package programmers.level2.재귀_분할정복;

import java.util.*;

//각 주문 문자열을 글자순으로 정렬해요.
//course의 길이 L마다, 모든 주문에서 길이 L짜리 조합을 재귀로 만들어서 Map에 횟수를 세어요.
//그 길이에서 횟수가 2 이상이고 가장 큰 조합을 모두 결과에 담아요.
//결과 전체를 사전순으로 정렬해서 반환해요.

public class 메뉴리뉴얼 {
    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < orders.length; i++){
            char[] wordArr = orders[i].toCharArray();
            Arrays.sort(wordArr);

            for(int j = 0; j < course.length; j++){
                int n = course[j];
                String word = "";
                int idx = 0;
                makeCombination(wordArr, n, word, idx, map);
            }
        }
//        System.out.println(map);
        for(int i = 0; i < course.length; i++){
            int n = course[i];
            int max = 0;
            for(String word : map.keySet()){
                if(word.length() == n){
                    max = Math.max(map.get(word), max);
                }
            }
            for(String word : map.keySet()){
                if(word.length() == n && map.get(word) >= 2 && map.get(word) == max){
                    list.add(word);
                }
            }
        }
        Collections.sort(list);
        String[] answer = new String[list.size()];
        for(int i = 0 ; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    private void makeCombination(char[] wordArr,
                                 int n,
                                 String word,
                                 int idx,
                                 HashMap<String, Integer> map) {
        // 1. 조합이 완성됐을 때
        if(word.length() == n){
            // map에 횟수 기록
            map.put(word, map.getOrDefault(word, 0) + 1);
            return;
        }

        // 2. 아직 덜 만들었을 때
        for(int i = idx; i < wordArr.length; i++){
            // word에 wordArr[i]를 붙여서 다시 호출 (시작 인덱스는 i + 1)
            makeCombination(wordArr, n, word + wordArr[i], i + 1, map);
        }
    }

    public static void main(String[] args) {
        메뉴리뉴얼 s = new 메뉴리뉴얼();
        System.out.println(Arrays.toString(s.solution(
                new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
                new int[]{2, 3, 4}))); // ["AC", "ACDE", "BCFG", "CDE"]
        System.out.println(Arrays.toString(s.solution(
                new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
                new int[]{2, 3, 5}))); // ["ACD", "AD", "ADE", "CD", "XYZ"]
        System.out.println(Arrays.toString(s.solution(
                new String[]{"XYZ", "XWY", "WXA"},
                new int[]{2, 3, 4}))); // ["WX", "XY"]
    }
}
