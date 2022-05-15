package RealTime;

import java.util.Scanner;

// Bottom-Up 방식 => for문(반복문)
//public class BOJ_2747 {
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        int[] di = new int[46]; //1~45
//        di[0] = 0;
//        di[1] = 1;
//        di[2] = 1;
//        int n = sc.nextInt();
//
//        for (int i = 2; i <= n; i++) {
//            di[i] = di[i - 1] + di[i - 2];
//        }
//
//        System.out.println(di[n]);
//    }
//}


// Top-Down 방식 => 재귀함수
public class BOJ_2747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 한 번 계산된 결과를 메모이제이션하기 위한 리스트 초기화
        int[] di = new int[46]; //1~45
        int n = sc.nextInt();
        System.out.println(fibo(di,n));
    }

    static int fibo(int[] di, int x){
        // 종료조건
        if(x==0) return 0;
        if(x==1||x==2) return 1;

        // 이미 계산된 적 있는 문제라면 그대로 반환
        if(di[x]!=0){
            return di[x];
        }
        // 아직 계산하지 않은 문제라면 점화식에 따라서 피보나치 결과 반환
        di[x] = fibo(di,x-1)+fibo(di,x-2);
        return di[x];
    }
}