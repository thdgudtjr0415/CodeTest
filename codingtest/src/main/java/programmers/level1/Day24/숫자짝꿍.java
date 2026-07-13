package programmers.level1.Day24;


public class 숫자짝꿍 {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        String result = "";
        int[] countX = new int[10];
        int[] countY = new int[10];
        for(int i = 0; i < X.length(); i++) {
            countX[X.charAt(i)-'0']++;
        }
        for(int i = 0; i < Y.length(); i++) {
            countY[Y.charAt(i)-'0']++;
        }

        for(int i = countX.length -1; i >= 0; i--) {
            if(countX[i] >= 1 && countY[i] >= 1) {
                int countMin = Math.min(countX[i], countY[i]);
                for(int j = 0; j < countMin; j++) {
                    sb.append(i);
                }
            }
        }
        if(sb.length() == 0) {
            return "-1";
        }else if(sb.charAt(0) == '0'){
            return "0";
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        숫자짝꿍 s = new 숫자짝꿍();
        System.out.println(s.solution("100","2345")); // -1
        System.out.println(s.solution("100","203045")); //0
        System.out.println(s.solution("100","123450")); //10
        System.out.println(s.solution("12321","42531")); //321
        System.out.println(s.solution("5525","1255")); //552
    }
}
