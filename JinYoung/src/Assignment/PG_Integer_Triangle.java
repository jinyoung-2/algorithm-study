package Assignment;

public class PG_Integer_Triangle {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] triangle[] = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };
        System.out.println(solution.solution(triangle));
    }
}

class Solution {
    // 메모이제이션을 위한 dp테이블 생성
    private int[] dp[] = new int[500][500];

    public int solution(int[][] triangle) {
        dp[0][0] = triangle[0][0];
        dp[1][0] = dp[0][0] + triangle[1][0];
        dp[1][1] = dp[0][0] + triangle[1][1];

        // 다이나믹 프로그래밍 진행(Bottom-Up 방식)
        for (int i = 2; i < triangle.length; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            for (int j = 1; j < i; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }

        //마지막 행에서 최댓값 찾기
        int max = dp[triangle.length - 1][0];
        for (int i = 1; i < triangle.length; i++) {
            max = Math.max(max, dp[triangle.length - 1][i]);
        }
        return max;
    }
}