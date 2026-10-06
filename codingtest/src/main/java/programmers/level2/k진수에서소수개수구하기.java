package programmers.level2;

public class k진수에서소수개수구하기 {
    public int solution(int n, int k) {
        int answer = 0;
        String first = Integer.toString(n, k);
        String[] arr = first.split("0+");
        // 여기서 소수 구하기
        for(int i = 0; i < arr.length; i++){
            long num = Long.parseLong(arr[i]);
            if(num == 1) continue;
            int count = 0;
            for(long j = 2; j*j <= num; j++){
                if(num%j == 0){
                    count++;
                }
            }
            if(count == 0){
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        k진수에서소수개수구하기 s = new k진수에서소수개수구하기();
        System.out.println(s.solution(437674,3)); // 3
        System.out.println(s.solution(110011,10)); // 2
    }
}
