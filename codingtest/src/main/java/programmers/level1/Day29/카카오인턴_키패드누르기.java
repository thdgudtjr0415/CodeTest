package programmers.level1.Day29;

// 처음 시작은 왼손*, 오른손#
// 손가락은 상하좌우만 가능, 왼쪽 147 키패드는 왼손만, 오른쪽 369는 오른손
// 가운데 2580을 칠때는 두 엄지손가락의 현재 위치에서 가까운 손가락으로 사용
// 거리가 가까우면 String hand에 오른손잡이인지 왼손잡이인지 확인 가능


public class 카카오인턴_키패드누르기 {
    public String solution(int[] numbers, String hand) {
        String result = "";
        // 임시로 *은 10, #은 11
        int[][] keypads = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,0,11}
        };
        // 시작 위치
        int[] Lidx = {3,0}; // 왼손 시작 인덱스
        int[] Ridx = {3,2}; // 오른손 시작 인덱스

        for(int i = 0; i < numbers.length; i++){
            int n =  numbers[i];
            if(n == 1 || n == 4 || n == 7 ){
                result += "L";
                for(int j = 0; j < keypads.length; j++){
                    for(int k = 0; k < keypads[j].length; k++){
                        if(keypads[j][k] == n){
                            Lidx[0] = j;
                            Lidx[1] = k;
                        }
                    }
                }
            }else  if(n == 3 || n == 6 || n == 9){
                result += "R";
                for(int j = 0; j < keypads.length; j++){
                    for(int k = 0; k < keypads[j].length; k++){
                        if(keypads[j][k] == n){
                            Ridx[0] = j;
                            Ridx[1] = k;
                        }
                    }
                }
            // 거리 구해서 맞추기
            }else {
                int[] numIndex = new int[2];
                for(int j = 0; j < keypads.length; j++){
                    for(int k = 0; k < keypads[j].length; k++){
                        if(keypads[j][k] == n){
                            numIndex[0] = j;
                            numIndex[1] = k;
                        }
                    }
                }
                // 음수 나올 수 도 있음 조심, 더한 후 절댓값 → 음수끼리 상쇄될 수 있음!
                int Ldis = Math.abs((Lidx[0] - numIndex[0])) + Math.abs((Lidx[1] - numIndex[1]));
                int Rdis = Math.abs((Ridx[0] - numIndex[0])) + Math.abs((Ridx[1] - numIndex[1]));
                if(Ldis > Rdis){
                    result += "R";
                    Ridx = numIndex;
                }else  if(Rdis > Ldis){
                    result += "L";
                    Lidx = numIndex;
                }else {
                    // String 이니가 equals
                    if(hand.equals("right")){
                        result += "R";
                        // 업데이트 추가
                        Ridx = numIndex;
                    }else if(hand.equals("left")){
                        result += "L";
                        // 업데이트 추가
                        Lidx = numIndex;
                    }
                }
            }
        }
        return result;
    }
//    public static
    public static void main(String[] args) {
        카카오인턴_키패드누르기 s = new 카카오인턴_키패드누르기();
        System.out.println(s.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},
                "right")); //LRLLLRLLRRL
        System.out.println(s.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},
                "left")); //LRLLRRLLLRR
        System.out.println(s.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                "right")); //LLRLLRLLRL
    }

}
