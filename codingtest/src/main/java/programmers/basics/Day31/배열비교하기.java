package programmers.basics.Day31;

public class 배열비교하기 {
    public int solution(int[] arr1, int[] arr2) {
        int result = 0;
        int a1 = 0;
        int a2 = 0;
        for (int i = 0; i < arr1.length; i++) a1 += arr1[i];
        for (int i = 0; i < arr2.length; i++) a2 += arr2[i];

        if(arr1.length > arr2.length){
            return 1;
        }else if(arr1.length < arr2.length) {
            return -1;
        }else if(arr1.length == arr2.length) {
            if(a1 > a2) return 1;
            else if(a1 < a2) return -1;
            else return 0;
        }
        return result;
    }
    public static void main(String[] args) {
        배열비교하기 s = new 배열비교하기();
        System.out.println(s.solution(new int[]{49,13}, new int[]{70,11,2})); //-1
        System.out.println(s.solution(new int[]{100,17,84,1}, new int[]{55,12,65,36}));//1
        System.out.println(s.solution(new int[]{1,2,3,4,5}, new int[]{3,3,3,3,3}));//0
    }
}
