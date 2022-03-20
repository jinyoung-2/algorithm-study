package BOJ;

// 백준 실버2 로또

import java.util.*;

class GermanLotto {
    int[] S;

    public GermanLotto(int[] S) {
        this.S = S;
    }

    private void printMethod(int startIndex, int cnt, int[] method) {
        if (cnt == 6) {
            for (int item : method) {
                System.out.print(item + " ");
            }
            System.out.print("\n");
            return;
        }
        if (startIndex == S.length) return;

        for (int i = startIndex; i < S.length; i++) {
            method[cnt] = S[i];
            printMethod(i + 1, cnt + 1, method);
        }
    }

    public void printAllMethod() {
        int[] ret = new int[6];
        printMethod(0, 0, ret);
    }
}

public class BOJ_6603 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int k = sc.nextInt();
            if (k == 0) break;

            int[] S = new int[k];
            for (int i = 0; i < k; i++) {
                S[i] = sc.nextInt();
            }

            GermanLotto GL = new GermanLotto(S);

            GL.printAllMethod();
            System.out.println();
        }
    }
}
