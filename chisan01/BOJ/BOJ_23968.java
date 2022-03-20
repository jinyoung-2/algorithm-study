package BOJ;

// [백준] Bronze1 알고리즘 쉅 - 버블 정렬 1

import java.util.Scanner;

public class BOJ_23968 {
    static void bubble_sort(int[] A, int K) {
        int changeCount = 0; // 교환횟수
        for (int last = A.length; last >= 2; last--) {
            for (int j = 0; j < last - 1; j++) {
                if(A[j] > A[j+1]) {
                    changeCount++;
                    if(changeCount == K) {
                        System.out.println(A[j+1] + " " + A[j]);
                    }
                    int tmp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = tmp;
                }
            }
        }
        if(changeCount < K) {
            System.out.println("-1");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 배열의 크기
        int K = sc.nextInt(); // 교환 횟수

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        bubble_sort(A, K);
    }
}
