class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        
        answer[0] = x;
        
        for(int i = 2; i <= n; i++) {
            answer[i-1] = answer[i-2] + x;
        }
        
        return answer;
    }
}