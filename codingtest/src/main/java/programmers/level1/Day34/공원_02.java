package programmers.level1.Day34;

// 이번꺼는 메서드 분리 방법

public class 공원_02 {
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
            for(int j = 0; j+matLen-1 < row; j++) {
                for(int k = 0; k+matLen-1 < col; k++) {
                    if(checkPark(park, j, k, matLen)){
                        return matLen;
                    }
                }
            }
        }
        return result;
    }

    // 여기 메서드는 값을 받아왔을때 mat를 깔았을 경우 된다면 true, 안된다면 false를 반환하는 메서드
    private boolean checkPark(String[][] park, int parkRow, int parkCol, int matLen) {
        if(!park[parkRow][parkCol].equals("-1")){
            return false;
        }
            for(int i = 0; i < matLen; i++){
                for(int j = 0; j < matLen; j++){
                    if(!(park[parkRow+i][parkCol+j].equals("-1"))){
                        return false;
                    }
                }
            }
        return true;
    }

    public static void main(String[] args) {
        공원_02 s = new 공원_02();
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
