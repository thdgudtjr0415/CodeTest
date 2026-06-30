package programmers.level1.Day11;

import java.util.Arrays;

// 여기서는 비트연산자 | 를 쓴 것과 일반적으로 푼것 두개를 비교하기

public class 카카오비밀지도 {
    public String[] solution1(int n, int[] arr1, int[] arr2) {
        String[] 출력 = new String[n];
        for(int i = 0; i < n; i++){
            String result = "";
            int a = arr1[i];
            int b = arr2[i];
            String aBinary = Integer.toString(a,2);
            String bBinary = Integer.toString(b,2);
                while(aBinary.length() < n){
                    aBinary = "0" + aBinary;
                }
                while(bBinary.length() < n){
                    bBinary = "0" + bBinary;
                }
            for(int j = 0; j < n; j++){
                if(aBinary.charAt(j) == '1' || bBinary.charAt(j) == '1'){
                    result += "#";
                }else {
                    result += " ";
                }
            }
            출력[i] = result;
        }
        return 출력;
    }
    public String[] solution2(int n, int[] arr1, int[] arr2) {
        String[] 출력 = new String[n];
        for(int i = 0; i < n; i++){
            int a = arr1[i];
            int b = arr2[i];
            // 여기서 비트연산자 | 를 써서 둘중 누구라도 1이면 1인것인데 여기서
            // int로 비교하던 이진수로 두수를 비교하던 답은 똑같음
            String cBinary = Integer.toString(a | b,2);
            while(cBinary.length() < n){
                cBinary = "0" + cBinary;
            }
            cBinary = cBinary.replace("1","#").replace("0"," ");
            출력[i] = cBinary;
        }
        return 출력;
    }
    public static void main(String[] args){
        카카오비밀지도 s = new 카카오비밀지도();
        System.out.println(Arrays.toString(s.solution1(5, new int[]{9,20,28,18,11},
                new int[]{30,1,21,17,28}))); //["#####","# # #", "### #", "# ##", "#####"]
        System.out.println(Arrays.toString(s.solution1(6, new int[]{46,33,33,22,31,50},
                new int[]{27,56,19,14,14,10}))); //	["######", "### #", "## ##", " #### ", " #####", "### # "]

        System.out.println(Arrays.toString(s.solution2(5, new int[]{9,20,28,18,11},
                new int[]{30,1,21,17,28}))); //["#####","# # #", "### #", "# ##", "#####"]
        System.out.println(Arrays.toString(s.solution2(6, new int[]{46,33,33,22,31,50},
                new int[]{27,56,19,14,14,10}))); //	["######", "### #", "## ##", " #### ", " #####", "### # "]
    }
}
