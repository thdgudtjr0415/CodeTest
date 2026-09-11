package programmers.level2;

import java.util.Arrays;

public class 전화번호목록 {
    // 정답은 맞으나 시간초과
    public boolean solution1(String[] phone_book){
        boolean answer = true;
        for(int i = 0; i < phone_book.length; i++){
            String prefix = phone_book[i];
            int len = prefix.length();
            for(int j = 0; j < phone_book.length; j++){
                if(!prefix.equals(phone_book[j])){
                    if(phone_book[j].length() >= len && prefix.equals(phone_book[j].substring(0, len))){
                        answer = false;
                        break;
                    }
                }
            }
        }
        return answer;
    }

    // Arrays.sort로 정렬하고 비슷한것들 끼리 비교
    // 먼저 비교 하고 길이가 짧은 것이 우선
    public boolean solution2(String[] phone_book){
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length-1; i++){
            String prev = phone_book[i];
            String next = phone_book[i+1];
            if(next.length() > prev.length() &&prev.equals(next.substring(0, prev.length()))){
                answer = false;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        전화번호목록 s = new 전화번호목록();
//        System.out.println(s.solution1(new String[]{"119", "97674223", "1195524421"})); // false
//        System.out.println(s.solution1(new String[]{"123","456","789"})); // ture
//        System.out.println(s.solution1(new String[]{"12","123","1235","567","88"})); // false

        System.out.println(s.solution2(new String[]{"119", "97674223", "1195524421"})); // false
        System.out.println(s.solution2(new String[]{"123","456","789"})); // ture
        System.out.println(s.solution2(new String[]{"12","123","1235","567","88"})); // false
    }
}
