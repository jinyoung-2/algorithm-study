package BOJ;

// 백준 실버2 로또

import java.util.*;

class GermanLotto {
    int[] S;
    boolean[] check;

    public GermanLotto(int[] S) {
        this.S = S;
        this.check = new boolean[S.length];
        Arrays.fill(check, false);
    }

    private void printMethod(int index, int cnt) {
        if(cnt == 6) {
            for(int i=0; i<check.length; i++) {
                if(check[i]) {
                    System.out.print(S[i] + " ");
                }
            }
            System.out.print("\n");
            return;
        }
        if(index == S.length) return;

        for(int i=index; i<S.length; i++) {
            check[i] = true;
            printMethod(i+1, cnt+1);
            check[i] = false;
        }
    }

    public void printAllMethod() {
        printMethod(0, 0);
    }
}

public class BOJ_6603 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int k = sc.nextInt();
            if(k == 0) break;

            int[] S = new int[k];
            for(int i=0; i<k; i++) {
                S[i] = sc.nextInt();
            }

            GermanLotto GL = new GermanLotto(S);

            GL.printAllMethod();
            System.out.println();
        }
    }
}
