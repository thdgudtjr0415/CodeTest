package programmers.beginner.Day21;

import java.util.Arrays;
import java.util.Comparator;


// 이번에 Comparator(비교기)를 사용해볼 것. 이 comparator 는 Integer를 써야함
// 이때 규칙을 내가 정해볼껀데 한번 느낌만 보도록하자

public class 특이한정렬 {
    public int[] solution1(int[] numlist, int n) {
        int[] result = new int[numlist.length];
        Integer[] arr =  new Integer[numlist.length];
        for(int i=0;i<numlist.length;i++){
            arr[i] = numlist[i];
        }

        // sort에 새로운 규칙 적용
        // compare(a, b)라는건 두개의 수를 비교해서 +인지 - 인지만 비교함 여기서 양수라면 바꿈★
        // 그래서 a-b가 양수일 땐 b가 더 작은 것이라서 두 수를 바꿈 -> 이게 기본 정렬 오른차순
        // 그리고 b-a가 양수라면 뒤에 있는 b가 더 큰것이므로, 큰 수 b를 앞으로 끌고 오기 위해 자리를 바꿈 -> 내림차순
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // 먼저 비교할 절대값들을 구함
                int distA = Math.abs(a - n);
                int distB = Math.abs(b - n);

                // 그래서 예외인 두수의 절대값이 같을때 큰수를 앞으로 둬야함 -> 이건 내림차순 이야기
                if (distA == distB) {
                    return b - a;
                }
                // 여긴 기본 정렬인 오름차순을 넣기 위한것 disA가 큰것이라고 가정
                return distA - distB;
            }
        });

        for(int i=0;i<arr.length;i++){
            result[i] = arr[i];
        }
        return result;
    }
    public int[] solution2(int[] numlist, int n) {
        int[] result = new int[numlist.length];

        // 이러면 무조건 인덱스 0,1 이런식으로 비교
            for(int i = 0; i < numlist.length-1; i++){
                for(int j= i+1; j < numlist.length; j++){
                    // 처음 i번째 수랑 j번째 수를 비교
                    int disA =  Math.abs(numlist[i] - n);
                    int disB =  Math.abs(numlist[j] - n);
                    // 여기서 문제는 거리가 더 가까운것을 앞으로 두는 것이니까
                    // disA와 disB중에 disB의 크기가 더 작으면 앞으로 옮겨야함
                    // 그리고 이때 둘의 abs 절대값의 크기가 같을때는 원래의 큰수가 큰 것을 앞으로
                    if(disB < disA || (disB == disA && numlist[j] > numlist[i])){
                        int temp = numlist[i];
                        numlist[i] = numlist[j];
                        numlist[j] = temp;
                    }
                }
            }
            for(int i=0;i<numlist.length;i++){
                result[i] = numlist[i];
            }
        return result;
    }

    public static void main(String[] args) {
        특이한정렬 s = new 특이한정렬();
        System.out.println(Arrays.toString(
                s.solution1(new int[]{1, 2, 3, 4, 5, 6}, 4))); // 4,5,3,6,2,1
        System.out.println(Arrays.toString(
                s.solution1(new int[]{10000,20,36,47,40,6,10,7000}, 30))); // 36, 40, 20, 47, 10, 6, 7000, 10000

        System.out.println(Arrays.toString(
                s.solution2(new int[]{1, 2, 3, 4, 5, 6}, 4))); // 4,5,3,6,2,1
        System.out.println(Arrays.toString(
                s.solution2(new int[]{10000,20,36,47,40,6,10,7000}, 30))); // 36, 40, 20, 47, 10, 6, 7000, 10000
    }
}
