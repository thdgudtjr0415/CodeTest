package programmers.basics.Day35;

// 아메리카노 4500, 라뗴 5000

public class 커피심부름 {
    public int solution(String[] order) {
        String[] americano = {"iceamericano", "americanoice","hotamericano", "americanohot", "americano", "anything"};
        String[] latte = {"icecafelatte", "cafelatteice", "hotcafelatte", "cafelattehot","cafelatte"};
        int result = 0;

        for(int i = 0; i < order.length; i++){
            for(int j = 0; j < americano.length; j++){
                if(order[i].equals(americano[j])){
                    result += 4500;
                }
            }
            for(int j = 0; j < latte.length; j++){
                if(order[i].equals(latte[j])){
                    result += 5000;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        커피심부름 s = new 커피심부름();
        System.out.println(s.solution(new String[]{"cafelatte", "americanoice", "hotcafelatte", "anything"})); // 19000
        System.out.println(s.solution(new String[]{"americanoice", "americano", "iceamericano"})); // 13500
    }
}
