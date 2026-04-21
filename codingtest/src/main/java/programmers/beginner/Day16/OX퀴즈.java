package programmers.beginner.Day16;

import java.util.Arrays;

public class OX퀴즈 {
    public String[] solution(String[] quiz) {
        String[] result = new String[quiz.length];

        for (int i = 0; i < quiz.length; i++) {
            String[] arr = quiz[i].split(" ");
            String operator = "+";
            int total = 0;
            for (int j = 0; j < arr.length; j++) {
                if(arr[j].equals("=")){
                    break;
                }else if(arr[j].equals("+") || arr[j].equals("-")) {
                    operator = arr[j];
                }else{
                    int n = Integer.parseInt(arr[j]);
//                    if(operator.equals("+")) {
//                        end += n;
//                    }else if(operator.equals("-")) {
//                        end -= n;
//                    }
//                    삼항연산자 사용 가능
                    total += operator.equals("+") ? n : -n;

                }
            }
            if(arr[arr.length-1].equals(String.valueOf(total))){
                result[i] = "O";
            }else {
                result[i] = "X";
            }
        }

        return result;
    }
    public static void main(String[] args) {
        OX퀴즈 s = new OX퀴즈();
        System.out.println(Arrays.toString(
                s.solution(new String[]{"3 - 4 = -3", "5 + 6 = 11"}))); // "X", "O"
        System.out.println(Arrays.toString(
                s.solution(new String[]{"19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"}))); // "O", "O", "X", "O"

    }
}
