package programmers.level1.Day08;

public class 최소직사각형 {
    public int solution1(int[][] sizes) {
        int[] arrMax = new int[sizes.length];
        int[] arrMin = new int[sizes.length];
        for(int i = 0; i < sizes.length; i++){
            int a = sizes[i][0];
            int b = sizes[i][1];
            arrMax[i] = Math.max(a,b);
            arrMin[i] = Math.min(a,b);
        }
        int arrMaxMax = 0;
        int arrMinMax = 0;
        for(int i = 0; i < sizes.length; i++){
            if(arrMax[i] > arrMaxMax){
                arrMaxMax = arrMax[i];
            }
            if(arrMin[i] > arrMinMax){
                arrMinMax = arrMin[i];
            }
        }
        return arrMaxMax*arrMinMax;
    }
    // 클린 코드 기준
    public int solution2(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;
        for(int i = 0; i < sizes.length; i++){
            int width = sizes[i][0];
            int height = sizes[i][1];
            int currentWidthMax = Math.max(width, height);
            int currentHeightMin = Math.min(width, height);
            if(currentWidthMax > maxWidth){
                maxWidth = currentWidthMax;
            }
            if(currentHeightMin > maxHeight){
                maxHeight = currentHeightMin;
            }
        }
        return maxWidth*maxHeight;
    }
    public static void main(String[] args){
        최소직사각형 s = new 최소직사각형();
        System.out.println(s.solution1(new int[][]{{60,50},{30,70},{60,30},{80,40}})); //4000
        System.out.println(s.solution1(new int[][]{{10,7},{12,3},{8,15},{14,7},{5,15}})); // 120
        System.out.println(s.solution1(new int[][]{{14,4},{19,6},{6,16},{18,7},{7,11}}));// 133

        System.out.println(s.solution2(new int[][]{{60,50},{30,70},{60,30},{80,40}})); //4000
        System.out.println(s.solution2(new int[][]{{10,7},{12,3},{8,15},{14,7},{5,15}})); // 120
        System.out.println(s.solution2(new int[][]{{14,4},{19,6},{6,16},{18,7},{7,11}}));// 133
    }
}
