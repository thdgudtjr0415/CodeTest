package programmers.basics.Day27;

public class A강조하기 {
    public String solution1(String myString) {
        String result = "";
        for(int i = 0; i < myString.length(); i++) {
            char ch = myString.charAt(i);
            if(ch == 'a' || ch == 'A') {
                result += Character.toUpperCase(ch);
//                result += (char)('a' - 32); // 이거랑 같은거임 a랑 A는 32 차이남 그리고 a가 더 큼
            }else {
                result += Character.toLowerCase(ch);
            }
        }
        return result;
    }
    public String solution2(String myString) {
        return myString.toLowerCase().replaceAll("a", "A");
    }
    public static void main(String[] args) {
        A강조하기 s = new A강조하기();
        System.out.println(s.solution1("abstract algebra")); // "AbstrAct AlgebrA"
        System.out.println(s.solution1("PrOgRaMmErS")); //"progrAmmers"
        System.out.println(s.solution2("abstract algebra")); // "AbstrAct AlgebrA"
        System.out.println(s.solution2("PrOgRaMmErS")); //"progrAmmers"

    }
}
