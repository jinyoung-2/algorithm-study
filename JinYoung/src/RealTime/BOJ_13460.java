package RealTime;

import java.util.Arrays;
import java.util.Scanner;

// 백준 - 구슬 탈출 2 / 골드 1 / 브루트포스
public class BOJ_13460 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 3 ≤ N, M ≤ 10
        int N=sc.nextInt(); //세로
        int M=sc.nextInt(); //가로
        char[][] arr = new char[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                arr[i][j] = sc.nextLine().charAt(0);
            }
        }
        int cnt=0;

        //로직
        findCnt(M,N,arr);
    }

    static int[] findLocation(int M, int N, char[] arr[], char ch){
        int[] location = new int[2];

        for(int i=1;i<N-1;i++){
            for(int j=1;j<M-1;j++){
                if(arr[i][j] == ch){
                    location[0] = i;
                    location[1] = j;
                    return location;
                }
            }
        }
        return location;
    }
    static void findCnt(int M, int N, char[] arr[]){
        int cnt = 0;    //Red의 이동횟수
        int[] locationR = new int[2];
        int[] locationB = new int[2];
        int[] locationO = new int[2];

        //find Red 위치
        locationR = findLocation(M,N,arr,'R');

        //find Blue 위치
        locationB = findLocation(M,N,arr,'B');

        //find 구멍 위치
        locationO = findLocation(M,N,arr,'O');

        while(true){

            if(cnt>10){ //실패
                System.out.println(-1);
                return ;
            }

            //main logic: BFS 이용 - Red & Blue의 이동
            //단, 가장자리 및 장애물이 존재하는 방향으로는 이동 불가

            //Red 이동 -> 4가지 방향 모두 고려해야 함


            //Blue 이동

            // 이동한 경우
            cnt++;

            // Red/Blue 위치 index 변경
//            locationR[0] =
//            locationR[1] =
//            locationB[0] =
//            locationB[1] =

            if(Arrays.equals(locationR,locationO)) {      //Red와 구멍 위치 동일
                System.out.println(cnt);
                return ;
            }
            else if(Arrays.equals(locationB,locationO)) {   //Blue와 구멍 위치 동일 => 실패
                System.out.println(-1);
                return ;
            }
            else if(Arrays.equals(locationB,locationO) && Arrays.equals(locationR,locationO)){  //Red와 Blue가 동시에 구멍위치와 동일 => 실패
                System.out.println(-1);
                return ;
            }
        }
    }
}

/**
 * DFS: 미로에서 나가기만 하면 됨
 * BFS: 미로에서 최소구할 떄 => queue 자료구조 많이 사용
 * */

