package Assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 실버4 미로만들기

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

    // 좌표이동할 때 자주 사용하는 기법 => 방향에 따른 X, Y값 설정
    //오답: 아래, 오른, 위, 왼 => 반시계방향
    //정답: 위, 오른, 아래, 왼 => 시계방향
    static int[] dirY = {-1, 0, 1, 0};  //y축으로 -1이동은 위로 올라가는 것이다!
    static int[] dirX = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int row = 1, col = 1;
        char[] arr[] = new char[101][101];
        // row와 col이 1부터 시작하므로, 배열은 1~100까지 값을 갖기 위해 101로 크기 설정
        // => "길이는 0보다 크고, 50보다 작다" 문제 조건 이용함

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                arr[i][j] = '#';    //default 설정
            }
        }

        /**
         * 유의사항: dirX와 dirY가 2차원 배열의 Row와 Col 중 어떤 것과 연관되는지 잘 파악하기!
         *          X좌표와 Y좌표가 2차원 배열의 Row와 Col 중 어떤 것과 연관되는지 잘 파악하기!
         *          => 정답과 반대로 생각했음
         * */
        int startX, startY;         //홍준이의 실시간 위치
        int minRow, maxRow, minCol, maxCol; //직사각형 성질을 이용하기 위해 사용하는 변수들
        startX = startY = minRow = minCol = maxRow = maxCol = 50;   // 직사각형 미로의 한 가운데 위치로 설정
        int dir = 2;  //홍준이의 실시간 방향(처음 방향은 남쪽으로 아래방향을 향함)
        arr[startY][startX] = '.';  //홍준이가 처음 위치한 곳은 움직일 수 있는 칸으로, '.'로 설정
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'F') {

                // 실시간 홍준이의 위치를 이동한 위치로 설정
                startX += dirX[dir];
                startY += dirY[dir];

                // 이동한 위치는 움직일 수 있는 곳으로, '.'로 설정
                arr[startY][startX] = '.';

                // min/max Row 및 Col값 재설정
                maxCol = Math.max(maxCol, startX);
                maxRow = Math.max(maxRow, startY);
                minCol = Math.min(minCol, startX);
                minRow = Math.min(minRow, startY);

            } else if (str.charAt(i) == 'L') { //반시계방향
                // Q. R이 아니라 L인 이유는 무엇인가?
                // A. dirX와 dirY배열을 시계방향인데 반시계방향으로 착각함
                if (dir == 0)
                    dir = 3;
                else
                    dir--;

            } else if (str.charAt(i) == 'R') { //시계방향
                if (dir == 3)
                    dir = 0;
                else
                    dir++;
            }
        }

        // 미로 지도 출력
        for (int i = minRow; i <= maxRow; i++) {
            for (int j = minCol; j <= maxCol; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}

//참고: https://ukyonge.tistory.com/112