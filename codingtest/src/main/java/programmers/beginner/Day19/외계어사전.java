package programmers.beginner.Day19;

import java.util.Arrays;

public class 외계어사전 {
    public int solution(String[] spell, String[] dic) {
        // 못찾는걸 기본으로
        int result = 2;
        Arrays.sort(spell);
        // join 기능 활용하기 이건 뜯어진 String 배열을 한 단어로 합쳐줌
        // 예를 들어서 String.join(", ", arr); 이런식이면 중간에 "A, B, C" 이렇게 합쳐짐
        String target = String.join("", spell);

        for(int i = 0; i < dic.length; i++){
            String[] c =  dic[i].split("");
            Arrays.sort(c);
            String target2 = String.join("",c);
            if(target.equals(target2)){
                result = 1;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        외계어사전 s = new 외계어사전();
        System.out.println(
                s.solution(new String[]{"p", "o", "s"}
                         , new String[]{"sod", "eocd", "qixm", "adio", "soo"}));// 2
        System.out.println(
                s.solution(new String[]{"z", "d", "x"}
                         , new String[]{"def", "dww", "dzx", "loveaw"}));// 1
        System.out.println(
                s.solution(new String[]{"s", "o", "m", "d"}
                        , new String[]{"moos", "dzx", "smm", "sunmmo", "som"}));// 2
    }
}
