package Assignment;

import java.util.Scanner;

// 백준 실버3 상근이의 여행
//https://www.acmicpc.net/problem/9372
public class BOJ_9372 {
    public static void main(String[] args) {
        /**
         * N개국 여행 => "최대한 적은 종류"의 비행기 타고 "모든 국가" 이동
         * */
        // 입력
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();   //테스트 케이스의 수

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt(); //국가의 수
            int M = sc.nextInt(); //비행기 종류
            int minCnt = 0;   //비행기 종류의 최소 개수
            for (int j = 0; j < M; j++) {
                int a = sc.nextInt();   //a
                int b = sc.nextInt();   //b
            }

            // 출력 - 비행기 종류의 최소 개수 = (국가의 수 - 1))
            minCnt = N-1;
            System.out.println(minCnt);
        }
    }
}