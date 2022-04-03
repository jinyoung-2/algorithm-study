package RealTime;

import java.util.*;

public class BOJ_2012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //학생 수
        int[] expectedRanking = new int[N]; //예상등수
        int[] countExpected = new int[N];   //예상등수 중 동일석차 개수 파악
        long answer = 0;

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
                countExpected[i]--;
                while(iterable.hasNext()){
                    if(countExpected[i]<=0)
                        break;
                    countExpected[i]--;
                    answer+= Math.abs((i+1)-iterable.next());
                }
            }
            else {
                continue;
            }
        }
        System.out.println(answer); //불만도의 최소합 출력
    }
}


// 올바른 풀이
/**
 * 문제 풀이 방법
 * 해당 문제는 기본적인 그리디 알고리즘 문제로 배열을 sort하여 학생의 등수를 구하고
 * sort를 통해 구한 등수와 학생들의 예상등수의 차이를 합하면 되는 간단한 문제이다.
 *
 * 단, 모든 학생이 1등을 희망하고 학생 수가 많을 경우
 * 불만도의 값이 int범위를 넘어갈 수 있으므로 결과를 담는 변수는 long타입으로 만들어줘야 한다.
 *
 * cf) int범위: -2,147,483,648 ~2,147,483,647
 * */

/*
class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int B = 1;		// 실제 등수
        long sum = 0;	// 불만도 합 최솟값
        int[] arr = new int[N];

        for(int i=0; i<arr.length; i++)
            arr[i] = scan.nextInt();

        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++) {
            sum += Math.abs(arr[i] - (i+1));
        }

        System.out.println(sum);
        scan.close();
    }
}
 */