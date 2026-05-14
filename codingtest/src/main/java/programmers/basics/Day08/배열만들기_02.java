package programmers.basics.Day08;

import java.util.ArrayList;
import java.util.Arrays;

public class 배열만들기_02 {
    public int[] solution(int l, int r) {
        // 정답 숫자가 몇 개일지 모르니까 일단 가변 리스트(ArrayList) 준비함
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = l; i <= r; i++){
            String num = String.valueOf(i);
            // boolean으로 체크하기, true면 list에 넣을 예정
            boolean isOk = true;
            for(int j = 0; j < num.length(); j++){
                char c = num.charAt(j);
                // 만약 5도 아니고 0도 아닌 글자가 하나라도 섞여 있으면
                if(c != '5' && c != '0'){
                    isOk = false; // "너 탈락!" 깃발 내림
                    break;
                }
            }
            // 검사 다 끝났는데 깃발이 여전히 true면 진짜 정답이니까 리스트에 넣음
            if(isOk){
                list.add(i);
            }
        }
        // 싹 다 뒤졌는데 리스트가 비어있으면 -1 담아서 리턴함
        if(list.isEmpty()){
            return new int[]{-1};
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args){
        배열만들기_02 s = new 배열만들기_02();
        System.out.println(Arrays.toString(s.solution(5, 555)));
        System.out.println(Arrays.toString(s.solution(10, 20)));
    }
}