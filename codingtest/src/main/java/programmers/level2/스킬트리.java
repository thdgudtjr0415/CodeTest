package programmers.level2;
import java.util.ArrayDeque;
import java.util.Queue;

/*
 * 스킬트리 (프로그래머스 49993)
 *
 * 선행 스킬 순서(skill)가 정해져 있다. 예) "CBD"면 C -> B -> D 순서로만 배울 수 있다.
 * skill에 없는 스킬은 아무 때나 배워도 된다.
 *
 * [풀이 흐름]
 * 1. skill_trees를 하나씩 본다.
 * 2. tree의 글자를 앞에서부터 하나씩 보면서
 *    - skill에 없는 글자면 넘어간다.
 *    - skill에 있는 글자면 "지금 배울 차례인 스킬"과 같은지 확인한다.
 *        같으면 다음 차례로 넘어가고, 다르면 불가능한 스킬트리라서 멈춘다.
 * 3. 끝까지 멈추지 않았다면 가능한 스킬트리이므로 answer++
 *
 * [풀이 2가지]
 * - solution1 : skill을 큐에 넣고, 큐의 맨 앞(peek)을 "지금 차례"로 쓴다.
 * - solution2 : 큐 없이 idx로 skill의 "지금 차례"를 가리킨다.
 */
public class 스킬트리 {
    public int solution1(String skill, String[] skill_trees) {
        int answer = 0;
        for(String tree : skill_trees){
            // 스킬트리마다 skill을 큐에 새로 넣는다. (맨 앞 = 지금 배울 차례)
            Queue<Character> queue = new ArrayDeque<>();
            for(char c : skill.toCharArray()){
                queue.offer(c);
            }
            boolean possible = true; // break로 멈추면 false
            for(char c : tree.toCharArray()){
                if(skill.contains(String.valueOf(c))){
                    if(queue.peek() == c){
                        queue.poll();
                    }else {
                        possible = false;
                        break;
                    }
                }
            }
            if(possible){
                answer++;
            }
        }
        return answer;
    }
    // 큐 없이 idx로 푼 풀이
    public int solution2(String skill, String[] skill_trees) {
        int answer = 0;
        for(String tree : skill_trees){
            int idx = 0; // skill에서 지금 배울 차례의 위치
            boolean possible = true;
            for(char c : tree.toCharArray()){
                if(skill.contains(String.valueOf(c))){
                    if(skill.charAt(idx) == c){
                        idx++;
                    }else {
                        possible = false;
                        break;
                    }
                }
            }
            if(possible){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        스킬트리 s = new 스킬트리();
        System.out.println(s.solution1("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"})); //2 ,"CBADF", "AECB"
        System.out.println(s.solution2("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"})); //2 ,"CBADF", "AECB"
    }
}
