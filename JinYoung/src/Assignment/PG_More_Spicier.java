package Assignment;

import java.util.PriorityQueue;
import java.util.Queue;

class PG_More_Spicier {
    public int solution(int[] scoville, int K) {

        /**
         * Min Heap 자료구조 이용해 우선순위 큐를 규현한다.
         * */
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i< scoville.length;i++){
            pq.offer(scoville[i]);
        }

        int answer = 0;
        boolean isRight = true;
        while(!pq.isEmpty()){
            int headNode = pq.poll();
            if(headNode<K){
                if(pq.peek()!=null){    //성공
                    int newNode = headNode + pq.poll() * 2;
                    pq.offer(newNode);
                    answer++;
                }
                else    //실패
                    isRight = false;
            }
            else    //성공
                break;
        }
        if(!isRight)
            return -1;
        return answer;
    }
}


// 위의 코드를 좀 더 간결하게 수정하면...
class Solution{
    public int solution(int[] scoville, int K){
        Queue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<scoville.length;i++)
            pq.offer(scoville[i]);

        int count = 0;
        while(pq.size() > 1 && pq.peek() < K){
            int headNode = pq.poll();
            int leftChildNode = pq.poll();
            pq.offer( headNode + (leftChildNode * 2));
            count++;
        }

        if(pq.size() <= 1 && pq.peek() < K)
            count = -1; //모든 음식의 스코빌 지수를 K이상으로 만들 수 없는 경우
        return count;
    }
}



//class Solution {
//    public int solution(int[] scoville, int K) {
//
//        Queue<Integer> pq = new PriorityQueue<>();
//        for(int i=0;i< scoville.length;i++){
//            pq.offer(scoville[i]);
//        }
//
//        int answer = 0;
//        while(!pq.isEmpty()){
//            int headNode = pq.poll();
//            if(headNode<K){
//                if(pq.peek()!=null){    //성공
//                    int newNode = headNode + pq.poll() * 2;
//                    pq.offer(newNode);
//                    answer++;
//                }
//                else    //실패
//                    return -1;
//            }
//            else   //성공
//                return answer;
//        }
//        return answer;    //이 부분을 작성 안 해줘서 에러발생했음 (error: missing return statement)
//                          => 처음에 while문 조건식에 false일 수도 있는데, 그 때 return 처리를 해주지 않으므로 에러 발생
//    }
//}