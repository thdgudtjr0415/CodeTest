package programmers.basics.Day34;

import java.time.LocalDate;

public class 날짜비교하기 {
    public int solution1(int[] date1, int[] date2) {
        int result = 0;
        int dateOne = Integer.parseInt(String.valueOf(date1[0]+""+date1[1]+""+date1[2]));
        int dateTwo = Integer.parseInt(String.valueOf(date2[0]+""+date2[1]+""+date2[2]));
        if(dateOne < dateTwo){
            result = 1;
        }
        return result;
    }
    // LocalDate로 푼것
    public int solution2(int[] date1, int[] date2) {
        int result = 0;
        LocalDate one = LocalDate.of(date1[0], date1[1], date1[2]);
        LocalDate two = LocalDate.of(date2[0], date2[1], date2[2]);
        if(one.isBefore(two)){
            result = 1;
        }
        return result;
    }
    public static void main(String[] args){
        날짜비교하기 s = new 날짜비교하기();
        System.out.println(s.solution1(new int[]{2021,12,28}, new int[]{2021,12,29})); //1
        System.out.println(s.solution1(new int[]{1024,10,24}, new int[]{1024,10,24})); //0
        System.out.println(s.solution2(new int[]{2021,12,28}, new int[]{2021,12,29})); //1
        System.out.println(s.solution2(new int[]{1024,10,24}, new int[]{1024,10,24})); //0
    }
}
