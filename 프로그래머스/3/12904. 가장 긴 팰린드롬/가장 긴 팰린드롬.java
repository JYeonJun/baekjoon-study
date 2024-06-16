class Solution {
    public int solution(String s) {
        int n = s.length();
        if (n == 0) return 0;

        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;

        // 모든 길이 1의 문자열은 팰린드롬
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // 길이 2의 팰린드롬 검사
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLen = 2;
            }
        }

        // 길이 3 이상인 경우
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    maxLen = len;
                }
            }
        }

        return maxLen;
    }
}