package programmers.level2;

// 자카드 유사도: 두 집합 A, B의 교집합 크기 / 합집합 크기 (둘 다 공집합이면 1)
// 다중집합이라 교집합은 원소별 min 개수, 합집합은 원소별 max 개수로 계산
// 문자열을 2글자씩 끊어서 다중집합으로 만든다. 알파벳이 아닌 문자가 하나라도 섞인 조각은 버림, 대소문자 구분 안 함
// 결과(0~1 실수)에 65536을 곱하고 소수점 버려서 정수로 반환

// 알파벳인지 판별은 Character.isLetter(c) 나 matches 로 정규식 "[a-zA-Z]+" 사용
//
// 정규표현식
//[...]   → 대괄호 안의 문자 중 하나
//^       → 부정 (NOT)
//a-z     → 알파벳 소문자
//0-9     → 숫자
//\\-     → 빼기(-) / 빼기는 0-9 처럼 범위로 읽히기 때문에 \\ 를 붙여주거나 위치를 다르게 해야함
//_       → 밑줄
//.       → 마침표
// 즉 [^a-z0-9\\-_.] 혹은 [^a-z0-9_.-] 이런식으로

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 뉴스클러스터링_일반풀이 {
    public int solution(String str1, String str2) {
        String[] str1Arr = new String[str1.length()-1];
        String[] str2Arr = new String[str2.length()-1];

        wordSplit(str1, str1Arr);
        wordSplit(str2, str2Arr);

        // 교집합, 합집합 개수 구할 차례
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for(int i = 0; i < str1Arr.length; i++){
            String word = str1Arr[i];
            if(!word.matches("[a-z]+")){
                continue;
            }else {
                map1.put(word, map1.getOrDefault(word, 0)+1);
            }
        }

        for(int i = 0; i < str2Arr.length; i++){
            String word = str2Arr[i];
            if(!word.matches("[a-z]+")){
                continue;
            }else {
                map2.put(word, map2.getOrDefault(word, 0)+1);
            }
        }

        HashSet<String> allkeys = new HashSet<>();
        allkeys.addAll(map1.keySet());
        allkeys.addAll(map2.keySet());

        int union = 0;
        int intersection = 0;

        // 이부분 교집합 합집합 할때 좋네
        for(String key : allkeys){
            int count1 = map1.getOrDefault(key,0);
            int count2 = map2.getOrDefault(key,0);
            union += Math.max(count1, count2);
            intersection += Math.min(count1, count2);
        }

        if(union == 0) return 65536;

        float temp = (float)intersection / (float) union * 65536;

        return (int)temp;
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
        뉴스클러스터링_일반풀이 s = new 뉴스클러스터링_일반풀이();
        System.out.println(s.solution("FRANCE", "french")); //16384
        System.out.println(s.solution("handshake", "shake hands")); //65536
        System.out.println(s.solution("aa1+aa2", "AAAA12")); //43690
        System.out.println(s.solution("E=M*C^2", "e=m*c^2")); // 65536
        System.out.println(s.solution("AB", "XY")); // 0
    }
}
