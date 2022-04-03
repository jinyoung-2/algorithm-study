package BOJ;

// [백준] Silver3 등수 매기기 / 40분 실패

import java.util.*;

public class BOJ_2012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 학생 수
        int[] expectedGrade = new int[N]; // 예상 등수
        for (int i = 0; i < N; i++) {
            expectedGrade[i] = sc.nextInt();
        }

        Arrays.sort(expectedGrade);

        long result = 0;
        for (int i = 0; i < N; i++) {
            int grade = i + 1;
            result += Math.abs(grade - expectedGrade[i]);
        }

        System.out.println(result);
    }
}
