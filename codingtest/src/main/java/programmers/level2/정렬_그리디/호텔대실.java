package programmers.level2.정렬_그리디;

// 한 번 사용한 객실은 퇴실 시간을 기준으로 10분간 청소를 하고 다음 손님들이 사용
//book_time을 입실 시각이 빠른 순서로 정렬
//손님을 한 명씩 보면서, 지금까지 쓰던 객실 중 입실 시각 이전에 비는 방이 있는지 찾아요.
//있으면 그 방을 이어서 쓰고, 그 방이 비는 시각을 이 손님의 퇴실 + 10분으로 바꿔요.
//없으면 방을 하나 더 만들어요.
//마지막에 만들어진 방의 개수가 답이에요.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 호텔대실 {
    public int solution(String[][] book_time) {
        List<Integer> list = new ArrayList<>();
        // 입실 빠른순으로 정렬
        // 정렬 양수 :  a가 b뒤로, 음수, 0 : 그대로
        Arrays.sort(book_time, (a,b) -> toMinutes(a[0]) - toMinutes(b[0]));
        for(int i = 0; i < book_time.length; i++){
            String[] time = book_time[i];
            int in = toMinutes(time[0]);
            int out = toMinutes(time[1]) + 10;
            boolean isBook = false;
            for(int j = 0; j < list.size(); j++){
                if(list.get(j) <= in){
                    list.set(j, out);
                    isBook = true;
                    break;
                }
            }
            if(!isBook) list.add(out);
        }
        return list.size();
    }

    private int toMinutes(String time){
        String[] arr = time.split(":");
        int hourMin = Integer.parseInt(arr[0]) * 60;
        int minute = Integer.parseInt(arr[1]);
        return hourMin + minute;
    }

    public static void main(String[] args) {
        호텔대실 s = new 호텔대실();
        // 입출력 예 1 -> 3
        System.out.println(s.solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}})); // 3
        // 입출력 예 2 -> 1
        System.out.println(s.solution(new String[][]{{"09:10", "10:10"}, {"10:20", "12:20"}})); // 1
        // 입출력 예 3 -> 3
        System.out.println(s.solution(new String[][]{{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}})); // 3
    }
}
