package programmers.level1.Day34;

// -1 에서 시작해서 돗자리 정사각형 amts[i]이 되는지 확인해야함 즉 이차원배열에서 가로세로 다 확인
// 반문 돌릴 예정인데, 메트의 크기부터 시작하여 -1이 나오면 거기서 부터 돗자리를 깔수 있는지 확인
public class 공원_01 {
    public int solution(int[] mats, String[][] park) {
        int result = -1;
        // 내림 차순 정렬 큰제일 큰 것을 깔 수 있는지 확인해야하니까
        for(int i = 0; i < mats.length; i++){
            for(int j = i+1; j < mats.length; j++){
                if(mats[i] < mats[j]){
                    int temp = mats[i];
                    mats[i] = mats[j];
                    mats[j] = temp;
                }
            }
        }
        // 코드 간편화
        int row = park.length;
        int col = park[0].length;

        // check 시작
        for(int i = 0; i < mats.length; i++) {
            int matLen = mats[i];
            // -matLen 하는 이유는 ArrayOutOfIndex 때문에
            for(int j = 0; j+matLen-1 < row; j++) {
                for(int k = 0; k+matLen-1 < col; k++) {
                    if(park[j][k].equals("-1")){
                        boolean check = true;
                        // 여기에 반복문에 라벨 다는 것이 있는데 이거 꿀팁
                        mats:
                        for(int l = 0; l < matLen; l++) {
                            for(int m = 0; m < matLen; m++) {
                                if(!(park[j+l][k+m].equals("-1"))){
                                    check = false;
                                    break mats;
                                }
                            }
                        }
                        if(check){
                            return matLen;
                        }
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        공원_01 s = new 공원_01();
        System.out.println(s.solution(new int[]{5,3,2},
                new String[][]{
                        {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                        {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                        {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                        {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                        {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                        {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}}));  //3
    }
}
