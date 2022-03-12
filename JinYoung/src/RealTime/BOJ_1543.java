package RealTime;

import java.util.Scanner;

public class BOJ_1543 {
    public static void main(String[] args) {
        /**
         * 특정 단어 최대 몇 번 등장 count & 중복 X
         * */
        Scanner sc = new Scanner(System.in);
        String document = sc.nextLine();  //문서
        String word = sc.nextLine();      //검색하려는 단어

        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();  //문서
        String word = br.readLine();      //검색하려는 단어
        * */

        int result = 0;
        int j = 0;  //검색단어 index
        int cnt=0;

        //틀린 부분부터 처음부터 다시
        for(int i=0;i<document.length();i++){
            if(document.charAt(i)!=word.charAt(j)){
                j = 0;
                cnt = 0;
                i--;
                continue;
            }
            cnt++;  //document.charAt(i) == word.charAt(j)
            j++;

            if(cnt==word.length()){
                result++;
                cnt = 0;
                j = 0;
            }
        }
        //출력
        System.out.println(result);
    }
}

/**
 * 실패한 이유: 문서-abcababa, 단어-aba일 경우
 *                aba       //문자가 다르므로 pass
 *                  aba     //틀린부분부터 단어가 존재하는지 확인해야 함
 *                   aba    // But, 나는 틀린부분 다음부터 단어가 존재하는지 확인하는 방식으로 코드 작성함
 *
 * */

// 더 좋은 코드
public class BOJ_1543 {
    public static void main(String[] args) {
        /**
         * 특정 단어 최대 몇 번 등장 count & 중복 X
         * */
        Scanner sc = new Scanner(System.in);
        String doc = sc.nextLine();  //문서
        String str = sc.nextLine();  //검색하려는 단어

        int cnt=0;

        //예외처리 중요!
        //문서길이 < 단어길이인 경우 예외처리하기 위해 조건식을 다음과 같이 작성함
        //doc.length() - str.length() + 1
        for(int i=0;i<doc.length()-str.length()+1;i++){
            if(doc.substring(i,i+str.length()).equals(str)){    //substring().equals() 이용하여 문자열 비교
                cnt++;
                i += str.length();
                i--;
            }
            else
                continue;
        }
        //출력
        System.out.println(cnt);
    }
}