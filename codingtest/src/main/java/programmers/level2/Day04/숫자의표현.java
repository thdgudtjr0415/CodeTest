package programmers.level2.Day04;

public class 숫자의표현 {
    /*
     * [방법1] 완전 탐색(브루트포스)
     * 1. start를 1부터 n까지 하나씩 늘려가며 시작점으로 삼는다
     * 2. 각 start마다, start부터 자연수를 하나씩 더해나가며 누적합(sum)을 구한다
     *    - sum이 n과 정확히 같아지면 -> 표현 방법 1개 발견, count++
     *    - sum이 n을 넘어서면 -> 이 start로는 더 이상 답이 안 나오니 그 즉시 더하기 중단
     * 3. 모든 start를 다 시도한 뒤, count를 반환
     * (참고: start가 커질수록 몇 번 안 더해도 금방 n을 넘어버리므로,
     *  겉보기와 달리 실제 연산 횟수는 n*n보다 훨씬 적음)
     */
    public int solution1(int n) {
        int result = 0;
        for(int i = 1; i <= n; i++){
            // 시작을 i부터 했을때 sum은 무조건 i를 포함하니까 시작을 i로 함
            int sum = i;
            if(sum == n) result++;
            for(int j = i+1; j <= n; j++){
                if(sum < n){
                    sum += j;
                }else if(sum == n){
                    result++;
                    break;
                }else {
                    break;
                }
            }
        }
        return result;
    }

    /*
     * [방법2] 투 포인터
     * 1. start = 1, end = 1로 시작, sum = 1(start~end 구간의 합)로 초기화
     * 2. sum과 n을 비교하며 구간을 조절
     *    - sum == n 이면 -> 표현 방법 1개 발견, count++, 그다음 end를 한 칸 늘려서 계속 탐색
     *    - sum < n 이면 -> 합이 아직 부족하니 end를 한 칸 늘리고, sum에 그 값을 더함
     *    - sum > n 이면 -> 합이 너무 크니 start를 한 칸 줄이고, sum에서 그 값을 뺌
     * 3. start가 n을 넘어서면(또는 end가 n을 넘어서면) 반복 종료, count 반환
     * 핵심 아이디어: start, end 두 지점을 움직이며 구간 합을 유지하기 때문에,
     * 매번 처음부터 다시 더할 필요 없이 "한 칸 늘어난 만큼만 더하고, 한 칸 줄어든 만큼만 빼는" 식으로
     * 훨씬 적은 연산으로 같은 결과를 얻을 수 있음 (O(n))
     */

    public int solution2(int n) {
        int result = 0;
        int start = 1;
        int end = 1;
        int sum = 1;   // start~end 구간(현재는 1~1)의 합. 이 값을 매번 새로 계산하지 않고 계속 "갱신"만 해나감

        while(start <= n){
            if(sum >= n){
                // sum이 n 이상이면 -> 구간을 줄여야 함 (왼쪽 끝을 하나 뺀다)
                if(sum == n) result++;   // 그중에서도 딱 n이면, 표현 방법 1개 발견

                // 핵심: 처음부터 다시 더하지 않고, "빠지는 값(start) 딱 하나만" 뺀다
                // ex) start=1, sum=1+2+3+4+5=15 였다면 -> sum -= 1 -> sum=14 (=2+3+4+5, 이미 검증 완료)
                sum -= start;
                start++;   // 왼쪽 끝을 뺐으니, 다음 숫자부터가 새로운 왼쪽 끝
            }else{
                // sum이 n보다 작으면 -> 구간을 넓혀야 함 (오른쪽 끝을 하나 늘린다)
                end++;
                sum += end;   // 마찬가지로, 새로 들어온 값(end) 딱 하나만 더함
            }
        }
        return result;
    }
    public static void main(String[] args){
        숫자의표현 s = new 숫자의표현();
        System.out.println(s.solution1(15)); //4
        System.out.println(s.solution1(1)); //1  (자기 자신 하나뿐인 최소 케이스)
        System.out.println(s.solution1(9)); //3  (9, 4+5, 2+3+4)
        System.out.println(s.solution1(8)); //1  (2의 거듭제곱은 표현법이 딱 1개, 자기 자신뿐)
        System.out.println(s.solution1(10000)); //5  (제한사항 최대값, 성능 확인용)

        System.out.println(s.solution2(15)); //4
        System.out.println(s.solution2(1)); //1
        System.out.println(s.solution2(9)); //3
        System.out.println(s.solution2(8)); //1
        System.out.println(s.solution2(10000)); //5
    }
}
