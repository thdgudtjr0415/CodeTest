package programmers.level1.Day04;

public class 핸드폰번호가리기 {
    public String solution(String phone_number) {
        String answer = "";
        answer = "*".repeat(phone_number.length()-4)
                + phone_number.substring(phone_number.length() - 4);
        return answer;
    }
    public static void main(String[] args) {
        핸드폰번호가리기 s = new 핸드폰번호가리기();
        System.out.println(s.solution("01033334444"));
        System.out.println(s.solution("027778888"));
    }
}
