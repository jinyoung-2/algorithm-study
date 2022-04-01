package PGS;

// 프로그래머스 Lv.3 N으로 표현

import java.util.Arrays;

class Calc {
    private final int N;

    public Calc(int N) {
        this.N = N;
    }

    public int calc(int number, int count) {
        // base case
        if(number == 0) return count;
        if (count > 8) return 987654321;

        int ret = calc(number - N, count + 1);
        ret = Math.min(ret, calc(number + N, count + 1));
        ret = Math.min(ret, calc(number / N, count + 1));
        ret = Math.min(ret, calc(number * N, count + 1));

        return ret;
    }
}

public class PGS_42895 {
    public int solution(int N, int number) {
        Calc C = new Calc(N);
        return C.calc(number, 0);
    }
}
