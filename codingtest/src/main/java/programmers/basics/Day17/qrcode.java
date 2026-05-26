package programmers.basics.Day17;

public class qrcode {
    public String solution(int q, int r, String code) {
        String result = "";
        for(int i = r; i < code.length(); i += q){
            result += code.charAt(i);
        }
        return result;
    }
    public static void main(String[] args) {
        qrcode s = new qrcode();
        System.out.println(s.solution(3,1,"qjnwezgrpirldywt")); //jerry
        System.out.println(s.solution(1,0,"programmers")); // programmers
    }
}
