package programmers.basics.Day02;

// substring 문제인데 반복문으로도 풀어보기
/*
 * 성능 최적화 포인트 -> StringBuilder 사용
 * 자바에서 String은 한 번 생성되면 변하지 않는 불변(Immutable) 객체
 * 따라서 for문 안에서 += 연산으로 문자열을 더하면, 매번 새로운 String 객체가 메모리에 생성
 * 계속 메모리에 생성하게 된다면 메모리의 초과 및 속도 저하가 발생
 * 이를 방지하기 위해 내부 버퍼를 수정하는 가변(Mutable) 객체인
 * StringBuilder를 사용하여 문자열을 조립 하는것이 최적화 포인트
 */

public class 문자열겹쳐쓰기 {
    public String solution1(String my_string, String overwrite_string, int s) {
        String result = "";

        for(int i = 0; i < s; i++) {
            result += my_string.charAt(i);
        }
        for(int i = 0; i < overwrite_string.length(); i++) {
            result += overwrite_string.charAt(i);
        }
        for(int i = s+overwrite_string.length(); i < my_string.length(); i++) {
            result += my_string.charAt(i);
        }

        return result;
    }

    public String solution1_1(String my_string, String overwrite_string, int s) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s; i++) {
            sb.append(my_string.charAt(i));
        }
        for(int i = 0; i < overwrite_string.length(); i++) {
            sb.append(overwrite_string.charAt(i));
        }
        for(int i = s+overwrite_string.length(); i < my_string.length(); i++) {
            sb.append(my_string.charAt(i));
        }

        return sb.toString();
    }

    public String solution2(String my_string, String overwrite_string, int s) {
        String result = "";

        result = my_string.substring(0, s) + overwrite_string + my_string.substring(s+overwrite_string.length());

        return result;
    }
    public static void main(String[] args) {
        문자열겹쳐쓰기 s = new 문자열겹쳐쓰기();
        System.out.println(
                s.solution1("He11oWor1d", "lloWorl", 2)); // HelloWorld
        System.out.println(
                s.solution1("Program29b8UYP", "merS123", 7)); //ProgrammerS123

        System.out.println(
                s.solution1_1("He11oWor1d", "lloWorl", 2)); // HelloWorld
        System.out.println(
                s.solution1_1("Program29b8UYP", "merS123", 7)); //ProgrammerS123


        System.out.println(
                s.solution2("He11oWor1d", "lloWorl", 2)); // HelloWorld
        System.out.println(
                s.solution2("Program29b8UYP", "merS123", 7)); //ProgrammerS123
    }
}
