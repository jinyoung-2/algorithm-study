package Assignment;

// 프로그래머스 Lv.2 구명보트
// https://programmers.co.kr/learn/courses/30/lessons/42885

import java.util.Arrays;

public class PG_Lifeboat {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] people = {70,50,80,50};   //몸무게를 담은 배열
        int limit = 100;  //구명보트의 무게 제한
        int answer = sol.solution(people, limit);
        System.out.println(answer);
    }

    static class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;     //필요한 구명보트의 최소 개수
            Arrays.sort(people);
            int smallIdx=-1;
            int bigIdx=people[people.length-1];
            int sum = people[bigIdx];;
            boolean switchBtn = true; //false: smallIdx, true: bigIdx 이용

            while(true){

                if(switchBtn){  //bigIdx 이용
                    if(sum > limit){
                        sum-=people[bigIdx];
                        switchBtn=false;
                        smallIdx++;
                    }
                    else if(sum == limit){
                        answer++;
                        sum=0;
                        switchBtn=true;
                        // smallIdx or bigIdx 이동
                    }
                    else{   //sum < limit

                    }
                }
                else{   //smallIdx 이용

                }
            }

            return answer;
        }
    }
}