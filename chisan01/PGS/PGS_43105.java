package PGS;

// [프로그래머스] Lv.3 정수 삼각형

import java.util.Arrays;

class Triangle {
    private int[][] triangle;
    private int[][] dp;

    public Triangle(int[][] triangle) {
        this.triangle = triangle;
        this.dp = new int[triangle.length][triangle.length];
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }
        // base case : 바닥 층
        int y = triangle.length-1;
        for(int x=0; x<triangle.length; x++) {
            dp[y][x] = triangle[y][x];
        }
    }

    private int f(int y, int x) {
        // base case
        if(dp[y][x] != -1) return dp[y][x];

        dp[y][x] = Math.max(f(y + 1, x), f(y + 1, x + 1)) + triangle[y][x];
        return dp[y][x];
    }

    public int getMaxRoute() {
        return f(0, 0);
    }
}

public class PGS_43105 {
    public int solution(int[][] triangle) {
        Triangle T = new Triangle(triangle);
        return T.getMaxRoute();
    }
}