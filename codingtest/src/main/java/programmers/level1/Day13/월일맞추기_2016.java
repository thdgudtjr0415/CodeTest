package programmers.level1.Day13;

import java.time.LocalDate;

public class 월일맞추기_2016 {
    public String solution(int a, int b) {
        LocalDate date = LocalDate.of(2016,a,b);
        String result = date.getDayOfWeek().toString().substring(0,3);
        return result;
    }
    public static void main(String[] args) {
        월일맞추기_2016 s = new 월일맞추기_2016();
        System.out.println(s.solution(5,24));
    }
}
