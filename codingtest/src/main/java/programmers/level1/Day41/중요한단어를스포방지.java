package programmers.level1.Day41;
/*
 * 풀이 순서
 * 1. message.length() 크기의 boolean[] spoilers 배열을 만들고,
 *    spoiler_ranges의 각 [start, end] 구간을 true로 채운다
 * 2. message.split(" ")로 단어 목록을 얻고, 포인터(idx)를 움직이면서
 *    각 단어의 [start, end] 인덱스 구간을 같이 계산한다
 *    (start = idx, end = idx + word.length() - 1, 다음 idx = end + 2)
 * 3. 단어 하나하나에 대해, [start, end] 구간 안에 spoilers[k] == true인 칸이
 *    하나라도 있으면 -> 스포 단어로 표시
 * 4. 모든 단어(스포든 아니든 전부)를 다시 훑으면서, 이 단어가 스포 구간이 아닌
 *    부분에 걸리면(= [start,end] 구간 안에 spoilers[k] == false인 칸이 하나라도 있으면)
 *    -> 그 단어 텍스트를 HashSet(outsideWords)에 추가
 * 5. 왼쪽부터 순서대로, 스포 단어만 골라서 판정
 *    - outsideWords에 이 단어 텍스트가 있으면 -> 탈락
 *    - 아니면, 이미 중요한 단어로 인정된 것들(HashSet importantWords)에 이미 있으면 -> 탈락 (중복)
 *    - 둘 다 아니면 -> 중요한 단어! 카운트 +1, importantWords에도 추가
 * 6. 최종 카운트 반환
 */

import java.util.Arrays;
import java.util.HashSet;

public class 중요한단어를스포방지 {
    public int solution(String message, int[][] spoiler_ranges) {
        int result = 0;
        int n = message.length();
        boolean[] spoilers = new boolean[n];
        // 스포일러 부분 true로 표시
        for(int i = 0; i < spoiler_ranges.length; i++){
            int start = spoiler_ranges[i][0];
            int end = spoiler_ranges[i][1];
            for(int k = start; k <= end; k++){
                spoilers[k] = true;
            }
        }
        // 아래의 3줄은 공백 기준으로 끊긴 단어, 시작 인덱스, 끝 인덱스임
        // message 공백 기준 끊기
        //words   = [here, is, muzi, here, is, a, secret, message]
        //startArr = [0, 5, 8, 13, 18, 21, 23, 30]
        //endArr   = [3, 6, 11, 16, 19, 21, 28, 36]
        String[] words = message.split(" ");
        // start,end 인덱스 들어갈 배열 만들기
        int[] startArr = new int[words.length];
        int[] endArr = new int[words.length];

        int idx = 0; // 몇번째 글자인지 공백은 지나감
        for(int i = 0; i < words.length; i++){
            int start = idx;
            int end = start + words[i].length() -1 ; // 글자 들어온거 + 글자 길이 -1 해야 인덱스 계산
            idx = end + 2; // end + 1 하면 공백 이라 end + 2를 해줘야 다음 글자가 됨

            startArr[i] = start;
            endArr[i] = end;
        }

        // 여기서는 전체 단어들을 돌면서 boolean배열에 true, 즉 스포방지가 걸려있는지 체크해야함, boolean 배열 하나 더 필요
        // 여기서 체크해야하는 것들을
        // 1. 스포방지가 들어간 단어 체크
        // 2. 스포방지가 들어가지 않은 단어 체크임
        // 그래서 스포방지가 들어간 단어가 그외에 즉 스포방지가 들어가지 않은 단어랑 같은 것이 있다면 그 단어는 탈락
        HashSet<String> insidewords = new HashSet<>();
        boolean[] check = new boolean[words.length];
        for(int i = 0; i < words.length; i++){
            for(int j = startArr[i]; j <= endArr[i]; j++){
                if(spoilers[j] == true){
                    check[i] = true;
                    insidewords.add(words[i]);
                }
            }
        }
        HashSet<String> outsidewords = new HashSet<>();
        for(int i = 0; i < words.length; i++){
                if(check[i] == false){
                    outsidewords.add(words[i]);
            }
        }
        // 이제 두개의 hashset을 비교
        for(String temp : insidewords){
            if(!outsidewords.contains(temp)){
                result++;
            }
        }

        return result;
    }
    public static void main(String[] args){
        중요한단어를스포방지 s = new 중요한단어를스포방지();
        System.out.println(s.solution(
                "here is muzi here is a secret message",
                new int[][]{{0,3},{23,28}})); // 1
        System.out.println(s.solution(
                "my phone number is 01012345678 and may i have your phone number",
                new int[][]{{5,5},{25,28},{34,40},{53,59}})); // 4
    }
}
