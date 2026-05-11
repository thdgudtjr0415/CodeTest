package programmers.basics.Day05;


public class 등차수열의특정한항만더하기 {
    public int solution(int a, int d, boolean[] included) {
        int result = 0;
        int arr[] = new int[included.length];
        for(int i=0;i<included.length;i++){
            arr[i] = a + d*i;
        }

        for(int i = 0;i<included.length;i++){
            if(included[i] == true){
                result +=  arr[i];
            }
        }
        return result;
    }
    public static void main(String[] args){
        등차수열의특정한항만더하기 s = new 등차수열의특정한항만더하기();
        System.out.println(s.solution(3,4,
                new boolean[]{true, false, false, true, true})); // 37
        System.out.println(s.solution(7,1,
                new boolean[]{false, false, false, true, false, false, false})); // 10
    }
}
