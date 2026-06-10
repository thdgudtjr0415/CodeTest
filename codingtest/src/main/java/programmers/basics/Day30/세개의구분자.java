package programmers.basics.Day30;

import java.util.Arrays;

public class 세개의구분자 {
    public String[] solution(String myStr) {
        // 이거 정규표현식 [] 이거안에 들어가면 그 안에 어떤 문자를 만나든 허용이라는 뜻
        // 즉 지금 스플릿 하려는데 [abc]라고 하면 a,b,c를 만나면 스플릿을하라는 뜻
        String[] arr = myStr.split("[abc]");
        int len = 0;
        for(int i=0;i<arr.length;i++) if(!arr[i].isEmpty()) len++;
        String[] result = new String[len];
        if(len==0) return new String[]{"EMPTY"};
        int idx = 0;
        for(int i = 0; i < arr.length; i++){
            if(!arr[i].isEmpty()) result[idx++] = arr[i];
        }
        return result;
    }
    public static void main(String[] args){
        세개의구분자 s = new 세개의구분자();
        System.out.println(Arrays.toString(s.solution("baconlettucetomato")));
        System.out.println(Arrays.toString(s.solution("abcd")));
        System.out.println(Arrays.toString(s.solution("cabab")));
    }
}
