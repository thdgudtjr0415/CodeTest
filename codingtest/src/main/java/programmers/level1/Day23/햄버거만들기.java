package programmers.level1.Day23;

import java.util.ArrayList;

public class 햄버거만들기 {
    public int solution(int[] ingredient) {
        ArrayList<Integer> list = new ArrayList<>();
        int result = 0;
        for(int i = 0; i < ingredient.length; i++){
            list.add(ingredient[i]);
            if(list.size() >= 4){
                if(list.get(list.size()-1) == 1 &&
                    list.get(list.size()-2) == 3 &&
                    list.get(list.size()-3) == 2 &&
                    list.get(list.size()-4) == 1){
                    result++;
                    // 어짜피 4씩 지워줘야함 저렇게 조건이 통과되면 그럼 subList 처럼 한번에 지워주느게 필요
//                    list.remove(list.size()-1);
//                    list.remove(list.size()-1);
//                    list.remove(list.size()-1);
//                    list.remove(list.size()-1);
                    list.subList(list.size()-4, list.size()).clear(); //위에 4줄이랑 같음
                }
            }
        }

        return result;
    }
    public static void main(String[] args){
        햄버거만들기 s = new 햄버거만들기();
        System.out.println(s.solution(new int[]{2,1,1,2,3,1,2,3,1})); //2
        System.out.println(s.solution(new int[]{1,3,2,1,2,1,3,1,2})); //0
    }
}
