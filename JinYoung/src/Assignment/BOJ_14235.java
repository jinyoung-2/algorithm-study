package Assignment;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_14235 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 아이들과 거점지를 방문한 횟수
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            int a = sc.nextInt();
            if(a==0){
                if(pq.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(pq.poll());
            }
            else{
                for(int j=0;j<a;j++)
                    pq.offer(sc.nextInt());
            }
        }
    }
}
