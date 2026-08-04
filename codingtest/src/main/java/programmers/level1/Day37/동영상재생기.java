package programmers.level1.Day37;

/*
 * 기능: prev(10초 전), next(10초 후), 오프닝 건너뛰기 3가지
 * prev: 현재위치 -10초, 0초 미만이면 0초(처음)로 이동
 * next: 현재위치 +10초, 영상 길이 초과면 영상 길이(끝)로 이동
 * 오프닝 건너뛰기: prev/next 수행 "직후" 위치가 op_start <= 현재위치 <= op_end 구간이면 자동으로 op_end로 이동
 * video_len : 동영상 길이
 * pos       : 현재 재생위치
 * op_start  : 오프닝 시작 시간
 * op_end    : 오프닝 종료 시간
 * commands  : 사용자 입력 배열 ("prev" / "next")
 * commands를 순서대로 다 처리한 뒤, 최종 위치를 "mm:ss" 문자열로 반환
 *
 *
 * 순서
 * 1. 모든 시간을 초 단위 숫자로 변환해서 계산 -> 마지막에 다시 "mm:ss"로 변환
 * 2. 오프닝 건너뛰기, op_start <= pos <= op_end라면 자동으로 op_end 로 변환
 * 3. command 입력후 계산
 * 4. 다시 초로 변환했던 것을 format에 맞게 변환
 */

public class 동영상재생기 {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String result = "";
        // 모든 동영상의 시간을 초로 변경
        int videoLenSec = toSeconds(video_len);
        int posSec = toSeconds(pos);
        int opStartSec = toSeconds(op_start);
        int opEndSec = toSeconds(op_end);
        // 주의! : 오프닝 건너뛰기, op_start <= pos <= op_end라면 자동으로 op_end로 감
        if(opStartSec <= posSec && opEndSec >= posSec){
            posSec = opEndSec;
        }
        for(int i = 0; i < commands.length; i++){
            String command = commands[i];
            if(command.equals("prev")){
                posSec -= 10;
                if(posSec <= 0){
                    posSec = 0;
                }
            }else if(command.equals("next")){
                posSec += 10;
                if(posSec >= videoLenSec){
                    posSec = videoLenSec;
                }
            }
            if(opStartSec <= posSec && opEndSec >= posSec){
                posSec = opEndSec;
            }
        }
        result = toTimeString(posSec);
        return result;
    }

    private int toSeconds(String time) {
        String[] split = time.split(":");
        // 계산식 : min*60 + sec
        int min = Integer.parseInt(split[0]);
        int sec = Integer.parseInt(split[1]);
        return min * 60 + sec;
    }
    private String toTimeString(int totalSec) {
        int min = totalSec / 60;
        int sec = totalSec % 60;
        // 이거 잘 보기, format으로 파이썬 처럼 형식을 정할 수 있음
        return String.format("%02d:%02d", min, sec);
    }

    public static void main(String[] args) {
        동영상재생기 s = new 동영상재생기();
        System.out.println(s.solution(
                "34:33", "13:00", "00:55", "02:55",
                new String[]{"next","prev"})); //13:00
        System.out.println(s.solution(
                "10:55", "00:05", "00:15", "06:55",
                new String[]{"prev","next","next"})); //06:55
        System.out.println(s.solution(
                "07:22", "04:05", "00:15", "04:07",
                new String[]{"next"})); //04:17
    }
}
