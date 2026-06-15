package programmers.basics.Day35;

import java.util.Arrays;

public class 그림확대 {
    public String[] solution(String[] picture, int k) {
        String[] result = new String[picture.length*k];
        for(int i = 0; i < picture.length; i++){
            String pictureIdx = picture[i];
            String temp = "";
            // 각 인덱스 배수 한것
            for(int j = 0; j < pictureIdx.length(); j++){
                for(int l = 0; l < k; l++) temp += pictureIdx.charAt(j);
            }
            for(int j = 0; j < k; j++){
                result[i*k+j] = temp;
            }
        }
        return result;
    }
    public static void main(String[] args){
        그림확대 s = new 그림확대();
        System.out.println(Arrays.toString(s.solution(new String[]{".xx...xx.", "x..x.x..x", "x...x...x", ".x.....x.", "..x...x..", "...x.x...", "....x...."}, 2)));
        System.out.println(Arrays.toString(s.solution(new String[]{"x.x", ".x.", "x.x"}, 3)));
    }
}
