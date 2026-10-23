package programmers.level2.탐색;

/*
 [풀이 흐름]
 1. 조각으로 만들 수 있는 수를 모두 만든다 (예: "011" -> 0,1,10,11,101,110)
    - 조각을 하나 붙일 때마다(붙인 직후) 그 수를 정수로 바꿔 HashSet에 넣는다
      -> 1개, 2개, 3개짜리가 한 번에 담기고, 011 / 11 처럼 같은 수는 한 번만 남는다
    - 쓴 조각은 boolean[] 로 표시. 재귀 안에서 만들면 매번 초기화되니 solution에서 한 번만 만든다
    - 안쪽 재귀가 끝나 돌아오면 false 로 되돌린다 (백트래킹, 안 하면 다른 경우를 못 만듦)
 2. 각 수가 소수인지 확인한다
    - 0, 1은 소수가 아니므로 n < 2 면 바로 false
    - 2부터 i * i <= n 까지만 나눠 본다 (약수는 짝으로 나오고 작은 쪽은 항상 √n 이하)
    - i * i < n 이면 9 같은 제곱수를 놓치므로 반드시 <=
 3. 소수인 수의 개수를 반환

 [코드 리뷰]
 - primeNumber 는 소수를 찾는 게 아니라 "만들 수 있는 모든 수를 만드는" 메서드 -> makeNumbers 처럼 이름 바꾸면 읽기 쉬움
*/

import java.util.HashSet;

public class 소수찾기 {
    public int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        boolean[] checkUse = new boolean[numbers.length()];
        // 여기서 재귀 함수 써서 만들수 있는 모든 수를 구해서 set에 넣어야함
        makeNumbers(numbers, set, checkUse, "");
        int answer = 0;
        for(int n : set){
            if(isPrime(n)) answer++;
        }
        return answer;
    }
    // 소수 판별 메서드
    private boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }

    private void makeNumbers(String numbers, HashSet<Integer> set, boolean[] checkUse, String temp) {
        for(int i = 0; i < numbers.length(); i++){
            if(checkUse[i]) continue; // check가 true 면 다음으로 넘김
            checkUse[i] = true; // 지금 false니까 true로 해서 숫자 붙임
            String next = temp + numbers.charAt(i); // 기존에 temp에서 numbers의 자리를 더해줌
            set.add(Integer.valueOf(next)); // 그 next를 int 형변환을 해서 set에 넣음
            makeNumbers(numbers, set, checkUse, next); // 그리고 모든 수를 판별하기 위해 재귀
            checkUse[i] = false; // 그리고 다시 false
        }
    }

    public static void main(String[] args){
        소수찾기 s = new 소수찾기();
        System.out.println(s.solution("17")); //3
        System.out.println(s.solution("011")); //2
    }
}
