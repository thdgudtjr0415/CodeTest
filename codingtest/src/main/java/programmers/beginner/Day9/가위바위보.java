package programmers.beginner.Day9;

// 문제
// 가위는 2 바위는 0 보는 5로 표현합니다.
// 가위 바위 보를 내는 순서대로 나타낸 문자열 rsp가 매개변수로 주어질 때,
// rsp에 저장된 가위 바위 보를 모두 이기는 경우를 순서대로 나타낸
// 문자열을 return하도록 solution 함수를 완성해보세요.
// 0 < rsp의 길이 ≤ 100
// rsp와 길이가 같은 문자열을 return 합니다.
// rsp는 숫자 0, 2, 5로 이루어져 있습니다.



public class 가위바위보 {
    public String solution(String rsp) {
        String result = "";
        String[] arr = rsp.split("");

        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals("2")){
                result += "0";
            }else if(arr[i].equals("0")){
                result += "5";
            }else if(arr[i].equals("5")){
                result += "2";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        가위바위보 p = new 가위바위보();
        System.out.println(p.solution("2"));
        System.out.println(p.solution("205"));
    }
}
