package programmers.level2.구현_시뮬레이션;


import java.util.*;

// 기본 시간(분) 180분, 기본요금(원) 5000, 단위 시간(분) 10분, 단위 요금(원) 600
// 출차 내역이 없다면 23:59 에 출차된것으로 간주

// 0. HashMap으로 String key(차량 번호), Integer value(입출차 시간?)
// 1. records 배열의 length만큼 반복문 돌림
// 2. 그 안에서 records[i]를 split(" ")(공백) 으로 자르고 배열에 넣음
// 3. 그럼 그 배열을 순서대로 받아서 시간을 분으로 바꿔야함(모든 기준이 분이라서 그게 편할듯?)
// 4. 그리고 배열중 3번째가 IN이면 map에 집어 넣고 out 이면 계산을 해야하는데...
public class 주차요금계산 {
    public int[] solution1(int[] fees, String[] records) {
        HashMap<String, Integer> map = new HashMap<>();
        Map<String, Integer> resultMap = new TreeMap<>();

        int m2359 = 1439; // 23*60 + 59
        for(int i = 0; i < records.length; i++){
            String[] arr = records[i].split(" ");
            // 바로 분으로 바꾸는 메서드로 집어넣음
            int totalMin = changeMin(arr[0]);
            String carNum = arr[1];
            String inOut = arr[2];
            if(inOut.equals("IN")){
                map.put(carNum, totalMin);
            }else {
                resultMap.put(carNum, resultMap.getOrDefault(carNum, 0) + totalMin - map.get(carNum));
                map.remove(carNum);
            }
//            System.out.println(totalMin + " | " + carNum + " | " + inOut);
        }

        // 만약 map이 비어있지 않다면 꺼내서 resultMap에 23:59에 출차로 간주한 것을 계산해서 넣기
        if(!map.isEmpty()){
            for(Map.Entry<String, Integer> e : map.entrySet()){
                String carNum = e.getKey();
                int remainMin =  m2359 - e.getValue();
                resultMap.put(carNum, resultMap.getOrDefault(carNum,0) + remainMin);
//                map.remove(carNum);
            }
        }

        // 로그
//        System.out.println(resultMap);
        // 이제 순서대로 꺼내서 2차원 배열에 담고 계산하기
        int[] answer = new int[resultMap.size()];
        int idx = 0;
        for(Map.Entry<String, Integer> m : resultMap.entrySet()){
            int min = m.getValue();
            double ceil = Math.ceil((double) (min - fees[0]) / fees[2]);
            answer[idx] = fees[1] + (int)(Math.max(0, ceil)) * fees[3];
            idx++;
        }
        return answer;
    }

    public int[] solution2(int[] fees, String[] records) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> resultMap = new HashMap<>();

        int m2359 = 1439; // 23*60 + 59
        for(int i = 0; i < records.length; i++){
            String[] arr = records[i].split(" ");
            int totalMin = changeMin(arr[0]);
            String carNum = arr[1];
            String inOut = arr[2];
            if(inOut.equals("IN")){
                map.put(carNum, totalMin);
            }else {
                resultMap.put(carNum, resultMap.getOrDefault(carNum, 0) + totalMin - map.get(carNum));
                map.remove(carNum);
            }
        }

        if(!map.isEmpty()){
            for(Map.Entry<String, Integer> e : map.entrySet()){
                String carNum = e.getKey();
                int remainMin =  m2359 - e.getValue();
                resultMap.put(carNum, resultMap.getOrDefault(carNum,0) + remainMin);
            }
        }

        int[] answer = new int[resultMap.size()];
        int idx = 0;
        List<String> list = new ArrayList<>(resultMap.keySet());
        Collections.sort(list);
//        System.out.println(list);

        for(String carNum : list){
            int min = resultMap.get(carNum);
            double ceil = Math.ceil((double) (min - fees[0]) / fees[2]);
            answer[idx] = fees[1] + (int)(Math.max(0, ceil)) * fees[3];
            idx++;
        }
        return answer;
    }


    public int changeMin (String totalTime){
        String[] time = totalTime.split(":");
        int hourMin = Integer.parseInt(time[0])*60;
        int min = Integer.parseInt(time[1]);
        return hourMin + min;
    }

    public static void main(String[] args){
        주차요금계산 s = new 주차요금계산();

        System.out.println(Arrays.toString(s.solution2(
                new int[]{180,5000,10,600},
                new String[]{
                        "05:34 5961 IN",
                        "06:00 0000 IN",
                        "06:34 0000 OUT",
                        "07:59 5961 OUT",
                        "07:59 0148 IN",
                        "18:59 0000 IN",
                        "19:09 0148 OUT",
                        "22:59 5961 IN",
                        "23:00 5961 OUT"}
        ))); // 14600,34400,5000

        System.out.println(Arrays.toString(s.solution2(
                new int[]{120, 0, 60, 591},
                new String[]{
                        "16:00 3961 IN",
                        "16:00 0202 IN",
                        "18:00 3961 OUT",
                        "18:00 0202 OUT",
                        "23:58 3961 IN"}
        ))); // 0,591

        System.out.println(Arrays.toString(s.solution2(
                new int[]{1,461,1,10},
                new String[]{"00:00 1234 IN"}
        ))); //14841
    }
}
