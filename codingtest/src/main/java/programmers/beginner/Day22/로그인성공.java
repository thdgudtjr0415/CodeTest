package programmers.beginner.Day22;

public class 로그인성공 {
    public String solution(String[] id_pw, String[][] db) {
        String result = "fail";
        String userId = id_pw[0];
        String userPw = id_pw[1];

        for(int i = 0; i < db.length; i++) {
            String dbId = db[i][0];
            String dbPw = db[i][1];

            // 여기선 if문을 잘 쓰자
            if(userId.equals(dbId)) {
                if(userPw.equals(dbPw)) {
                    result = "login";
                }else {
                    result = "wrong pw";
                }
                // 찾았으면 멈추는 걸 습관화 하자 이러면 리소스 절약 가능
                break;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        로그인성공 s = new 로그인성공();
        System.out.println(s.solution(new String[]{"meosseugi", "1234"},
                new String[][]{{"rardss", "123"}, {"yyoom", "1234"}, {"meosseugi", "1234"}})); // "login"
        System.out.println(s.solution(new String[]{"programmer01", "15789"},
                new String[][]{{"programmer02", "111111"}, {"programmer00", "134"}, {"programmer01", "1145"}})); // "wrong pw"
        System.out.println(s.solution(new String[]{"rabbit04", "98761"},
                new String[][]{{"jaja11", "98761"}, {"krong0313", "29440"}, {"rabbit00", "111333"}})); // "fail"
    }
}
