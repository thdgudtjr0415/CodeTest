package programmers.level2.Day05;

import java.util.Arrays;

// brown은 8이상 5천 이하
// yellow는 1이상 2백만 이하
// 가운데 카펫 노란 영역은 (가로-2) * (세로-2) 하면 됨

public class 카펫 {
    public int[] solution1(int brown, int yellow) {
        int[] answer = {};
        int sum = brown + yellow;
        int count = 0;
        for(int i = 1; i <= brown/2; i++){
            for(int j = brown/2; j > 0; j--){
                if(i*j == sum && i >= j){
                    count++;
                }
            }
        }
        int idx = 0;
        int[][] carpetType = new int[count][2];
        for(int i = 1; i <= brown/2; i++){
            for(int j = brown/2; j > 0; j--){
                if(i*j == sum && i >= j){
                    carpetType[idx][0] = i;
                    carpetType[idx][1] = j;
                    idx++;
                }
            }
        }
        for(int i = 0; i < count; i++){
            if((carpetType[i][0]-2) * (carpetType[i][1]-2) == yellow){
                answer = new int[]{carpetType[i][0], carpetType[i][1]};
            }
        }
        return answer;
    }
    public int[] solution2(int brown, int yellow) {
        // 여기서 세로는 가로보다 같거나 작다를 이용
        // 여기 수식은 가로 * 세로 = sum // 가로 * 세로 >= 세로 * 세로 를 적용 그럼 sum >= 세로의 제곱 이 나옴
        int[] answer = {};
        int sum = brown + yellow;
        for(int height = 1; height * height <= sum; height++){
            if(sum % height == 0){
                int widht = sum / height;
                if((widht-2) * (height-2) == yellow){
                    answer = new int[]{widht, height};
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        카펫 s = new 카펫();
        System.out.println(Arrays.toString(s.solution1(10,2))); //4,3
        System.out.println(Arrays.toString(s.solution1(8,1))); //3,3
        System.out.println(Arrays.toString(s.solution1(24,24))); // 8,6
        System.out.println(Arrays.toString(s.solution2(10,2))); //4,3
        System.out.println(Arrays.toString(s.solution2(8,1))); //3,3
        System.out.println(Arrays.toString(s.solution2(24,24))); // 8,6
    }
}
