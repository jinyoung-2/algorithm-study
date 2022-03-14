package Assignment;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

// 백준 실버3 상근이의 여행
//https://www.acmicpc.net/problem/9372
public class BOJ_9372 {
    public static void main(String[] args) {
        /**
         * N개국 여행 => "최대한 적은 종류"의 비행기 타고 "모든 국가" 이동
         *
         * */


        // 입력
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();   //테스트 케이스의 수

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt(); //국가의 수
            int M = sc.nextInt(); //비행기 종류
            int[] arr[] = new int[M][2];
            int minCnt = 0;   //비행기 종류의 최소 개수
            for (int j = 0; j < M; j++) {
                arr[j][0] = sc.nextInt();   //a
                arr[j][1] = sc.nextInt();   //b
            }

            // 핵심로직 - DFS
            Stack<Integer> stack = new Stack<>();
            boolean[] check = new boolean[M];
            Arrays.fill(check, false);
            int rootNode = arr[0][0];
            int firstChildNode = arr[0][1];

            for (int j = 0; j < M; j++) {

                if (rootNode == arr[j][0] || rootNode == arr[j][1]) {   //firstChildNode 달라진 경우

                }
                if (check[(arr[j][0])] && check[arr[j][1]]) {
                    continue;
                }
                stack.push(arr[j][0]);
                stack.push(arr[j][1]);

            }
            //M개의 줄이 끝났을 때 + stack에 값이 존재할 때
            if (!stack.isEmpty())
                minCnt += stack.size();
            while (!stack.isEmpty()) {       //초기화시킴
                stack.pop();
            }

            // 출력 - 비행기 종류의 최소 개수
            System.out.println(minCnt);
        }
    }
}

//Q. 테스트 케이스별 입력이 다 된 후에야, 모든 출력? 아니면 테스트 케이스별로 입력된 후에, 해당 테스트케이스만 출력?
