package RealTime;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11657 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   //도시개수
        int M = sc.nextInt();   //버스개수

        int[] A = new int[M];
        int[] B = new int[M];
        int[] C = new int[M];

        for(int i=0;i<M;i++){
            A[i]=sc.nextInt();
            B[i]=sc.nextInt();
            C[i]=sc.nextInt();
        }

        int[] result = new int[N];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;

        //갱신여부 check
        boolean[] checkUpdate = new boolean[N]; //false이면, 갱신불가
        Arrays.fill(checkUpdate,true);


        //출력
    }
}