package programmers.level1.Day12;

import java.util.Arrays;
import java.util.HashMap;

public class 추억점수 {
    // 일반 반복문으로 풀기
    public int[] solution1(String[] name, int[] yearning, String[][] photo) {
        int[] result = new int[photo.length];
        for(int i = 0; i < photo.length; i++){
            int sum = 0;
            for(int j = 0; j < photo[i].length; j++) {
                String photoName = photo[i][j];
                for(int k = 0; k < name.length; k++){
                    if(photoName.equals(name[k])) {
                        sum += yearning[k];
                    }
                }
            }
            result[i] = sum;
        }
        return result;
    }

    // haspmap으로 풀기, hashmap은 일단 정보입력이 되면 주머니 안에 무질서하게 들어가 있음 키랑 밸류가 같이 있으니 순서가 무의미
    public int[] solution2(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < name.length; i++){
            hashMap.put(name[i],yearning[i]);
        }
        int[] result = new int[photo.length];
        for(int i = 0; i < photo.length; i++){
            int sum = 0;
            for(int j = 0; j < photo[i].length; j++){
                String photoName = photo[i][j];
                if(hashMap.containsKey(photoName)){
//                    sum += hashMap.get(photoName); // 이게 맞긴 한데
                    // 아래는 평소대로 get으로 불러오는데 없는 주머니 이면 에러 내지 말고 0 으로
                    // 즉 예외처리하는거임
                    sum += hashMap.getOrDefault(photoName, 0);
                }
            }
            result[i] = sum;
        }
        return result;
    }
    public static void main(String[] args) {
        추억점수 s = new 추억점수();

        System.out.println("예제 1번 정답: " + Arrays.toString(s.solution1(
                new String[]{"may", "kein", "kain", "radi"},
                new int[]{5, 10, 1, 3},
                new String[][]{
                        {"may", "kein", "kain", "radi"},
                        {"may", "kein", "brin", "deny"},
                        {"kon", "kain", "may", "coni"}
                }
        ))); // 기대값: [19, 15, 6]

        System.out.println("예제 2번 정답: " + Arrays.toString(s.solution1(
                new String[]{"kali", "mari", "don"},
                new int[]{11, 1, 55},
                new String[][]{
                        {"kali", "mari", "don"},
                        {"pony", "tom", "teddy"},
                        {"con", "mona", "don"}
                }
        ))); // 기대값: [67, 0, 55]

        System.out.println("예제 3번 정답: " + Arrays.toString(s.solution1(
                new String[]{"may", "kein", "kain", "radi"},
                new int[]{5, 10, 1, 3},
                new String[][]{
                        {"may"},
                        {"kein", "deny", "may"},
                        {"kon", "coni"}
                }
        ))); // 기대값: [5, 15, 0]


        System.out.println("예제 1번 정답: " + Arrays.toString(s.solution2(
                new String[]{"may", "kein", "kain", "radi"},
                new int[]{5, 10, 1, 3},
                new String[][]{
                        {"may", "kein", "kain", "radi"},
                        {"may", "kein", "brin", "deny"},
                        {"kon", "kain", "may", "coni"}
                }
        ))); // 기대값: [19, 15, 6]

        System.out.println("예제 2번 정답: " + Arrays.toString(s.solution2(
                new String[]{"kali", "mari", "don"},
                new int[]{11, 1, 55},
                new String[][]{
                        {"kali", "mari", "don"},
                        {"pony", "tom", "teddy"},
                        {"con", "mona", "don"}
                }
        ))); // 기대값: [67, 0, 55]

        System.out.println("예제 3번 정답: " + Arrays.toString(s.solution2(
                new String[]{"may", "kein", "kain", "radi"},
                new int[]{5, 10, 1, 3},
                new String[][]{
                        {"may"},
                        {"kein", "deny", "may"},
                        {"kon", "coni"}
                }
        ))); // 기대값: [5, 15, 0]
    }
}