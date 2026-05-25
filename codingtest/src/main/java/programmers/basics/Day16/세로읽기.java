package programmers.basics.Day16;


public class 세로읽기 {
    public String solution(String my_string, int m, int c) {
        String result = "";
        // 이 문제는 어렵게 생각하지 말고 반복문의 특징을 잘 살려서 풀어보자
        //1. int i = c-1; 이부분은 인덱스 때문에 -1 을 해줘야 인덱스로 인식, 그리고 c번째에 위치한다 했으니 거기 부터 시작
        //2. i += m 이건 말 안해도 c인덱스 부터 m 번씩 번프를 뛰면 해결될 문제
        for(int i = c-1; i < my_string.length(); i += m){
            result += my_string.charAt(i);
        }
        return result;
    }
    public static void main(String[] args) {
        세로읽기 s = new 세로읽기();
        System.out.println(s.solution(new String("ihrhbakrfpndopljhygc"),4, 2));
        System.out.println(s.solution(new String("programmers"),1, 1));
    }
}
`