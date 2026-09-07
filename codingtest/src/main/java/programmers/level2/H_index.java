package programmers.level2;


public class H_index {
    public int solution(int[] citations){
        int answer = 0;
        int n = citations.length;
        // 여기서 h는 문제의 h
        for(int h = 0; h <= n; h++){
            int count = 0;
            for(int i = 0; i < n; i++){
                if(citations[i] >= h){
                    count++;
                }
            }
            if(count >= h){
                answer = Math.max(answer, h);
            }
        }
        return answer;
    }
    public static void main(String[] args){
        H_index s = new H_index();
        System.out.println(s.solution(new int[]{3,0,6,1,5}));
    }
}
