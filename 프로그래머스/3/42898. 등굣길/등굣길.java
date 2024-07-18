import java.util.Arrays;

class Solution {

    private static final int DIVISOR = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];

        // 물에 잠긴 지역 표시
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }

        // 시작점 초기화
        dp[1][1] = 1;

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if (dp[y][x] == -1) {
                    dp[y][x] = 0; // 물에 잠긴 지역은 경로 수 0으로 설정
                    continue;
                }
                if (y > 1) {
                    dp[y][x] = (dp[y][x] + dp[y - 1][x]) % DIVISOR;
                }
                if (x > 1) {
                    dp[y][x] = (dp[y][x] + dp[y][x - 1]) % DIVISOR;
                }
            }
        }

        return dp[n][m];
    }
}
