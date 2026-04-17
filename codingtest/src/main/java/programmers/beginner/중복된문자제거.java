package programmers.beginner;
//문제 설명
//문자열 my_string이 매개변수로 주어집니다.
// my_string에서 중복된 문자를 제거하고 하나의 문자만 남긴 문자열을 return하도록 solution 함수를 완성해주세요.
//
//제한사항
//1 ≤ my_string ≤ 110
//my_string은 대문자, 소문자, 공백으로 구성되어 있습니다.
//대문자와 소문자를 구분합니다.
//공백(" ")도 하나의 문자로 구분합니다.
//중복된 문자 중 가장 앞에 있는 문자를 남깁니다.
//입출력 예
//my_string	result
//"people"	"peol"
//"We are the world"	"We arthwold"
//입출력 예 설명
//입출력 예 #1
//"people"에서 중복된 문자 "p"와 "e"을 제거한 "peol"을 return합니다.
//입출력 예 #2
//"We are the world"에서 중복된 문자 "e", " ", "r" 들을 제거한 "We arthwold"을 return합니다.

public class 중복된문자제거 {
    public String solution(String my_string) {
        String result = "";
        // 방법1 이중반복문
//        for(int i = 0; i < my_string.length(); i++){
//            char c = my_string.charAt(i);
//            // 중복되는지 boolean으로 체크해보기
//            boolean check = false;
//
//            // 여기서 왜 j < i 인지는 문제에서 앞에 글자만 남긴다고도 했고
//            // 뒤에 문자가 중복된다면 앞에것만 쓴다고함 그럼
//            // 뒤에 문자에서 앞에를 체크하는게 훨씬 나음
//            for(int j = 0; j < i; j++){
//                if(c == my_string.charAt(j)){
//                    check = true;
//                }
//            }
//            if(check != true){
//                result += c;
//            }
//        }

        // 방법2 contains를 사용해서 지정된 전체 문자열에서 그 부분이 포함되어잇는지 확인하기
        for(int i = 0; i < my_string.length(); i++){
            String c = String.valueOf(my_string.charAt(i));
            if(!result.contains(c)){
                result += c;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        중복된문자제거 s = new 중복된문자제거();
        System.out.println(s.solution("people")); // peol
        System.out.println(s.solution("We are the world")); // We arthwold
    }
}
