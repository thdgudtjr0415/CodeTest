package programmers.level1.Day32;

//직원들은 일주일동안 자신이 설정한 출근 희망 시각 + 10분까지 어플로 출근
//출근 희망 시각이 9시 58분인 직원은 10시 8분까지 출근해야 합니다.
//단, 토요일, 일요일의 출근 시각은 이벤트에 영향을 끼치지 않습니다.
//모든 시각은 시에 100을 곱하고 분을 더한 정수로 표현됩니다. 10시 13분은 1013이 되고 9시 58분은 958
// 직원 n, 출근 희망시간schedules, 일주일동안 출근한 시간 timelogs, 이벤트를 시작한 요일 startday
//timelogs[i]의 길이 = 7, timelogs[i][j]는 i + 1번째 직원이 이벤트 j + 1일차에 출근한 시각을 의미
//1 ≤ startday ≤ 7 6토, 7일
// 직원의 수는 배열의 수, 즉 예제1은 n = 3, 예제 2는 n=4

// 이 문제는 모두 분으로 바꿔서 계산하는게 편할듯? 그리고 예외상황으로는 자정 2400 이라고 하면 0000으로 바꿔줘야함
public class 유연근무제 {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        // 직원
        int n = schedules.length;
        // 요일
        int result = 0;
        for(int i = 0; i < n; i++){
            int successCount = 0;
            int scheduleMinute = (schedules[i]/100)*60 + schedules[i]%100;
            for(int j = 0; j < timelogs[i].length; j++){
                int day = (startday-1 + j) % 7 + 1;
                if(day == 6 || day == 7){
                    successCount++;
                    continue;
                }
                int timelogMinute = timelogs[i][j]/100*60 + timelogs[i][j]%100;
                if(scheduleMinute+10 >= timelogMinute){
                    successCount++;
                }
            }
            if(successCount == 7){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        유연근무제 s = new 유연근무제();
        System.out.println(s.solution(new int[]{700, 800, 1100},
                new int[][]{
                        {710, 2359, 1050, 700, 650, 631, 659},
                        {800, 801, 805, 800, 759, 810, 809},
                        {1105, 1001, 1002, 600, 1059, 1001, 1100}}, 5)); //3
        System.out.println(s.solution(new int[]{730, 855, 700, 720},
                new int[][]{
                        {710, 700, 650, 735, 700, 931, 912},
                        {908, 901, 805, 815, 800, 831, 835},
                        {705, 701, 702, 705, 710, 710, 711},
                        {707, 731, 859, 913, 934, 931, 905}}, 1)); //2
    }
}
