package programmers.beginner;

public class 삼육구게임 {
    public int solution1(int order) {
        int result = 0;
        // 방법1 숫자를 배열로 치환해서 각 i 번쨰가 3,6,9라면 count++ 하는 방식
        String[] arr = String.valueOf(order).split("");

        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals("3") || arr[i].equals("6") || arr[i].equals("9")){
                result++;
            }
        }
        return result;
    }
    public int solution2(int order) {
        int result = 0;
        // 방법2 이건 바로 string에서 사용하는 것
        String s = String.valueOf(order);
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '3' || c == '6' || c == '9'){
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        삼육구게임 s = new 삼육구게임();
        System.out.println(s.solution1(3));
        System.out.println(s.solution1(29423));
        System.out.println(s.solution2(3));
        System.out.println(s.solution2(29423));
    }
}
