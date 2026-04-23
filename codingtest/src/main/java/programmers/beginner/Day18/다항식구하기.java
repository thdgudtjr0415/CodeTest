package programmers.beginner.Day18;

public class 다항식구하기 {
    public String solution(String polynomial) {
        String result = "";
        String[] arr = polynomial.split(" ");
        // x 갯수 들어갈 자리
        int a = 0;
        // 일반 숫자
        int b = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i].contains("x")){
                if(arr[i].equals("x")){
                    a++;
                }else{
                    a += Integer.parseInt(arr[i].replace("x",""));
                }
            }else if(arr[i].equals("+")){
                continue;
            }
            else{
                b += Integer.parseInt(arr[i]);
            }
        }
        // 출력 경우의 수 다 생각하기
        if (a > 0 && b > 0) {
            if (a == 1) {
                result = "x + " + b;
            } else {
                result = a + "x + " + b;
            }
        } else if (a > 0) { // x항만 있을 때 (b가 0일 때)
            if (a == 1) {
                result = "x";
            } else {
                result = a + "x"; // 놓쳤던 '2x', '3x'
            }
        } else { // x항이 없을 때 (a가 0일 때)
            result = b + "";
        }

        return result;
    }
    public static void main(String args[]){
        다항식구하기 s = new 다항식구하기();
        System.out.println(s.solution("3x + 7 + x")); // "4x + 7"
        System.out.println(s.solution("x + x + x")); // "3x"
    }
}
