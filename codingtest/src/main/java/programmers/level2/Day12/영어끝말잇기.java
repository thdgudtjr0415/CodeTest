package programmers.level2.Day12;

import java.util.Arrays;
import java.util.HashSet;

public class 영어끝말잇기 {
    public int[] solution1(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        set.add(words[0]); // 첫글자 집어넣기
        int idx = 0; // 어짜피 첫번재 순서가 틀릴 수는 없으니 넘어가기
        int personNum = 0; // 사람 순서
        boolean flag = true;
        for(int i = 1; i < words.length; i++){
            personNum = (i % n) + 1;
            char c = words[i-1].charAt(words[i-1].length() - 1);
//             이전에 단어가 나왔는지 체크
            if(!set.contains(words[i])){
                set.add(words[i]);
            }else {
                flag = false;
                idx = i;
                break;
            }
//             이전 글자의 마지막과 다음 글자의 첫 글자가 같은 지 체크
            if(!(c == words[i].charAt(0))){
                flag = false;
                idx = i;
                break;
            }
        }
        if(flag) return new int[]{0, 0};
        return new int[]{personNum, idx/n + 1};
    }

    public int[] solution2(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        set.add(words[0]); // 첫글자 집어넣기
        for(int i = 1; i < words.length; i++){
            char c = words[i-1].charAt(words[i-1].length() - 1);
            if(set.contains(words[i]) || !(c == words[i].charAt(0))){
                return new int[]{(i % n) + 1, i/n + 1};
            }
            set.add(words[i]);

        }
        return new int[]{0,0};
    }
    public static void main(String[] args){
        영어끝말잇기 s = new 영어끝말잇기();
        System.out.println(Arrays.toString(s.solution1(3,
                new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}))); //3,3
        System.out.println(Arrays.toString(s.solution1(5,
                new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"}))); //0,0
        System.out.println(Arrays.toString(s.solution1(2,
                new String[]{"hello", "one", "even", "never", "now", "world", "draw"}))); //1,3

        System.out.println(Arrays.toString(s.solution2(3,
                new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}))); //3,3
        System.out.println(Arrays.toString(s.solution2(5,
                new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"}))); //0,0
        System.out.println(Arrays.toString(s.solution2(2,
                new String[]{"hello", "one", "even", "never", "now", "world", "draw"}))); //1,3
    }
}
