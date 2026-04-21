package programmers.beginner.Day16;

// 인덱스 0부터 무조건 숫자,연산자,숫자,연산자 이렇게 시작합

public class 문자열계산하기 {
    public int solution(String my_string) {
        int result = 0;
        // 공백으로 배열 끊고
        String[] arr = my_string.split(" ");
        // 연산자는 특수한 경우이니 먼저 변수로 지정하고 시작
        String operator =  "+";

        for(int i = 0; i < arr.length; i++){
            int num = 0;
            // 연산자일때랑 숫자일때랑 구분
            if(arr[i].equals("+") || arr[i].equals("-")){
                operator = arr[i];
            }else {
                num = Integer.parseInt(arr[i]);
                // 그래서 숫자이면 연산자 들어가기
                if(operator.equals("+")){
                    result += num;
                }else if(operator.equals("-")){
                    result -= num;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        문자열계산하기 s = new 문자열계산하기();
        System.out.println(s.solution("3 + 4")); //7
    }
}
