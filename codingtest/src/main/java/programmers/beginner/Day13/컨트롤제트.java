package programmers.beginner.Day13;

public class 컨트롤제트 {
    public int solution(String s) {
        // 문제에서 공백이 있으니 공백으로 split해서 배열 만들어줌
        String[] arr = s.split(" ");
        int result = 0;
        // 방법1
        // 주의할 점은 여태 char로 꺼내서 작업했는데
        // 이 방법은 10 같은 두자리 이상부터는 사용 불가라 이렇게 해야함
        for(int i=1; i <= arr.length; i++){
            // 여기서 문자열 Z 가 아니라면 += 해주고 Z면 - 해줌
            if(!arr[i-1].equals("Z")){
                // 여기서 주의 할 점은 String[]은 Integer.parseInt를 해줘야
                // 숫자로 들어감
                result += Integer.parseInt(arr[i-1]);
            }else{
                result -= Integer.parseInt(arr[i-2]);
            }
        }

        return result;
    }
    public static void main(String[] args) {
        컨트롤제트 s = new 컨트롤제트();
        System.out.println(s.solution("1 2 Z 3")); // 4
        System.out.println(s.solution("10 20 30 40")); // 100
        System.out.println(s.solution("10 Z 20 Z 1")); // 1
        System.out.println(s.solution("10 Z 20 Z")); // 0
        System.out.println(s.solution("-1 -2 -3 Z")); // -3
    }
}
