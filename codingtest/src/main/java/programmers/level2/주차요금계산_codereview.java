package programmers.level2;

import java.util.*;

/*
 * 주차 요금 계산 (프로그래머스 92341)
 *
 * [풀이 흐름]
 * 1. sumParkingMinutes : records를 읽어 차량별 누적 주차 시간(분)을 만든다.
 *    - IN  이면 입차 시각을 inMap(차량번호, 입차 시각)에 저장한다.
 *    - OUT 이면 (출차 시각 - 입차 시각)을 resultMap(차량번호, 누적 시간)에 더하고
 *              inMap에서 그 차량을 지운다. (한 차가 여러 번 들락날락할 수 있어서 누적)
 *    - 다 돌고 inMap에 남은 차는 23:59(1439분)에 출차한 것으로 보고 같은 방식으로 더한다.
 * 2. 차량번호 오름차순으로 순회하면서 calcFee로 요금을 계산한다.
 *    - 누적 시간이 기본 시간 이하면 기본 요금
 *    - 초과하면 기본 요금 + 올림((누적 시간 - 기본 시간) / 단위 시간) * 단위 요금
 *
 * [정렬 방법 2가지]
 * - solution1 : TreeMap에 담아서 키(차량번호) 순서로 정렬
 * - solution2 : keySet을 ArrayList에 담고 Collections.sort로 정렬
 *
 * [주의할 점]
 * - 올림은 나눗셈 전에 double로 바꿔서 Math.ceil 해야 한다. (int끼리 나누면 소수점이 버려짐)
 * - 초과 시간이 음수면 0으로 처리한다. (Math.max(0, ...))
 */
public class 주차요금계산_codereview {

    private static final int LAST_MINUTE = 23 * 60 + 59; // 23:59 = 1439분

    // 정렬 방법 1 : TreeMap
    public int[] solution1(int[] fees, String[] records) {
        Map<String, Integer> resultMap = new TreeMap<>(sumParkingMinutes(records));

        int[] answer = new int[resultMap.size()];
        int idx = 0;
        for (int min : resultMap.values()) { // TreeMap이라 차량번호 순서대로 나옴
            answer[idx++] = calcFee(min, fees);
        }
        return answer;
    }

    // 정렬 방법 2 : HashMap + Collections.sort
    public int[] solution2(int[] fees, String[] records) {
        Map<String, Integer> resultMap = sumParkingMinutes(records);

        List<String> carNums = new ArrayList<>(resultMap.keySet());
        Collections.sort(carNums);

        int[] answer = new int[carNums.size()];
        int idx = 0;
        for (String carNum : carNums) {
            answer[idx++] = calcFee(resultMap.get(carNum), fees);
        }
        return answer;
    }

    // 차량별 누적 주차 시간(분) 계산
    private Map<String, Integer> sumParkingMinutes(String[] records) {
        Map<String, Integer> inMap = new HashMap<>();     // 입차 시각 (출차하면 삭제)
        Map<String, Integer> resultMap = new HashMap<>(); // 누적 주차 시간

        for (String record : records) {
            String[] arr = record.split(" ");
            int time = changeMin(arr[0]);
            String carNum = arr[1];
            String inOut = arr[2];

            if (inOut.equals("IN")) {
                inMap.put(carNum, time);
            } else {
                resultMap.put(carNum, resultMap.getOrDefault(carNum, 0) + time - inMap.get(carNum));
                inMap.remove(carNum);
            }
        }

        // 출차 기록이 없는 차는 23:59에 출차한 것으로 계산
        for (Map.Entry<String, Integer> e : inMap.entrySet()) {
            String carNum = e.getKey();
            int remainMin = LAST_MINUTE - e.getValue();
            resultMap.put(carNum, resultMap.getOrDefault(carNum, 0) + remainMin);
        }
        return resultMap;
    }

    // 누적 주차 시간(분)으로 요금 계산
    private int calcFee(int min, int[] fees) {
        double ceil = Math.ceil((double) (min - fees[0]) / fees[2]);
        return fees[1] + (int) Math.max(0, ceil) * fees[3];
    }

    // "hh:mm" -> 분
    private int changeMin(String time) {
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }

    public static void main(String[] args) {
        주차요금계산_codereview s = new 주차요금계산_codereview();

        test(s, new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
                        "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"},
                "[14600, 34400, 5000]");

        test(s, new int[]{120, 0, 60, 591},
                new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"},
                "[0, 591]");

        test(s, new int[]{1, 461, 1, 10},
                new String[]{"00:00 1234 IN"},
                "[14841]");
    }

    // 두 풀이를 같이 돌려서 기대값과 비교
    private static void test(주차요금계산_codereview s, int[] fees, String[] records, String expected) {
        System.out.println("solution1 : " + Arrays.toString(s.solution1(fees, records)));
        System.out.println("solution2 : " + Arrays.toString(s.solution2(fees, records)));
        System.out.println("expected  : " + expected);
        System.out.println();
    }
}
