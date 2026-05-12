package programmers.basics.Day06;

public class 이어붙인수 {
    public int solution(int[] num_list) {
        int result = 0;
        String odd = "";
        String even = "";

        for(int i = 0; i < num_list.length; i++){
            if(num_list[i] % 2 == 0){
                even += num_list[i]+"";
            }else if(num_list[i] % 2 != 0){
                odd += num_list[i]+"";
            }
        }
        result = Integer.parseInt(even)+Integer.parseInt(odd);
        return result;
    }

    //for문
    //int[] scores = {90, 80, 100};
    //for (int i = 0; i < scores.length; i++) {
    //    System.out.println(scores[i]); // 인덱스(i)를 통해 접근
    //}
    //향상된 for문
    //int[] scores = {90, 80, 100};
    //for (int score : scores) { // scores 배열에서 하나씩 꺼내 score 변수에 담음
    //    System.out.println(score); // 바로 값에 접근
    //}
    //for (데이터타입 변수명 : 배열_또는_리스트) {
    //    // 반복해서 실행할 코드
    //}


    public static void main(String[] args) {
        이어붙인수 s = new 이어붙인수();
        System.out.println(s.solution(new int[]{3,4,5,2,1})); //393
        System.out.println(s.solution(new int[]{5,7,8,3})); //581
    }
}
