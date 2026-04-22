package programmers.beginner.Day17;

public class 칠의개수 {
    public int solution(int[] array) {
        int result = 0;
        // 트레이드오프 -> 7의 갯수를 세려면 각 배열의 각 원소들을 또 배열로 만들어서 수를 세보자
        for(int i = 0; i < array.length; i++){
            String[] arr = String.valueOf(array[i]).split("");
            for(int j = 0; j < arr.length; j++){
                if(arr[j].equals("7")){
                    result++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        칠의개수 s = new 칠의개수();
        System.out.println(s.solution(new int[]{7, 77, 17})); // 4
        System.out.println(s.solution(new int[]{10, 29})); // 0
    }
}
