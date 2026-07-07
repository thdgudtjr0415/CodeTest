package programmers.level1.Day17;

//문자열 s의 각 알파벳을 index만큼 뒤의 알파벳으로 바꿔줍니다.
//index만큼의 뒤의 알파벳이 z를 넘어갈 경우 다시 a로 돌아갑니다.
//skip에 있는 알파벳은 제외하고 건너뜁니다.

public class 둘만의암호 {
    public String solution(String s, String skip, int index) {
        String result = "";
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            for(int j = 0 ; j < index ; j++){
                if(c == 'z') {
                    c = 'a';
                }else {
                    c++;
                }
                while(skip.contains(String.valueOf(c))){
                    if(c == 'z'){
                        c = 'a';
                    }else {
                        c++;
                    }
                }
            }
            result += c;
        }
        return result;
    }
    public static void main(String[] args){
        둘만의암호 s = new 둘만의암호();
        System.out.println(s.solution("aukks", "wbqd", 5)); //happy
    }
}
