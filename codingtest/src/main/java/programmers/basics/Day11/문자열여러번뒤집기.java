package programmers.basics.Day11;
/*
* 주의! substirng 하면 (start, end +1)을 주의하자
* apple.substring(0,3) 이거면 app이 출력 즉 endIndex는 포함 안하는거니까 주의하기
* */
public class 문자열여러번뒤집기 {
    public String solution(String my_string, int[][] queries) {
        String result = "";
        StringBuilder sb = new StringBuilder(my_string);

        for(int i=0;i<queries.length;i++){
            // 인덱스 추출하기
            int start = queries[i][0];
            int end = queries[i][1];
            // 문제의 의도 처럼 먼저 인데그만큼의 부분 뜯기
            String sub = sb.substring(start,end+1);
            // 오려낸 부분만 임시 StringBuilder로 뒤집기 뒤집기
            // 이유는 sb.~~ 이런식으로 하면 전체가 뒤집힐테니까 sub 부분만 임시로 쓰기
            String reversedSub = new StringBuilder(sub).reverse().toString();
            // 간단하게 replace로 치환
            sb.replace(start,end+1,reversedSub);
        }
        result = sb.toString();

        return result;
    }
    public static void main(String args[]){
        문자열여러번뒤집기 s = new 문자열여러번뒤집기();
        System.out.println(s.solution(new String("rermgorpsam"), new int[][]{{2,3},{0,7},{5,9},{6,10}}));
    }
}
