package RealTime;

import java.util.Scanner;

public class BOJ_6603 {
    public static void main(String[] args) {

        /**
         *  전략은 49가지 수 중 k(k>6)개의 수를 골라 집합 S를 만든 다음 그 수만 가지고 번호를 선택하는 것
         *  */

        Scanner sc = new Scanner(System.in);
        while (true) {
            int k = sc.nextInt();
            if (k == 0 || k <= 6 || k >= 13)
                break;
            int[] S = new int[k];
            for (int i = 0; i < k; i++) {
                S[i] = sc.nextInt();       //오름차순으로 주어짐
            }
            //출력 (사전 순으로 출력됨)
            print(S, k);
        }
    }

    static void print(int[] S, int k) {   //재귀함수 이용
        int startIdx;
        int cnt;   // 총 경우의 수

        if (cnt == 0) {   //종료조건
            System.out.println();   //각 테스트 케이스 사이에는 빈 줄을 하나 출력
            return;
        } else {   //성공조건
            for (int i = 0; i < S.length; i++) {
                if () {  // i ==
                    continue;
                }
                System.out.println(S[i] + " ");
            }
            cnt--;
            return print(S, k);  //재귀함수 호출
        }
    }
}
