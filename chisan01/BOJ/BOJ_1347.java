package BOJ;

// [백준] 실버4 미로 만들기

import java.util.Scanner;

class HongjunMap {
    private final char[][] map = new char[100][100];
    // 남 서 북 동
    private final int[] dx = {0, -1, 0, 1};
    private final int[] dy = {1, 0, -1, 0};
    // 홍준이가 바라보고 있는 방향
    private int hongjunDir;
    // 홍준이의 현재 위치
    private int hongjunPosX;
    private int hongjunPosY;
    // 지도의 범위를 알기 위해 필요한 값들
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;

    public HongjunMap() {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                map[y][x] = '#';
            }
        }
        // 홍준이는 미로 안의 한 칸에 남쪽을 보며 서 있다.
        hongjunDir = 0;
        // 최대 같은 방향으로 49번 움직일 수 있으므로
        hongjunPosX = 49;
        hongjunPosY = 49;
        map[hongjunPosY][hongjunPosX] = '.';
        // 출력 범위 지정
        minX = 49;
        maxX = 49;
        minY = 49;
        maxY = 49;
    }

    private void turnLeft() {
        hongjunDir--;
        hongjunDir = (hongjunDir + 4) % 4;
    }

    private void turnRight() {
        hongjunDir++;
        hongjunDir = hongjunDir % 4;
    }

    private void moveFront() {
        hongjunPosY += dy[hongjunDir];
        hongjunPosX += dx[hongjunDir];
        map[hongjunPosY][hongjunPosX] = '.';
        minX = Math.min(minX, hongjunPosX);
        maxX = Math.max(maxX, hongjunPosX);
        minY = Math.min(minY, hongjunPosY);
        maxY = Math.max(maxY, hongjunPosY);
    }

    public void makingMap(String moves) {
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'R':
                    turnRight();
                    break;
                case 'L':
                    turnLeft();
                    break;
                case 'F':
                    moveFront();
                    break;
                default:
                    break;
            }
        }
    }

    public void printMap() {
        for (int y = minY; y <= maxY; y++) {
            for (int x = minX; x <= maxX; x++) {
                System.out.print(map[y][x]);
            }
            System.out.print('\n');
        }
    }
}

public class BOJ_1347 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputStringSize = sc.nextInt();
        String moves = sc.next();

        HongjunMap HM = new HongjunMap();
        HM.makingMap(moves);
        HM.printMap();

        sc.close();
    }
}
