package programmers.level2;

// 2진수 부터 16진수까지 모두
// result 의 문자열 길이는 t


public class N진수게임 {
    public String solution1(int n, int t, int m, int p) {
        String result = "";
        // 잠깐 담아놓을 변수
        String temp = "";
        // 0부터 시작할 변수
        int num = 0;
        // 인덱스(순서), 만약 첫 순서면 0이 되어야 하고 2번째면 1이 되어야됨
        // 그리고 m씩 더해가면서 글자 가져오면됨
        int idx = p-1;
        while(result.length() != t){
            // Integer.toString으로 진법 변환 한번에 하기
            temp += Integer.toString(num++, n);
            // 조건 혹여나 temp의 길이가 예상보다 적을 경우
            if(temp.length() > idx){
                result += temp.charAt(idx);
                idx += m;
            }
        }
        return result.toUpperCase();
    }
    // 자바에서 String은 불변(immutable) 객체라서 뭔갈 할때마다 작업, 비용이 커질 수 있음
    // 그래서 이를 해결하기 위해서 StringBuilder를 사용해보는것이 좋을듯
    public String solution2(int n, int t, int m, int p) {
        StringBuilder result = new StringBuilder();
        // 잠깐 담아놓을 변수
        StringBuilder temp = new StringBuilder();
        // 0부터 시작할 변수
        int num = 0;
        // 인덱스(순서), 만약 첫 순서면 0이 되어야 하고 2번째면 1이 되어야됨
        // 그리고 m씩 더해가면서 글자 가져오면됨
        int idx = p-1;
        while(result.length() != t){
            // Integer.toString으로 진법 변환 한번에 하기
            temp.append(Integer.toString(num++, n));
            // 조건 혹여나 temp의 길이가 예상보다 적을 경우
            if(temp.length() > idx){
                result.append(temp.charAt(idx));
                idx += m;
            }
        }
        return result.toString().toUpperCase();
    }

    public static void main(String[] args){
        N진수게임 s = new N진수게임();
        System.out.println(s.solution2(2,4,2,1)); //0111
        System.out.println(s.solution2(16,16,2,1)); // 02468ACE11111111
        System.out.println(s.solution2(16,16,2,2)); // 13579BDF01234567

    }
}
