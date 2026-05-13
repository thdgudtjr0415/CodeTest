package programmers.basics.Day07;

public class 수조작하기 {
    public int solution(int n, String control) {
        int result = n;

        for(int i = 0; i < control.length();i++){
            char c = control.charAt(i);
            if(c == 'w'){
                result += 1;
            }else if(c=='s'){
                result -= 1;
            }else if(c =='d'){
                result += 10;
            }else if(c =='a'){
                result -= 10;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        수조작하기 s = new 수조작하기();
        System.out.println(s.solution(0, "wsdawsdassw")); //-1
    }
}
