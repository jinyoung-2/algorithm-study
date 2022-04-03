package BOJ;

// [백준] Bronze3 피보나치 수

import java.util.Arrays;
import java.util.Scanner;

class Fibo {
    private int[] dp;

    public Fibo(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        // base case
        dp[0] = 0;
        dp[1] = 1;
    }

    public int calc(int n) {
        if(dp[n] != -1) return dp[n];
        dp[n] = calc(n - 1) + calc(n - 2);
        return dp[n];
    }
}

class Fibo2 {
    private int[] dp;

    public Fibo2(int n) {
        dp = new int[n + 1];
        // base case
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    }

    public int calc(int n) {
        return dp[n];
    }
}

public class BOJ_2747 {
    static int fibo(int n) {
        if(n==0 || n==1) return n;
        return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

//        System.out.println(fibo(n));
//
//        Fibo F = new Fibo(n);
//        System.out.println(F.calc(n));

        Fibo2 F2 = new Fibo2(n);
        System.out.println(F2.calc(n));
    }
}
