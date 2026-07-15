package programmers.level1.Day25;

import java.util.Arrays;

public class 데이터분석 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int count = 0;
        String[] words = {"code", "date", "maximum", "remain"};
        // 변수 두개 생성해서 비교해서 저장할 인덱스, 정렬에 사용할 인덱스 저장
        int extInt = 0;
        int sort_byInt = 0;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(ext)) extInt = i;
            if(words[i].equals(sort_by)) sort_byInt = i;
        }
        // 배열 길이 구하기
        for(int j = 0; j < data.length; j++){
            if(data[j][extInt] < val_ext){
                count++;
            }
        }
        int[][] result = new int[count][4];
        int idx = 0;
        for(int i = 0; i < data.length; i++){
            if(data[i][extInt] < val_ext){
                for(int j = 0 ; j < 4; j++){
                    result[idx][j] = data[i][j];
                }
                idx++; // 이부분 헷갈렸음, idx++ 할때 하나 요소 하나 찾고 올리는게 아니라 행 자체가 끝나고 올려야함
            }
        }
        // 오름차순 선택정렬
        for(int i = 0; i < result.length; i++){
            for(int j = i+1; j < result.length; j++){
                if(result[i][sort_byInt] > result[j][sort_byInt]){
                    int[] temp = result[j];
                    result[j] = result[i];
                    result[i] = temp;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        데이터분석 s = new 데이터분석();
        System.out.println(Arrays.deepToString(s.solution(
                new int[][]{{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}},
                "date", 20300501, "remain"))); // [[3,20300401,10,8],[1,20300104,100,80]]
    }
}
