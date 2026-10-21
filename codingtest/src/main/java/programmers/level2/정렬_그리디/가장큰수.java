package programmers.level2.정렬_그리디;

// compareTo
//"A".compareTo("B")  음수: A가 B보다 앞이다
//"B".compareTo("B")  0   : 둘이 같다
//"C".compareTo("B")  양수: C가 B보다 뒤다

import java.util.Arrays;

public class 가장큰수 {
    public String solution1(int[] numbers) {
        String[] numbersArr =
                Arrays.stream(numbers)
                        // 아래들 같은 코드임
//                        .mapToObj(x -> String.valueOf(x))
                        .mapToObj(String::valueOf)
                        .toArray(String[]::new);
//        String[] numbersArr = new String[n];
//        for(int i = 0; i < n; i++){
//            String num = String.valueOf(numbers[i]);
//            numbersArr[i] = num;
//        }

        Arrays.sort(numbersArr, (a,b) ->{
            int num1 = Integer.parseInt(a+b);
            int num2 = Integer.parseInt(b+a);
            int compare = Integer.compare(num1, num2);
            if(compare > 0){
                return -1;
            }else if(compare < 0){
                return 1;
            }else {
                return 0;
            }
        });
        String result = String.join("", numbersArr);
        if(result.charAt(0) == '0'){
            return "0";
        }
        return result;
    }

    // 코드 리뷰
    // 1. 안쓰는 코드줄 지우기
    // 2. if/else if / else 부분 줄일 수 있음 -> Integer.compare(num2, num1);
    // 3. 그리고 처음부터 한줄이면 끝남, (b+a).compareTo(a+b);
    public String solution2(int[] numbers) {
        String[] numbersArr =
                Arrays.stream(numbers)
                        .mapToObj(String::valueOf)
                        .toArray(String[]::new);
        // 음수: a가 b보다 앞에 와야 함 / 양수: a가 b보다 뒤에 와야 함 / 0: 같아서 순서 상관없음
        Arrays.sort(numbersArr, (a,b) -> (b+a).compareTo(a+b));
        String result = String.join("", numbersArr);
        if(result.charAt(0) == '0'){
            return "0";
        }
        return result;
    }
    public static void main(String[] args){
        가장큰수 s = new 가장큰수();
        System.out.println(s.solution2(new int[]{6, 10, 2})); //6210
        System.out.println(s.solution2(new int[]{3,30,34,5,9})); //9534330

    }
}
