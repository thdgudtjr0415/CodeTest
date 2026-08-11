package programmers.level2.Day01;

// 최솟값 + " " + 최댓값 으로 하면 됨

public class 최댓값과최솟값 {
    public String solution(String s) {
        int maxInt = Integer.MIN_VALUE;
        int minInt = Integer.MAX_VALUE;
        String[] arr = s.split(" ");
        int[] intarr = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            int num = Integer.parseInt(arr[i]);
            intarr[i] = num;
        }
        for(int i = 0; i < arr.length; i++){
            if(intarr[i] > maxInt){
                maxInt = intarr[i];
            }
            if(intarr[i] < minInt){
                minInt = intarr[i];
            }
        }
        return minInt + " " + maxInt;
    }
    public static void main(String[] args) {
        최댓값과최솟값 s = new 최댓값과최솟값();
        System.out.println(s.solution("1 2 3 4")); //"1 4"
        System.out.println(s.solution("-1 -2 -3 -4")); //"-4 -1"
        System.out.println(s.solution("-1 -1")); //"-1 -1"
    }
}
