package RealTime;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BOJ_2012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //학생 수
        int[] expectedRanking = new int[N]; //예상등수
        int[] countExpected = new int[N];   //예상등수 중 동일석차 개수 파악
        int answer = 0;

        for (int i = 0; i < N; i++) {
            expectedRanking[i] = sc.nextInt();
            countExpected[expectedRanking[i]-1]++;
        }

        List<Integer> notExistedRankingList = new ArrayList<>();
        for(int i=0;i<N;i++){
            if(countExpected[i]==0){
                notExistedRankingList.add(i+1);
            }
        }

        Iterator<Integer> iterable = notExistedRankingList.iterator();
        for(int i=0;i<N;i++){
            if(countExpected[i]>=2){
                while(iterable.hasNext()){
                    if(countExpected[i]<=0)
                        break;
                    countExpected[i]--;
                    answer+= Math.abs((i+1)-iterable.next());
                }
            }
            else
                continue;
        }


        System.out.println(answer); //불만도의 최소합 출력
    }
}
