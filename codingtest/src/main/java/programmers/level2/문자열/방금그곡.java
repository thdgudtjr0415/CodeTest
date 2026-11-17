package programmers.level2.문자열;

// 음은 C, C#, D, D#, E, F, F#, G, G#, A, A#, B 12개만 사용, 1분에 1개씩만 재생 (C#, D# 같은 음은 글자 2개가 음 1개)
// 음악은 처음부터 재생, 음악 길이보다 재생된 시간이 길 때는 음악이 끊김 없이 처음부터 반복해서 재생
// 음악 길이보다 재생된 시간이 짧을 때는 처음부터 재생 시간만큼만 재생
// 재생된 멜로디 안에 기억한 멜로디 m이 들어 있는(부분 문자열) 곡이 조건에 맞는 곡
// 조건에 맞는 곡이 여러 개면 재생된 시간이 제일 긴 음악 제목, 재생된 시간도 같을 경우 먼저 입력된 음악
// 조건에 맞는 곡이 하나도 없으면 "(None)" 반환

import java.util.ArrayList;
import java.util.List;


public class 방금그곡 {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        // 처음멜로디
        String mListJoin = String.join("", toNoteList(m));
        // 지금 까지 고른 멜로디 길이
        int prePlayTime = 0;

        for(int i = 0; i < musicinfos.length; i++){
            // 하나 받아서 나눠놓기
            String[] info = musicinfos[i].split(",");
            // 음악 재생 시간
            int playTime = toMinutes(info[1].split(":")) - toMinutes(info[0].split(":"));
            // 현재 음악 이름
            String musicName = info[2];
            // 악보
            String score = info[3];
            // 악보 C# -> c로 바꾸는 작업
            List<String> scoreList = toNoteList(score);
            StringBuilder scoreListJoin = new StringBuilder(); // 최적화
            // playTime 으로 길이 맞추기
            for(int j = 0; j < playTime; j++){
                scoreListJoin.append(scoreList.get(j%(scoreList.size())));
            }
            if(scoreListJoin.toString().contains(mListJoin)){
                // 아직 None 이거나 조건은 같은데 시간이 긴게 들어온다면
                if(answer.equals("(None)") || prePlayTime < playTime){
                    answer = musicName;
                    prePlayTime = playTime;
                }
            }
        }
        return answer;
    }
    private List<String> toNoteList(String notes){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < notes.length(); i++){
            String note = String.valueOf(notes.charAt(i));
            if(note.equals("#")){
                list.set(list.size()-1, list.get(list.size()-1).toLowerCase());
                continue;
            }
            list.add(note);
        }
        return list;
    }

    private int toMinutes(String[] time) {
        int hour = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);
        return hour*60 + min;
    }

    public static void main(String[] args) {
        방금그곡 sol = new 방금그곡();
        System.out.println(sol.solution("ABCDEFG",
                new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"})); // "HELLO"
        System.out.println(sol.solution("CC#BCC#BCC#BCC#B",
                new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"})); // "FOO"
        System.out.println(sol.solution("ABC",
                new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"})); // "WORLD"
    }
}
