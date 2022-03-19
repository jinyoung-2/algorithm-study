package BOJ;

// [백준] Silver3 숫자 정사각형

import java.util.Scanner;

class Rectangel {
    private final int N;
    private final int M;
    private final int[][] numbers;

    public Rectangel(int N, int M, int[][] numbers) {
        this.N = N;
        this.M = M;
        this.numbers = numbers;
    }

    // 한변의 길이가 lengthOfOneSide인 정사각형이 존재할 수 있는지 체크
    private boolean checkSquare(int lengthOfOneSide) {
        for (int y = 0; y + lengthOfOneSide - 1 < N; y++) {
            for (int x = 0; x + lengthOfOneSide - 1 < M; x++) {
                if (numbers[y][x] == numbers[y + lengthOfOneSide - 1][x]
                        && numbers[y][x] == numbers[y][x + lengthOfOneSide - 1]
                        && numbers[y][x] == numbers[y + lengthOfOneSide - 1][x + lengthOfOneSide - 1])
                    return true;
            }
        }
        return false;
    }

    public int getMaxSquareSize() {
        int lengthOfOneSide = Math.max(N, M);
        for (; lengthOfOneSide > 1; lengthOfOneSide--) {
            if (checkSquare(lengthOfOneSide)) break;
        }
        return lengthOfOneSide * lengthOfOneSide;
    }
}

public class BOJ_1051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] numbers = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < M; j++) {
                numbers[i][j] = input.charAt(j) - '0';
            }
        }

        Rectangel rectangel = new Rectangel(N, M, numbers);
        System.out.println(rectangel.getMaxSquareSize());
    }
}
