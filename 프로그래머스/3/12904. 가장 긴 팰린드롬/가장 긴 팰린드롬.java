class Solution
{
    public int solution(String s)
    {
        int n = s.length();
        int answer = 1;
        boolean[][] dp = new boolean[n][n];
        
        // 한자리 문자열
        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        
        // 두자리 문자열
        for(int i = 0; i < n - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                answer = 2;
            }
        }
        
        // 세자리 이상 문자열
        for(int len = 3; len <= n; len++) {
            for(int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if((s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    answer = len;
                }
            }
        }

        return answer;
    }
}