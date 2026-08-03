package programmers.level1.Day36;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
* 각 유저는 한번에 한명 유저 신고
* 한 유저를 여러번 신공 가능, 동일한 유저에 대한 신고 횟수 1번
* k번 이상 신고된 유저는 게시판 이용 정지, 해당 유저를 신고한 모든 유저는 정지 사실을 메일로 발송
* 유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용정지를 시키면서 정지 메일을 발송
*
* report 배열은 공백을 기준으로 split, count k 이상이면 정지, 그리고 정지를 시킨 유저에게 메일 보내는데
* result : 메일이 온 횟수
* */

public class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 순서 (0, muzi), (1,frodo), (2,apeach), (3, neo)
        int[] result = new int[id_list.length];
        // 중복 확인하기
        // 키와 값을 신고당한사람, {신고한 사람들} 이렇게 왜냐하면 신고 당한 횟수 세려고
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        for(int i = 0; i < report.length; i++){
            String id = report[i].split(" ")[0];
            String report_id = report[i].split(" ")[1];
            if(!reportMap.containsKey(report_id)){
                reportMap.put(report_id, new HashSet<>());
            }
            // 그럼 그 아이디에 신고한 아이디 넣기
            reportMap.get(report_id).add(id);
        }
//        System.out.println(reportMap); // {muzi=[apeach], neo=[muzi, frodo], frodo=[muzi, apeach]}
        // 신고한 사람들에게 메일 보내기, 하지만 k번 이상 신고를 당해야 메일 보낼 수 잇음
        /*
        * reportMap.keySet()     // 키들만 순회 (예: "muzi", "frodo", "apeach")
        * reportMap.values()     // 값들만 순회 (예: {"frodo","neo"}, {"neo"}, {"muzi","frodo"})
        * reportMap.entrySet()   // 키-값 쌍을 통째로 순회
        * */
        // 여기에 이름이랑 인덱스 넣음
        HashMap<String, Integer> userMap = new HashMap<>();
        for(int i = 0; i < id_list.length; i++){
            userMap.put(id_list[i], i);
        }
        // 이제 k번 신고 당하면 result 에 올리기
        for(String User : reportMap.keySet()){
            // 신고 당한 사람에 대한 신고한 사람들 꺼내기
            HashSet<String> set = reportMap.get(User);
            // 그래서 신고 당한 사람에 대한 신고한 사람이 k개 보다 많다면
            if(set.size() >= k){
                // set에 있는 갯수만큰 돌려서
                for(String reporter : set){
                    int idx = userMap.get(reporter);
                    result[idx]++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        신고결과받기 s = new 신고결과받기();
        System.out.println(Arrays.toString(s.solution(
                new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},
                2))); // 2,1,1,0
        System.out.println(Arrays.toString(s.solution(
                new String[]{"con", "ryan"},
                new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},
                3))); // 0,0
    }
}
