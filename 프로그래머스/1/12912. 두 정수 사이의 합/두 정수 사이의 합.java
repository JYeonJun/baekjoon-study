class Solution {
    public long solution(int a, int b) {
        long answer = betweenSum(Math.min(a, b), Math.max(a, b));
        return answer;
    }
    
    private long betweenSum(int a, int b) {
        
        long sum = 0;
        
        for(int i = a; i <= b; i++) {
                sum += i;
            }
        
        return sum;
    }
}