package PGS;

// 프로그래머스 Lv.2 더 맵게

import java.util.*;

class Solution {
    public int solution(int[] scovilles, int K) {
        PriorityQueue<Integer> Q = new PriorityQueue<>();
        for (int scoville : scovilles) {
            Q.add(scoville);
        }

        int cnt = 0;
        while (Q.size() >= 2 && Q.peek() < K) {
            int firstScovile = Q.poll();
            int secondScovile = Q.poll();
            Q.add(firstScovile + secondScovile * 2);
            cnt++;
        }

        if (Q.peek() < K) return -1;
        else return cnt;
    }
}