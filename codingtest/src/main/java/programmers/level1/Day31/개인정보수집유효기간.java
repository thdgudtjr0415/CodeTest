package programmers.level1.Day31;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

//모든 달은 28일까지 있다고 가정⭐⭐
// privacies 라는 개인정보가 있는데 이를 today와 비교하여 파기해야할 번호들 구하기
// today는 "YYYY.MM.DD" 형태
// 번호는 index+1 하면되고

public class 개인정보수집유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        int toDay = toDay(today);
        String[][] termsArr = new String[terms.length][2];
        for(int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");
            termsArr[i][0] = term[0];
            termsArr[i][1] = String.valueOf(Integer.parseInt(term[1])*28); // 쉽게 28곱하고 String으로 시작
        }
        for(int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            String privacyDay = privacy[0];
            int privacytoDay = toDay(privacyDay); // 일수로 변환
            String privacyTermAlphabet = privacy[1];
            for(int j = 0; j < terms.length; j++) {
                if(termsArr[j][0].equals(privacyTermAlphabet)){
                    // 만료 당일부터 파기해야하기 때문에 = 부호 추가
                    if(toDay >= privacytoDay + parseInt(termsArr[j][1])){
                        list.add(i+1);
                    }
                }
            }
        }
        int[] result = list.stream()
                .mapToInt(i->i)// Integer::intValue 메서드 참조 (람다식 i -> i 와 동일)
                .toArray();
        return result;
    }
    int toDay(String today) {
        // 이거 . 혼자 쓰려면\\. 이렇게 써야함 , 혼자 . 이렇게 쓰면 모든 문자를 기준으로 split 이거 정규표현식임
        // 그리고 배열로 비교 하느니 일단위로 쪼개서 하는게 더 정확하게 비교 가능할듯
        String[] todayArr = today.split("\\.");
        int year = Integer.parseInt(todayArr[0]);
        int month = Integer.parseInt(todayArr[1]);
        int day = Integer.parseInt(todayArr[2]);
        // 반환값은 날짜를 그대로 일수로 변환하는 건데 이때 28을 곱한 것은 문제에서 모든 달은 28로 고정이라서
        return (year-1)*12*28 + (month-1)*28 + day;
    }
    public static void main(String[] args) {
        개인정보수집유효기간 s = new 개인정보수집유효기간();
        System.out.println(Arrays.toString(s.solution(
                "2022.05.19",
                new String[]{"A 6", "B 12", "C 3"},
                new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}))); //1,3
        System.out.println(Arrays.toString(s.solution(
                "2020.01.01",
                new String[]{"Z 3", "D 5"},
                new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"}))); //1,4,5
    }
}
