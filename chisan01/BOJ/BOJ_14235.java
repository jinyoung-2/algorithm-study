package BOJ;

// [백준] Silver3 크리스마스 선물

import java.util.*;

public class BOJ_14235 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQueue<Integer> presents = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (a == 0) { // 아이들 만남
                if (presents.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(-presents.poll());
                }
            } else { // 선물 충전
                for (int j = 0; j < a; j++) {
                    int present = sc.nextInt();
                    presents.add(-present);
                }
            }
        }

        sc.close();
    }
}
