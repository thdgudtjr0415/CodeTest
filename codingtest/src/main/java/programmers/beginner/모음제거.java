package programmers.beginner;

public class 모음제거 {
    public String solution(String my_string) {
        String result = "";
        // 아래의 둘다 공백 포함해서 배열로 만드는것 하지만 이 문제 배열 필요 없을듯
//        char[] arr = my_string.toCharArray();
//        String[] arr = my_string.split("");

        for(int i = 0; i < my_string.length(); i++){
            char a = my_string.charAt(i);
            if(a != 'a' && a != 'e' && a != 'i' && a != 'o' && a != 'u'){
                result += a;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        모음제거 s = new 모음제거();
        System.out.println(s.solution("bus")); // bs
        System.out.println(s.solution("nice to meet you")); // nc t mt y
    }
}
