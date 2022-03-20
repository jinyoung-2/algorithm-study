package RealTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * DFS 개념 + 재귀함수
 * <p>
 * Class로 코드를 작성하는 것이 전체적인 구조 파악과 이해하기 쉽다.
 * * => Class로 코드 작성하는 거 추천함!!
 */

public class BOJ_6603 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true) {
            int k = sc.nextInt();
            if (k == 0)
                break;

            int[] S = new int[k];
            for (int i = 0; i < k; i++) {
                S[i] = sc.nextInt();       //오름차순으로 주어짐
            }

            GermanLotto GL = new GermanLotto(S);

            GL.printAllMethod();
            System.out.println();
        }
    }
}


/**
 * 치산's 풀이) check Arr을 true/false로 열었다/닫았다 하는 방식
 * */
class GermanLotto{
    int[] S;
    boolean[] check;

    public GermanLotto(int[] S) {
        this.S = S;
        this.check = new boolean[S.length];
        Arrays.fill(check, false);   // Arrays.fill(배열, 값) : 배열을 값으로 전부 채우기
    }

    private void printMethod(int index, int cnt){
        if(cnt == 6){
            for(int i=0;i< check.length;i++){
                if(check[i]){
                    System.out.print(S[i] + " ");
                }
            }
            System.out.println();
            return ;
        }

        if(index==S.length)
            return ;

        /**
         * 핵심 코드
         * */
        for(int i=index;i<S.length;i++){
            check[i]=true;
            printMethod(i+1, cnt+1);
            check[i]=false;
        }
    }

    public void printAllMethod() {
        printMethod(0, 0);
    }
}


/**
 * 문형's 풀이) 정답 배열에다 "덮어쓰기" 추천
 * DFS의 경우 - "덮어쓰기" 방법 자주 사용함 => 백트래킹
 * */
class GermanLotto {
    int[] S;
    List<Integer> answerList;    //정답배열

    public GermanLotto(int[] S) {
        this.S = S;
        this.answerList = new ArrayList<>(6);
    }

    private void printMethod(int index, int cnt) {
        if (cnt == 6) {
            for (int i = 0; i < answerList.size(); i++) {
                System.out.print(answerList.get(i) + " ");
            }
            System.out.println();
            return;
        }

        if (index == S.length)
            return;

        /**
         * 핵심 코드
         * 치산's 풀이) check Arr을 true/false로 열었다/닫았다 하는 방식
         * */
        for (int i = index; i <S.length;i++){
            answerList.add(S[i]);
            printMethod(i+1,cnt+1);
            answerList.remove(i);
        }
    }

    public void printAllMethod() {
        printMethod(0, 0);
    }
}

