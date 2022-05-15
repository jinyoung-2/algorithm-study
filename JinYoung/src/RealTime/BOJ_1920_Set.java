package RealTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

// Set Data Structure
// Set 자료구로를 이용하여 문제를 풀 수 있음 => 해당 값이 존재하는지 빠르게 확인할 수 있는 자료구조
// N개의 정수 A[N]을 Set에 넣고 다음에 주어지는 M개의 수가 이 Set에 존재하는지 여부만 판단하면 됨
public class BOJ_1920_Set {
    public static void main(String[] args) throws IOException {
        // scanner가 bufferedreader보다 편하지만 속도가 느리다.
        // bufferedreader는 무조건 문자열로 받아오기때문에 정수형이나 실수형 변수에 저장하기 위해서는 입력과 형변환을 해줘야한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] A = br.readLine().split(" ");
        HashSet<String> hs = new HashSet<>(Arrays.asList(A));

        int m = Integer.parseInt(br.readLine());
        String[] B = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            if (hs.contains(B[i])) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}