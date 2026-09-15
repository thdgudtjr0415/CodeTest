package programmers.level2;

// LRU(Least Recently Used) : 가장 오래동안 안쓰인 것을 교체
// cache hit일 경우 실행 시간 1, cache miss 일 경우 5
// hit = 캐시에 존재하고 있으면  / miss 존재하지 않으면

    //Queue -> FIFO
    //queue.offer(값);      // 맨 뒤에 추가 (= push 같은 느낌)
    //queue.poll();          // 맨 앞의 것을 꺼내면서 제거 (꺼낸 값을 반환)
    //queue.peek();          // 맨 앞의 것을 확인만 (제거 안 함)
    //queue.isEmpty();       // 비어있는지 확인
    //queue.size();          // 몇 개 들어있는지

import java.util.LinkedList;
import java.util.Queue;

public class 카카오_캐시 {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> queue = new LinkedList<>();
        int totalTime = 0;
        int cacheHit = 1;
        int cacheMiss = 5;
        // 캐시 크기를 넘어가면 안됨 그걸 기억하기
        // 조건
        // 크기 cacheSize 넘으면 안됨
        // 하나 받아낼때 존재하면 지우고 맨 뒤로 보내고
        // 존재하지 않으면 제일 앞에 즉 제일 오래된 것을 빼고 넣기
        // 대소문자도 구분안함
        for(int i = 0; i < cities.length; i++){
            String city = cities[i].toLowerCase();
            if(queue.contains(city)){
                queue.remove(city);
                queue.offer(city);
                totalTime += cacheHit;
            }else {
                if(queue.size() < cacheSize){
                    queue.offer(city);
                    totalTime += cacheMiss;
                }else {
                    queue.offer(city);
                    queue.poll();
                    totalTime += cacheMiss;
                }
            }
        }
        return totalTime;
    }
    public static void main(String[] args) {
        카카오_캐시 s = new 카카오_캐시();
        System.out.println(s.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"})); //50
        System.out.println(s.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"})); //21
        System.out.println(s.solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"})); //60
        System.out.println(s.solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"})); //52
        System.out.println(s.solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"})); //16
        System.out.println(s.solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"})); //25
    }
}
