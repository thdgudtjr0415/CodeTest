package programmers.basics.Day31;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 배열의길이에따라다른연산하기Test {

    @Test
    void solution() {
        배열의길이에따라다른연산하기 s = new 배열의길이에따라다른연산하기();

        // 🌟 아까 작성해 둔 정답 검증용 세트 채워 넣기!
        assertArrayEquals(new int[]{76, 12, 127, 276, 60}, s.solution(new int[]{49, 12, 100, 276, 33}, 27));
        assertArrayEquals(new int[]{444, 655, 666, 877}, s.solution(new int[]{444, 555, 666, 777}, 100));
    }
}