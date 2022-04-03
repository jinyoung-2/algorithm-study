package PGS;

// 프로그래머스 Lv.2 구명보트

import java.util.*;

public class PGS_42885 {
    public int solution(int[] people, int limit) {
        List<Integer> weights = new ArrayList<>();
        for (int weight : people) {
            weights.add(weight);
        }
        weights.sort((a, b) -> b - a);

        int boatCount = 0;
        int startIndex = 0;
        int endIndex = weights.size() - 1;
        while (startIndex <= endIndex) {
            int curWeight = weights.get(startIndex++);
            boatCount++;
            if(startIndex > endIndex) break;
            if(curWeight + weights.get(endIndex) <= limit) {
                endIndex--;
            }
        }

        return boatCount;
    }
}
