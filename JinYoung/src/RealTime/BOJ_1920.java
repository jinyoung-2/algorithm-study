package RealTime;

import java.util.Arrays;
import java.util.Scanner;

// BinarySearch
public class BOJ_1920 {
    public static int[] A;
    public static int[] B;

    public static int binarySearch(int key) {
        int low = 0;
        int high = A.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (key == A[mid])
                return 1;
            else if (key < A[mid]) {
                high = mid - 1;
            } else {   //key>mid
                low = mid + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A); // 배열은 반드시 정렬되어 있어야 한다.

        int M = sc.nextInt();
        B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            System.out.println(binarySearch(B[i]));
        }
    }
}