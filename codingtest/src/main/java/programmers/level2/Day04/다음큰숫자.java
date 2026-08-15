package programmers.level2.Day04;

public class 다음큰숫자 {
    public int solution(int n) {
        int result = 0;
        String curNum = Integer.toString(n,2);
        int oneCount = 0;
        for(int i = 0; i < curNum.length(); i++){
            if(curNum.charAt(i) == '1') oneCount++;
        }
        int i = 1;
        int nextOneCount = 0;
        while(true){
            int next = 0;
            String nextNum = Integer.toString(n+i,2);
            for(int j = 0; j < nextNum.length(); j++){
                if(nextNum.charAt(j) == '1') nextOneCount++;
            }
            if(nextOneCount == oneCount){
                return n+i;
            }else {
                i++;
                nextOneCount = 0;
            }

        }
//        return result;
    }
    public static void main(String[] args) {
        다음큰숫자 s = new 다음큰숫자();
        System.out.println(s.solution(78)); //83
        System.out.println(s.solution(15)); //23
    }
}
