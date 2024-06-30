class Solution {
    
    private int[][] dp;
    public int solution(int[][] triangle) {
        int answer = 0;
        
        init(triangle);
        
        for(int i = 0; i < triangle.length - 1; i++) {
            for(int j = 0; j < i + 1; j++) {
                dp[i + 1][j] = Math.max(dp[i + 1][j], triangle[i + 1][j] + dp[i][j]); 
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], triangle[i + 1][j + 1] + dp[i][j]);
            }
        }
        
        for(int i = 0; i < dp[dp.length - 1].length; i++) {
            answer = Math.max(answer, dp[dp.length - 1][i]);
        }
        
        return answer;
    }
    
    private void init(int[][] triangle) {
        dp = new int[triangle.length][];
        
        for(int i = 0; i < triangle.length; i++) {
            dp[i] = new int[triangle[i].length];
        }
        
        dp[0][0] = triangle[0][0];
    }
}