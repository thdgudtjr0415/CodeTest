package programmers.basics.Day07;

public class 수조작하기_02 {
    public String solution(int[] numLog) {
        String result = "";

        for(int i=1;i<numLog.length;i++){
            if(numLog[i]-numLog[i-1] == 1){
                result += "w";
            }else if(numLog[i]-numLog[i-1] == -1){
                result += "s";
            }else if(numLog[i]-numLog[i-1] == 10){
                result += "d";
            }else  if(numLog[i]-numLog[i-1] == -10){
                result += "a";
            }
        }
        return result;
    }
    public static void main(String[] args) {
        수조작하기_02 s = new 수조작하기_02();
        System.out.println(s.solution(new int[]{0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1})); // wsdawsdassw
    }
}
