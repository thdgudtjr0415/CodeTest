import java.util.*;

public class Solution01 {
    public static String solution01(String quryString) {
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
    public static void main(String[] args) {
        // Query string problem
        // Input : name=alice&age=8&city=seoul&age=30
        // Output: {"name":"alice", "age":"30", "city":"seoul"}
        // Rules : same key twice -> keep the longer value
        //         print in order of first appearance
        Solution01 s = new Solution01();
        System.out.println(solution01("name=alice&age=8&city=seoul&age=30"));

    }

}
