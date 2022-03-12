package PGS;

// 프로그래머스 Lv.2 큰 수 만들기

import java.util.*;

public class PGS_42883 {
    public static String solution(String number, int k) {
        for (int i = 0; i < number.length() - 1; i++) {
            if (k <= 0) break;
            if (number.charAt(i) >= number.charAt(i + 1)) continue;
            number = number.substring(0, i) + number.substring(i + 1, number.length());
            k--;
            i = Math.max(-1, i - 2);
        }
        if (k > 0) {
            number = number.substring(0, number.length() - k);
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
    }
}
