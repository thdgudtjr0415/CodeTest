package programmers.beginner.Day22;


// 이 문제는 replace와 isEmpty()를 사용해보자
// 이 문제를 풀땐 replace를 사용해서 " " 공백으로 치환 하기 -> 하지만 "" 이렇게 공백이 아닌것으로 치환하면 혹시 모를
// 단어의 합으로 문제에서 말한 문장이 될 수있음 그래서 " " 이렇게 치환 해야함
// 그리고 마지막도 replace로 " " -> "" 이렇게 치환하거나 isEmpty로 비어있다는걸 확인하면 count++
// 주의! isEmpty는 공백 " " 이건 못잡음 이걸 찾으려면 isBlank로 해야함

public class 옹알이_01 {
    public int solution(String[] babbling) {
        int result = 0;
        // 먼저 말할 수 것 배열로 만들어 놓기
        String[] word = {"aya", "ye", "woo", "ma"};

        for(int i=0;i<babbling.length;i++) {
            for(int j=0;j<word.length;j++) {
                    babbling[i] = babbling[i].replace(word[j]," ");
            }
            //  true면 == ture 부분 생략 가능
            if(babbling[i].isBlank()) {
                result++;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        옹알이_01 s = new 옹알이_01();
        System.out.println(s.solution(new String[]{"aya", "yee", "u", "maa", "wyeoo"})); //1
        System.out.println(s.solution(new String[]{"ayaye", "uuuma", "ye", "yemawoo", "ayaa"})); // 3

    }
}
