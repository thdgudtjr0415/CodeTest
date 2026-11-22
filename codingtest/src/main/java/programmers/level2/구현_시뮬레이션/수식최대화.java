package programmers.level2.구현_시뮬레이션;

import java.util.ArrayList;
import java.util.List;

public class 수식최대화 {
    public long solution(String expression) {
        List<String> list = new ArrayList<>();
        String[] priorities = {"+-*", "+*-", "-+*", "-*+", "*+-", "*-+"};
        long answer = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < expression.length(); i++){
            char temp = expression.charAt(i);
            if(temp >= '0' && temp <= '9'){
                sb.append(temp);
            }else {
                list.add(String.valueOf(sb));
                sb.setLength(0);
                sb.append(temp);
                list.add(String.valueOf(sb));
                sb.setLength(0);
            }
        }
        list.add(String.valueOf(sb));
        sb.setLength(0);
        for(int i = 0; i < priorities.length; i++){
            List<String> copy = new ArrayList<>(list);
            for(int j = 0; j < priorities[i].length(); j++){
                String priority = String.valueOf(priorities[i].charAt(j)); // 부호

                while(copy.contains(priority)){
                    int idx = copy.indexOf(priority);
                    long result = 0;
                    long a = Long.parseLong(copy.get(idx-1));
                    long b = Long.parseLong(copy.get(idx+1));
                    switch (priority){
                        case "+" :
                            result = a + b;
                            break;
                        case "-" :
                            result = a - b;
                            break;
                        case "*" :
                            result = a * b;
                            break;
                    }
                    copy.remove(idx-1);
                    copy.remove(idx-1);
                    copy.remove(idx-1);
                    copy.add(idx-1, String.valueOf(result));
                }
            }
            answer = Math.max(answer ,Math.abs(Long.parseLong(copy.get(0))));
        }
        return answer;
    }

    public static void main(String[] args) {
        수식최대화 s = new 수식최대화();
        System.out.println(s.solution("100-200*300-500+20")); // 60420
        System.out.println(s.solution("50*6-3*2")); // 300
    }
}
