package programmers.basics.Day05;

// 0도 짝수라고 감안하고 시작해야함
// 그리고 아무것도 없다면 "EMPTY"를 반환
// 문자열에서 1을 만나면 mode를 바꿈 즉 방식이 바뀐다고 생각
// mode 가 일반(0)일땐 code에서 짝수만 반환
// mode 가 다를때(1) code에서 홀수만 반환

// 1을 포함 하면서 진행해야할듯 split을 사용하면 오류 발생할 수있음, 배열로 따지면 모든 인덱스 각 인덱스에서 초기화되기 때문에
// 그래서 boolean으로 true, false로 하던가 int mode = 0; or 1; 로 해서 풀던가 하는게 좋을듯

public class 코드처리하기 {
    public String solution(String code) {
        String result = "";
        StringBuilder sb = new StringBuilder();
        int mode = 0;

        for(int i = 0; i < code.length(); i++) {
            char currentChar = code.charAt(i);
            if(currentChar == '1') {
                // 이렇게만 해줘도 모드 바뀜 처음이 0 이니까 1 만나면 1-0 이라서 1로 바뀜
                mode = 1 - mode;
            } else {
                if(mode == 0) {
                    if(i%2==0){
                    sb.append(currentChar);
                    }
                }else  if(mode == 1) {
                    if(i%2 !=0){
                    sb.append(currentChar);
                    }
                }
            }
        }
//        if(sb.length() == 0) {
//            result = "EMPTY";
//        }else {
//            result = sb.toString();
//        }
        result = sb.toString();
        return result.isEmpty() ? "EMPTY" : result;
    }
    public static void main(String[] args) {
        코드처리하기 s = new 코드처리하기();
        System.out.println(s.solution("abc1abc1abc"));
    }
}
