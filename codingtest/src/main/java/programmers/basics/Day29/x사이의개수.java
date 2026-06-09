package programmers.basics.Day29;

import java.util.Arrays;

public class x사이의개수 {
    public int[] solution1(String myString) {
        // 1. split("x", -1) : 'x'를 기준으로 쪼개되,
        // 맨 뒤나 중간에 생기는 빈 문자열("") 찌꺼기까지 데이터 유실 없이 싹 다 살려서 배열로 만듦
        String[] arr = myString.split("x",-1);
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) result[i] = arr[i].length();
        return result;
    }

    public int[] solution2(String myString) {
        int count = 1;
        for(int i = 0; i < myString.length(); i++) if(myString.charAt(i) == 'x') count++;
        int[] result = new int[count];
        int index = 0;
        String temp = ""; // temp 변수는 for문 밖으로 대피!

        for(int i = 0; i < myString.length(); i++) {
            if(myString.charAt(i) != 'x') {
                temp += myString.charAt(i); // 'x'가 아니면 글자 모으기
            } else {
                result[index++] = temp.length(); // 'x'를 만나면 여태 모은 글자 길이를 담고
                temp = ""; // 다음 조각을 위해 청소!
            }
        }
        result[index] = temp.length(); // 🌟 4. [중요] for문 끝나고 남아있는 맨 마지막 조각 챙기기!

        return result;
    }
    public static void main(String[] args) {
        x사이의개수 s = new x사이의개수();
        System.out.println(Arrays.toString(s.solution1("oxooxoxxox"))); //1,2,1,0,1,0
        System.out.println(Arrays.toString(s.solution1("xabcxdefxghi")));//0,3,3,3
        System.out.println(Arrays.toString(s.solution2("oxooxoxxox"))); //1,2,1,0,1,0
        System.out.println(Arrays.toString(s.solution2("xabcxdefxghi")));//0,3,3,3
    }
}
