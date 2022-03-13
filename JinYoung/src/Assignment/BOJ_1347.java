package Assignment;

package Assignment;

import java.util.Scanner;

// 백준 실버4 미로만들기
//https://www.acmicpc.net/problem/1347

/**
 * 홍준이 현 위치: 미로 안의 한 칸에 남쪽보며 서 있음
 * 각 칸은 이동 or 벽 포함
 * 각 문자 하나는 한 번의 움직임
 * => F: 앞으로 이동
 * => L: 왼쪽으로 방향 전환 / R: 오른쪽으로 방향 전환  => 칸의 이동 X, only 방향만 바뀜
 * <p>
 * 출력: ‘.’은 이동할 수 있는 칸이고, ‘#’는 벽임
 */
public class BOJ_1347 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 홍준이가 적은 내용의 길이
        int length = sc.nextInt();
        if (length <= 0 || length >= 50) {
            return;
        }

        // 홍준이가 적은 내용
        char[] arr = new char[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextLine().charAt(0);
        }

        // 미로 최대 배열
        char[] result[] = new char[101][101];   // check
        int minRow = 1, maxRow = 1;
        int minCol = 1, maxCol = 1;
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = '#'; //default
            }
        }
        int x = 50, y = 50;         //현재 위치
        int[] dirX = {0,1,0,-1};    // 왼 위 오른 아래
        int[] dirY = {0,-1,0,1};    // 왼 위 오른 아래
        int nowDirX = 0, nowDirY=0; //dirX와 dirY의 현재값

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'F') {    // 이동

                //
                minCol = Math.min(minCol,);
                maxCol = Math.max(maxCol,);
                minRow = Math.min(minRow,);
                maxRow = Math.max(maxRow,);

            } else if (arr[i] == 'R') { //시계방향
                nowDirX
            } else if (arr[i] == 'L') { //반시계방향
                nowDirX

            }
        }

        // 미로 지도 출력
        for (int i = minRow - 1; i < maxRow - 1; i++) {
            for (int j = minCol - 1; j < maxCol - 1; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
