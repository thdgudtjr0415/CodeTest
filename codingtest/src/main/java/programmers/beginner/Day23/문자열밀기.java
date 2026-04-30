package programmers.beginner.Day23;

// 굳이 배열로 만들지 말고 substring으로 해보기
// substring(시작인덱스) 즉 시작 인덱스 부터 끝까지 잘라내기 즉
// helloWorld 라는게 있으면 str.substring(5); = World가 나옴
// substring(beginIndex, endIndex) 이렇게도 할 수 있음
public class 문자열밀기 {
    public int solution(String A, String B) {
        int result = 0;
        String temp = A;

        for(int i = 0; i < temp.length(); i++){
            // temp가 B랑 맞는지
            if(temp.equals(B)){
                // 반복문 돌았던 수 만큼 리턴
                return i;
            }
            // 여기서substring 으로 순서 밀기
            // 여기엔 i를 안 넣어도 되는게 이게 순서를 한번 바꾸고 저장 하는 방식이라
            // 그냥 이렇게 만 둬도 알아서 오른쪽 밀기가 됨
            temp = temp.substring(temp.length()-1) + temp.substring(0, temp.length()-1);
        }

        // for문 다 돌았는데 안맞으면 -1
        return -1;
    }
    public static void main(String[] args) {
        문자열밀기 s  = new 문자열밀기();
        System.out.println(s.solution("hello","ohell")); // 1
        System.out.println(s.solution("apple","elppa")); // -1
        System.out.println(s.solution("atat","tata")); // 1
        System.out.println(s.solution("abc","abc")); // 0
    }
}