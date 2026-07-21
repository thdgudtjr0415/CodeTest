package programmers.level1.Day30;

// id의 길이는 3~15자, 소문자, 숫자, -, _, . 문자만 사용가능
// 단 . 은 처음과 끝에 사용 불가, 연속 사용 불가

//만약 맞지 않는다면
//1. new_id의 모든 대문자를 대응되는 소문자로 치환
//2. new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
//3. new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
//4. new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
//5. new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
//6. new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
//7. new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

// 정규표현식
//[...]   → 대괄호 안의 문자 중 하나
//^       → 부정 (NOT)
//a-z     → 알파벳 소문자
//0-9     → 숫자
//\\-     → 빼기(-) / 빼기는 0-9 처럼 범위로 읽히기 때문에 \\ 를 붙여주거나 위치를 다르게 해야함
//_       → 밑줄
//.       → 마침표
// 즉 [^a-z0-9\\-_.] 혹은 [^a-z0-9_.-] 이런식으로

public class 카카오_신규아이디추천 {
    public String solution(String new_id) {
        if(isCheckId(new_id) == true) {
            return new_id;
        }
        // 1단계 소문자 변환
        new_id = new_id.toLowerCase();
        // 2단계 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        // 이건 정규 표현식이 좋은듯
        new_id = new_id.replaceAll("[^a-z0-9\\-_.]","");
        // 3단계  마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        // {2} 는 2개, {2,} 2개 이상
        // 또 앞에 .만 혼자 못있음 그래서 \\ 이거 붙여줘야함
        new_id = new_id.replaceAll("\\.{2,}",".");
        // 4단계 마침표(.)가 처음이나 끝에 위치한다면 제거
        // index 1 부터 끝까지
        if(new_id.startsWith(".")) { new_id = new_id.substring(1); }
        if(new_id.endsWith(".")) { new_id = new_id.substring(0, new_id.length()-1); }
        // 5단계 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(new_id.isEmpty()){
            new_id = "a";
        }
        // 6단계 id의 길이가 16자 이상이면, id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
        // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(new_id.length() >= 16){
            new_id = new_id.substring(0, 15); //substring은 끝 포함
            if(new_id.endsWith(".")){
                new_id = new_id.substring(0, new_id.length()-1);
            }
        }
        // 7단계 id의 길이가 2자 이하라면,id의 마지막 문자를 id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if(new_id.length() < 3){
            while(new_id.length() < 3){
                new_id = new_id + new_id.charAt(new_id.length()-1);
            }
        }
        return new_id;
    }
    public static boolean isCheckId(String id) {
        if(id == null) return false;
        if(id.length() < 3 || id.length() > 15){
            return false;
        }
        if(id.contains("..")){
            return false;
        }
        if(id.startsWith(".") || id.endsWith(".")){
            return false;
        }
        for(int i = 0; i < id.length(); i++){
            char ch = id.charAt(i);
            if(!((ch >= 'a' && ch <= 'z')
                    || (ch >= '0' && ch <= '9')
                    || (ch == '-' || ch == '_' || ch == '.'))){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        카카오_신규아이디추천 s = new 카카오_신규아이디추천();
        System.out.println(s.solution("...!@BaT#*..y.abcdefghijklm")); //"bat.y.abcdefghi"
        System.out.println(s.solution("z-+.^.")); //"z--"
        System.out.println(s.solution("=.=")); //	"aaa"
        System.out.println(s.solution("123_.def")); //	"123_.def"
        System.out.println(s.solution("abcdefghijklmn.p")); //	"abcdefghijklmn"
    }
}
