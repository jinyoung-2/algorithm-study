package Assignment;

// 프로그래머스 Lv.2 구명보트
// https://programmers.co.kr/learn/courses/30/lessons/42885

import java.util.Arrays;

public class PG_Lifeboat {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] people = {70, 50, 80, 50};   //몸무게를 담은 배열
        int limit = 100;  //구명보트의 무게 제한
        int answer = sol.solution(people, limit);
        System.out.println(answer);
    }

    static class Solution {
        public int solution(int[] people, int limit) {
            Arrays.sort(people);    // 오름차순 정렬
            int minCnt = 0;     //필요한 구명보트의 최소 개수
            int maxIndex = people.length - 1;
            int minIndex = 0;

            while (true) {
                // Case1. 최댓값 + 최솟값 > limit인 경우, 최댓값 무게인 사람만 구명보트 태우기
                if (people[maxIndex] + people[minIndex] > limit) {
                    minCnt++;
                    maxIndex--;
                }
                // Case2. 최댓값 + 최솟값 = limit인 경우, 2명 모두 구명보트 태우기
                // Case3. 최댓값 + 최솟값 < limit인 경우, 이래도 2명 초과해서 더 태울 수 없음 (최대 2명 탑승)
                else {  //people[maxIndex] + people[minIndex] <= limit
                    minCnt++;
                    maxIndex--;
                    minIndex++;
                }
                
                // 종료조건
                if (maxIndex == minIndex) {
                    minCnt++;
                    break;
                }
                if (maxIndex < minIndex) {
                    break;
                }
            }
            return minCnt;
        }
    }
}