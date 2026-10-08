package programmers.level2;

// 1. x에 n 을 더함 / x 에 2를 곱합 / x 에 3을 곱합]
// 2. 1의 3가지경우를 조합하여 y로 만들기인데 최소 연산을 구하자 못만들면 -1;

// 풀이방법 최소이고일단 BFS, 큐 문제
// 일단 큐, 스택 둘다 deque로 풀어보기
// 그리고 방문 배열로 length y+1만큼(y도 포함해야해서) 만들 예정
// 사용은 x ~ y 까지만 사용 , 나머지는 따로 처리 하던가 해야함
// 그리고 큐에 넣을 때는 int[2]로 {연산하는 숫자, 연산했던 횟수}


import java.util.ArrayDeque;
import java.util.Deque;

public class 숫자변환하기 {
    public int solution1(int x, int y, int n) {
        // 예외처리 x,y 같으면 0횟수
        if(x==y) return 0;
        // 큐는 offer, poll
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[y+1];
        // 연산되는 숫자, 연산 몇번 했는지 숫자
        queue.offer(new int[]{x, 0});
        visited[x] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int num = cur[0];
            int count = cur[1];
            // 성공 조건
            if(num == y) return count;
            count++;
            if(num+n <= y && !visited[num+n]){
                queue.offer(new int[]{num+n, count});
                visited[num+n] = true;
            }
            if(num*2 <= y && !visited[num*2]){
                queue.offer(new int[]{num*2, count});
                visited[num*2] = true;
            }
            if(num*3 <= y && !visited[num*3]){
                queue.offer(new int[]{num*3, count});
                visited[num*3] = true;
            }
        }
        return -1;
    }

    public int solution2(int x, int y, int n) {
        // 예외처리 x,y 같으면 0횟수
        if(x==y) return 0;
        // 큐는 offer, poll
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[y+1];
        // 연산되는 숫자, 연산 몇번 했는지 숫자
        queue.offer(new int[]{x, 0});
        visited[x] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int num = cur[0];
            int count = cur[1];
            // 성공 조건
            if(num == y) return count;
            count++;

            int[] numArr = {num+n, num*2, num*3};
            for(int nextNum : numArr){
                if(nextNum <= y && !visited[nextNum]){
                    queue.offer(new int[]{nextNum, count});
                    visited[nextNum] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        숫자변환하기 s = new 숫자변환하기();
        System.out.println(s.solution2(10, 40, 5)); //2
        System.out.println(s.solution2(10, 40, 30)); //1
        System.out.println(s.solution2(2, 5, 4)); //-1
    }
}
