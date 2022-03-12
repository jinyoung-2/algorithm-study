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
        for(int i=number.length()-k;i>0;i--){   //남은 선택할 문자의 개수
            comp = number.charAt(idx)-'0';  //선택할 문자 초기화
            for(int j=idx;j<=number.length()-i;j++){   //최댓값 찾는 루프 => Q. 여기 조건식을 어떻게 작성해야할지 모르겠습니다.
                if(comp < number.charAt(j)-'0'){
                    comp = number.charAt(j)-'0';
                    idx = j+1;
                }
            }
            answer.append(comp);
        }
        System.out.println(answer.toString());
    }
}

/*
 * 참고자료: https://ukyonge.tistory.com/197
 * */