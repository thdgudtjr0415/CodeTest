package programmers.basics.Day10;

/*
* 1. x1 v x2
* 2. x3 v x4
* 3. (x1 v x2) ∧ (x3 v x4)
* 순서로 진행하면 될듯한데 각각의 변수를 만들어서 사용해보자
* */

public class 간단한논리연산 {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        boolean result = false;
        boolean sum12 = false;
        boolean sum34 = false;

        // true 생략 가능
        // boolean sum12 = x1 || x2; 로도 사용 가능
        if(x1 || x2){
            sum12 = true;
        }else if(x1 == false && x2 == false){
            sum12 = false;
        }

        // boolean sum34 = x3 || x4
        if(x3 || x4){
            sum34 = true;
        }else if(x3 == false && x4 == false){
            sum34 = false;
        }

        // result = sum12 && sum34
        if(sum12 && sum34){
            result = true;
        }else {
            result = false;
        }

        return result;
    }
    public static void main(String[] args) {
        간단한논리연산 s = new 간단한논리연산();
        System.out.println(s.solution(false, true, true, true)); // true
        System.out.println(s.solution(true, false, false, false)); // false

    }
}
