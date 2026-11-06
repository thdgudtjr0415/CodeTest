package programmers.level2.DP_수학;

//arrayA의 최대공약수를 구해요. 이걸 g라고 할게요.
//g의 약수를 큰 수부터 하나씩 확인해요.
//각 약수 a에 대해 arrayB의 숫자를 하나씩 %로 나눠 봐요. 하나라도 0이면 그 a는 탈락이에요.
//처음으로 통과한 a가 조건 ①의 답이에요. 큰 수부터 봤으니 처음 통과한 수가 가장 큰 수예요.
//조건 ②는 같은 방법을 반대로 해요. arrayB의 최대공약수를 구하고, 그 약수들을 arrayA로 검사해요.
//두 조건에서 나온 값 중 큰 수를 답으로 해요. 둘 다 없으면 0이에요.

public class 숫자카드나누기 {
    public int solution(int[] arrayA, int[] arrayB) {
        int n = arrayA.length;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        for(int i = 1; i < n; i++){
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        // arrayB 먼저
        for(int i = 0; i < n; i++){
            if(arrayB[i] % gcdA == 0){
                gcdA = 0;
                break;
            }
        }
        // arrayA 검사
        for(int i = 0; i < n; i++){
            if(arrayA[i] % gcdB == 0){
                gcdB = 0;
                break;
            }
        }
        return Math.max(gcdA, gcdB);
    }
    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        숫자카드나누기 s = new 숫자카드나누기();
        System.out.println(s.solution(new int[]{10, 17}, new int[]{5, 20})); // 0
        System.out.println(s.solution(new int[]{10, 20}, new int[]{5, 17})); // 10
        System.out.println(s.solution(new int[]{14, 35, 119}, new int[]{18, 30, 102})); // 7
    }
}
