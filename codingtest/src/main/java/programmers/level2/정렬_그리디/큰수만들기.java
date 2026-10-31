package programmers.level2.정렬_그리디;

// k는 지워야하는 숫자 개수
// 숫자를 앞에서부터 하나씩
// 맨 뒤 숫자가 새 숫자보다 작고 k가 남아 있으면, 맨 뒤 숫자를 지우기 (k 하나 줄어요). 이걸 반복해요.
// 그다음 새 숫자를 붙여요.
class 큰수만들기 {
        public String solution(String number, int k) {
            StringBuilder sb = new StringBuilder();
            String answer = "";
            
            for(int i = 0; i < number.length(); i++){
                while(sb.length() > 0 && k > 0 && number.charAt(i) > sb.charAt(sb.length()-1)){
                    sb.deleteCharAt(sb.length()-1);
                    k--;
                }
                sb.append(number.charAt(i));
            }

            answer = sb.substring(0,sb.length()-k); // substring(시작 인덱스, 끝 인덱스는 포함 안 함)
        return answer;
    }
    public static void main(String[] args){
        큰수만들기 s = new 큰수만들기();
        System.out.println(s.solution("1924", 2)); // 94
        System.out.println(s.solution("1231234", 3)); // 3234
        System.out.println(s.solution("4177252841", 4)); // 775841
        System.out.println(s.solution("4321", 1)); // 432 (직접 추가한 예시)
    }
}
