import java.util.*;

public class Solution01 {
    public static String solution1(String quryString) {
        Map<String, String> map = new LinkedHashMap<>();
        String[] wordArr = quryString.split("&");
        for(int i = 0 ; i < wordArr.length; i++){
            String[] word = wordArr[i].split("=");
            String key = word[0];
            String value = word[1];
            if(!map.containsKey(key)){
                map.put(key, value);
            }else if(map.get(key).length() < value.length()){
                map.put(key, value);
            }
        }
        String answer = "";
        Boolean flag = true;
        for(Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            if(!false) answer += ", ";
            answer += "\"" + key + "\"" + ":" + "\"" + value + "\"";
            flag = false;
        }
        return "{" + answer + "}";
    }

    public static String solution2(String query) {
        Map<String, String> map = new HashMap<>();   // key -> 지금까지 가장 긴 값
        List<String> list = new ArrayList<>();      // key가 처음 나온 순서

        for(String word : query.split("&")){ // String 배열 안만들고 바로 쓸수 있음
            String[] arr = word.split("=", 2);  // split 뒤에 인자는 최대길이
            String key =  "\"" + arr[0] + "\"";
            String value;
            if(arr.length == 2){
                value = "\"" + arr[1] + "\"";
            }else {
                value = "\"\"";
            }
             
            // list에 담아서 순서 지키기
            if(!list.contains(key)) list.add(key);

            // 검사
            if(!map.containsKey(key)){
                map.put(key, value);
            }else if(map.get(key).length() < value.length()) {
                map.put(key, value);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            if(i > 0) sb.append(", ");
            String key = list.get(i);
            String value = map.get(key);
            sb.append(key + ":" + value);
        }
        return "{" + sb + "}";
    }

    public static void main(String[] args) {
        // Query string problem
        // Input : name=alice&age=8&city=seoul&age=30
        // Output: {"name":"alice", "age":"30", "city":"seoul"}
        // Rules : same key twice -> keep the longer value
        //         print in order of first appearance
        Solution01 s = new Solution01();
        // System.out.println(s.solution2("name=alice&age=8&city=seoul&age=30"));
        System.out.println(s.solution2("name=&age=8&city=seoul&age=30"));

    }

}
