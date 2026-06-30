package programmers.level1.Day11;

public class 카드뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String result = "Yes";
        int cards1Index = 0;
        int cards2Index = 0;
        for(int i = 0; i <goal.length; i++){
            // if절의 순서도 중요함
            if(cards1Index < cards1.length && cards1[cards1Index].equals(goal[i])){
                cards1Index++;
            }else if(cards2Index < cards2.length && cards2[cards2Index].equals(goal[i])){
                cards2Index++;
            }else {
                return "No";
            }
        }
        return result;
    }
    public static void main(String[] args) {
        카드뭉치 s = new 카드뭉치();
        System.out.println(s.solution(new String[]{"i", "drink", "water"}
                ,new String[]{"want", "to"},new String[]{"i", "want", "to", "drink", "water"}));//Yes
        System.out.println(s.solution(new String[]{"i", "water", "drink"}
                ,new String[]{"want", "to"},new String[]{"i", "want", "to", "drink", "water"}));//Yes
    }
}
