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

// 1번째 풀이 
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


// 2번째 풀이
public class BOJ_23968 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //배열의 크기
        int K = sc.nextInt();    //교환 횟수
        int[] A = new int[N+1];
        for(int i=1;i<=N;i++){
            A[i]=sc.nextInt();
        }
        bubble_sort(A,K);

    }

    static void bubble_sort(int[] A,int K){ //A[1..N]을 오름차순 정렬
        int cnt=0;
        boolean isOut = false;
        for(int last=A.length;last>=2;last--){
            for(int i=1;i<=last-1;i++ ){
                if (A[i] > A[i + 1]) {
                    // swap( );
                    int temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;

                    cnt++;
                    if(cnt==K){
                        //K 번 교환이 발생한 직후의 배열 A를 한 줄에 출력
                        System.out.printf("%d %d",A[i],A[i+1]);
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

