package programmers.level1.Day40;

/*
* 도로에 차량 신호등 n개
* 항상 초록 - 노란 - 빨간 순서로 반복 각 신호의 지속 시간이 다름
* 시간은 1초 부터 시작, 각 신호등은 처음에는 초록불 상태로 시작
* signals에 각 초록, 노란, 빨간 불에 대한 지속 시간 초가 있으니 이를 각각 계산하여 모든 신호등이 노란불일때를 찾아야됨
* 존재하지 않으면 -1
*/

public class 노란불신호등 {
    // 생각나는대로 문자 붙여서 비교
    public int solution1(int[][] signals) {
        int result = -1;
        int n = signals.length;
        // 각 신호등의 합 구하기
        int[] AllSignal = new int[n];
        for(int i = 0; i < n; i++){
            int sum = signals[i][0]+signals[i][1]+signals[i][2];
            AllSignal[i] = sum;
        }

        // 최소 공배수를 위한 temp
        int lcm = 1;
        for(int i = 0; i < AllSignal.length; i++){
            int op = lcm(lcm, AllSignal[i]);
            lcm = op;
        }
        // 최소공배수 구한 것 까지 해서 다같이 노란불 나올때 까지 해보기
        // 이때 노란불은 각 인덱스 1에 위치
        // 그럼 String으로 G,Y,R붙여서 같은거 나오면 되는거 아닌가?
        // 즉 신호등 갯수만큼의 String[] 배열인데 각 인덱스는 lcm의 길이 만큼
        StringBuilder[] signalYellow = new StringBuilder[n];
        for(int i = 0; i < n; i++){
            signalYellow[i] = new StringBuilder("");
            for(int j = 0; j < lcm/AllSignal[i]; j++){
                for(int k = 0; k < 3; k++){
                    if(k == 0){
                        signalYellow[i].append("G".repeat(signals[i][k]));
                    }else if(k == 1){
                        signalYellow[i].append("Y".repeat(signals[i][k]));
                    }else {
                        signalYellow[i].append("R".repeat(signals[i][k]));
                    }
                }
            }
        }
        int[] arr = new int[n];
        for(int i = 0; i < lcm; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                arr[j] = signalYellow[j].charAt(i);
                if(arr[j] == 'Y'){
                    count++;
                }
            }
            if(count == n){
                return i+1;
            }
        }
        return result;
    }
    // 좀 효율적으로 연산하면서
    public int solution2(int[][] signals) {
        long start = System.currentTimeMillis();
        int result = -1;
        int n = signals.length;
        // 각 신호등의 합 구하기
        int[] AllSignal = new int[n];
        for(int i = 0; i < n; i++){
            int sum = signals[i][0]+signals[i][1]+signals[i][2];
            AllSignal[i] = sum;
        }

        // 최소 공배수를 위한 temp
        int lcm = 1;
        for(int i = 0; i < AllSignal.length; i++){
            int op = lcm(lcm, AllSignal[i]);
            lcm = op;
        }

        // 여기서 갈리는게 각 시간초에 해당하는 각 신호등에 대한 신호등색(즉 1초에 각각 무슨색이냐)
        for(int t = 1; t <= lcm; t++){
            char[] sign = new char[n];
            int count = 0;
            for(int j = 0; j < n; j++){
                // 0~AllSignal[j] 까지 반복
                int pos = (t-1) % AllSignal[j];
                if(pos >= 0 && pos < signals[j][0]){
                    // 초록불
                    sign[j] = 'G';
                }else if(pos >= signals[j][0] && pos < signals[j][0]+signals[j][1]){
                    // 노란불
                    sign[j] = 'Y';
                    count++;
                }else {
                    // 빨간불
                    sign[j] = 'R';
                }
            }
            if(count == n){
                return t;
            }
        }
        return result;
    }


    // 각 신호등의 길이를 더한 것으로 최소공배수 구하기, 그런데 최대 공약수도 나와야 최소 공배수가 나옴
    // a,b의 최소 공배수
    // 최소공배수 = axb / 최대 공약수
    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    private int lcm(int a, int b){
        return (a*b)/gcd(a,b);
    }

    public static void main(String[] args){
        노란불신호등 s = new 노란불신호등();
        System.out.println(s.solution1(new int[][]{{2,1,2},{5,1,1}})); //13
        System.out.println(s.solution1(new int[][]{{2,3,2},{3,1,3},{2,1,1}})); //11
        System.out.println(s.solution1(new int[][]{{3,3,3},{5,4,2},{2,1,2}})); //193
        System.out.println(s.solution1(new int[][]{{1,1,4},{2,1,3},{3,1,2},{4,1,1}})); //-1
        System.out.println(s.solution2(new int[][]{{2,1,2},{5,1,1}})); //13
        System.out.println(s.solution2(new int[][]{{2,3,2},{3,1,3},{2,1,1}})); //11
        System.out.println(s.solution2(new int[][]{{3,3,3},{5,4,2},{2,1,2}})); //193
        System.out.println(s.solution2(new int[][]{{1,1,4},{2,1,3},{3,1,2},{4,1,1}})); //-1
    }
}
