package RealTime;

import java.util.Scanner;

// 백준 브론즈1 알고리즘 수업 - 버블 정렬 1
// https://www.acmicpc.net/problem/23968

/**
 * 알아두면 좋은 점...
 * 1. 컴퓨터가 1초 계산 -> 10억
 * 2. 이중 for문을 나오는 방법 - boolean형 변수를 이용해서 빠져나오기
 * 3. 문제에서 의사코드를 제시하면, 의사코드 방식대로 알고리즘 코드 작성하기
 * */

public class BOJ_23968 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //배열의 크기
        int K = sc.nextInt();    //교환 횟수
        int[] A = new int[N+1];
        for(int i=1;i<=N;i++){
            A[i]=sc.nextInt();
        }
        int cnt = 0;
        boolean isOut = false;
        //버블정렬
        for(int i=1;i<N;i++){
            for(int j=1;j<=N-i;j++){
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                    cnt++;
                    if(cnt==K){
                        //K번째 교환되는 2개의 수를 작은 수부터 출력
                        System.out.printf("%d %d",A[j],A[j+1]);
                        isOut=true;
                        break;
                    }
                }
            }
            if(isOut)
                break;
        }

        //출력
        if (cnt < K)
            System.out.println(-1);
    }
}


