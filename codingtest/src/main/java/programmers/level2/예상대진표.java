package programmers.level2;

public class 예상대진표 {
    public int solution1(int n, int a, int b) {
        int round = 0;
        while(a != b){
            if(a%2 == 0){
                a/=2;
            }else {
                a = (a+1)/2;
            }
            if(b%2 == 0){
                b/=2;
            }else {
                b = (b+1)/2;
            }
            round++;
        }
        return round;
    }
    public int solution2(int n, int a, int b) {
        int round = 0;
        while(a != b){
                a = (a+1)/2;
                b = (b+1)/2;
            round++;
        }
        return round;
    }

    public static void main(String[] args){
        예상대진표 s = new 예상대진표();
        System.out.println(s.solution1(8,4,7)); //3
        System.out.println(s.solution2(8,4,7)); //3
    }
}
