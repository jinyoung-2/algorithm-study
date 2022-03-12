package RealTime;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //센서개수
        int K = sc.nextInt();   //집중국개수

        int[] location = new int[N];
        for(int i=0;i<N;i++){   //센서 좌표
            location[i] = sc.nextInt();
        }
        Arrays.sort(location); //센서 좌표 오름차순으로 정렬

        int[] distance = new int[N-1];  //센서간의 간격 array -> size: (센서개수-1)개
        for(int i=0;i<distance.length;i++){
            distance[i] = location[i+1]-location[i];
        }

        int cnt = 0;    //K개 집중국의 수신가능영역 길이의 합의 최솟값 = 연결된 구간 길이의 합의 최솟값
        Arrays.sort(distance);  //수신가능영역 array 오름차순으로 정렬

        // 수신가능영역 길이의 최소화를 위해...
        /*
         * 센서간의 거리 Array에서 (K-1)개를 선택하면, 집중국 K개가 설립됨
         * 센서간의 거리 Array에서 (K-1)개만큼 제거 = (N-1)-(K-1) = N-K개만큼 값 더하기
         **/

        // 집중국 K > 센서개수 N일 경우 boundary error 발생함
        // N개의 센서가 적어도 하나의 집중국과는 통신해야한다는 조건에 위배! => 이에 대한 예외처리 필요
        // 나의 코드에서는 아래 for문의 조건식이 예외처리로 작동함 => K>N이면, N-K<0으로 음수이므로 아래 for문이 작동하지 않아 에러 발생하지 않음
        for(int i=0;i<N-K;i++){
            cnt+=distance[i];
        }
        System.out.println(cnt);
    }
}