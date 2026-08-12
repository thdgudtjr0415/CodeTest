package programmers.level2.Day02;

public class JadenCase문자열만들기 {
    public String solution1(String s) {
        String answer = String.valueOf(Character.toUpperCase(s.charAt(0)));
        String temp = s.toLowerCase();
            for (int i = 1; i < temp.length(); i++) {
                char frontChar = temp.charAt(i - 1);
                char curChar = temp.charAt(i);
                if (frontChar == ' ' && !(curChar == ' ')) {
                    curChar = Character.toUpperCase(curChar);
                }
                answer += String.valueOf(curChar);
            }
        return answer;
    }
    //코드 리뷰 모든 조건을 for문에 담아서 한번에 처리해보자
    public String solution2(String s) {
        String answer = "";
        String temp = s.toLowerCase();
        for (int i = 0; i < temp.length(); i++) {
            // index 0 에서 앞글자가 없으니 임의로 조건을 넣어준것
            char frontChar = i == 0 ? ' ' : temp.charAt(i-1);
            char curChar = temp.charAt(i);
            if (frontChar == ' ' && !(curChar == ' ')) {
                curChar = Character.toUpperCase(curChar);
            }
            answer += String.valueOf(curChar);
        }
        return answer;
    }

        public static void main (String[]args){
            JadenCase문자열만들기 s = new JadenCase문자열만들기();
            System.out.println(s.solution1("3people unFollowed me")); //"3people Unfollowed Me"
            System.out.println(s.solution1("for the last week")); //"For The Last Week"
            System.out.println(s.solution1("hi  hello")); //"Hi  Hello"  (연속 공백 2칸)
            System.out.println(s.solution1("a b c")); //"A B C"  (한 글자짜리 단어)
            System.out.println(s.solution1("AAA BBB")); //"Aaa Bbb"  (전부 대문자인 단어)
            System.out.println(s.solution1("1st place winner")); //"1st Place Winner"  (숫자로 시작하는 단어)
            System.out.println(s.solution1(" hi there")); //" Hi There"  (문자열 맨 앞에 공백)

            System.out.println(s.solution2("3people unFollowed me")); //"3people Unfollowed Me"
            System.out.println(s.solution2("for the last week")); //"For The Last Week"
            // 아래는 추가 예제
            System.out.println(s.solution2("hi  hello")); //"Hi  Hello"  (연속 공백 2칸)
            System.out.println(s.solution2("a b c")); //"A B C"  (한 글자짜리 단어)
            System.out.println(s.solution2("AAA BBB")); //"Aaa Bbb"  (전부 대문자인 단어)
            System.out.println(s.solution2("1st place winner")); //"1st Place Winner"  (숫자로 시작하는 단어)
            System.out.println(s.solution2(" hi there")); //" Hi There"  (문자열 맨 앞에 공백)
        }
    }