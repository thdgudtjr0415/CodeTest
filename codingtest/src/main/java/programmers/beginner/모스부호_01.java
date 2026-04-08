package programmers.beginner;

//morse = {
//    '.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e','..-.':'f',
//    '--.':'g','....':'h','..':'i','.---':'j','-.-':'k','.-..':'l',
//    '--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r',
//    '...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x',
//    '-.--':'y','--..':'z'
//}

//".... . .-.. .-.. ---" ->	"hello"
//".--. -.-- - .... --- -." -> "python"

/*
* 1. 이 문제는 공백으로 끊어야 함
* 2. split 으로 배열로 담은 다음 그걸 변환 하는 과정이 필요함
* */

import java.util.Arrays;

public class 모스부호_01 {
    public String solution(String letter) {
        String result = "";
        String[] morse = {
                ".-","-...","-.-.","-..",".","..-.","--.","....",
                "..",".---","-.-",".-..","--","-.","---",".--.",
                "--.-",".-.","...","-","..-","...-",".--","-..-",
                "-.--","--.."};
        // 이러면 공백 기준으로 뜯어서 배열로 담기
        String[] arr = letter.split(" ");

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < morse.length; j++){
                if(morse[j].equals(arr[i])){
                    result += (char)(j + 'a');
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        모스부호_01 p = new 모스부호_01();
        System.out.println(p.solution(".... . .-.. .-.. ---"));
        System.out.println(p.solution(".--. -.-- - .... --- -."));
    }
}
