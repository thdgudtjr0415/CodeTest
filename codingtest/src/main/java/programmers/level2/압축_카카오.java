package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// LZW 압축: 사전에 있는 가장 긴 문자열(w)을 찾아 번호를 출력하고, w+다음 글자를 사전에 등록
// 초기 사전: A(1) ~ Z(26), 새로 등록하는 단어는 27번부터

// 1. 현재 위치(i)의 한 글자로 w 시작
// 2. w + 다음 글자가 사전에 있으면 w를 늘린다 (없거나 글자가 끝나면 멈춤)
// 3. w의 번호를 list에 넣는다
// 4. 다음 글자가 남아 있으면 w+다음 글자를 사전에 등록 (++idx)
// 5. i를 w의 길이만큼 옮기고 1번으로

public class 압축_카카오 {
    public int[] solution(String msg){
        ArrayList<Integer> list = new ArrayList<>(); // 출력할 색인 번호를 담을 리스트
        // 사전: key = 단어, value = 색인 번호
        HashMap<String, Integer> map = new HashMap<>();
        // 초기 사전 A(1) ~ Z(26) 등록, idx = 마지막으로 등록한 번호
        int idx = 0;
        for(int i = 0; i < 26; i++){
            char w = (char) ('A' + i);
            map.put(String.valueOf(w), i+1);
            idx++;
        }
        // i = msg에서 지금 보고 있는 위치
        int i = 0;
        // i가 msg 길이보다 작은 동안 반복
        while(i < msg.length()){
            String w = String.valueOf(msg.charAt(i)); // 현재 글자
            // msg.length() > i+w.length() = 다음 글자가 있나?
            // map.containsKey(w+msg.charAt(i+w.length())) = w,c 를 합친게 있나?
            // 처음엔 KA가 사전에 없으니까 w는 K 그대로 멈춤
            while(msg.length() > i+w.length() && map.containsKey(w+msg.charAt(i+w.length()))){
                // 사전에 있으면 w가 늘어남 (예: K -> KA)
                w = w + msg.charAt(i + w.length());
            }
            // w의 번호를 list에 담기
            list.add(map.get(w));
            // 다음 글자가 남아 있으면 w+다음 글자를 사전에 등록 (예: KA)
            if(i+w.length() < msg.length()){
                map.put(w+msg.charAt(i+w.length()), ++idx);
            }
            // w 길이만큼 i 이동 (입력에서 w를 제거하는 것과 같음)
            i += w.length();
        }
        int[] answer = list.stream().mapToInt(Integer :: intValue).toArray();
        return answer;
    }


    public static void main(String[] args){
        압축_카카오 s = new 압축_카카오();
        System.out.println(Arrays.toString(s.solution("KAKAO")));
        // 11,1,27,15
        System.out.println(Arrays.toString(s.solution("TOBEORNOTTOBEORTOBEORNOT")));
        //[20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
        System.out.println(Arrays.toString(s.solution("ABABABABABABABAB")));
        // 	[1, 2, 27, 29, 28, 31, 30]
    }
}
