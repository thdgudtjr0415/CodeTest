package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 오픈채팅방 {
    public String[] solution(String[] record) {
        // 순서 id 용 (listId, listInOut 은 인덱스 끼리 페어)
        ArrayList<String> listId = new ArrayList<>();
        // inOut 저장용
        ArrayList<String> listInOut = new ArrayList<>();
        // map으로 아이디 이름 저장
        HashMap<String, String> map = new HashMap<>();
        String enterMsg = "님이 들어왔습니다.";
        String leaveMsg = "님이 나갔습니다.";

        // map에 넣기
        for(int i = 0; i < record.length; i++){
            String[] word = record[i].split(" ");
            // word[0] = InOut, word[1] = id, word[2] = name
            if(word[0].equals("Enter")){
                map.put(word[1], word[2]);
                listId.add(word[1]);
                listInOut.add(enterMsg);
            }else if(word[0].equals("Leave")){
                listId.add(word[1]);
                listInOut.add(leaveMsg);
            }else if(word[0].equals("Change")) {
                map.put(word[1], word[2]);
            }
        }

        String[] answer = new String[listId.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = map.get(listId.get(i)) + listInOut.get(i);
        }
        return answer;
    }
    public static void main(String[] args){
        오픈채팅방 s = new 오픈채팅방();
        System.out.println(Arrays.toString(s.solution(new String[]{
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"})));
        // ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
    }
}
