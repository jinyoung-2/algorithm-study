package Assignment;

import java.io.IOException;
import java.util.*;

public class PG_Making_big_number {
    public static void main(String[] args) throws IOException {

        /**
         * String인 number에서 K개의 수 제거
         * = number.length() - K 개의  수 선택
         *
         * ex) 23563850135에서 4개의 수 제거 = 12-4인 8개의 수 선택
         * */

        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        int k = sc.nextInt();
        StringBuilder answer = new StringBuilder();

        int idx = 0;    //선택된 문자의 index값
        int comp = 0;   //선택된 문자의 숫자값
        for (int i = number.length() - k; i > 0; i--) {   //남은 선택할 문자의 개수
            comp = number.charAt(idx) - '0';  //선택할 문자 초기화
            for (int j = idx; j <= number.length() - i; j++) {   //최댓값 찾는 루프 => Q. 여기 조건식을 어떻게 작성해야할지 모르겠습니다.
                if (comp < number.charAt(j) - '0') {
                    comp = number.charAt(j) - '0';
                    idx = j + 1;
                }
            }
            answer.append(comp);
        }
        System.out.println(answer.toString());
    }
}

/**
 * 재귀적으로 구현할 수 있지만 고려해줘야 할 조건도 많고 구현 난이도도 어려워서 숫자를 하나씩 빼는 접근법이 더 간결할 것 같다.
 * => 가장 기본적인 방식(양 옆 값과 비교, 문자열 자르기, 나뉜 문자열 붙이기)
 * => 안치산 풀이 참고하기!
 * */

// 참고자료: https://ukyonge.tistory.com/197
