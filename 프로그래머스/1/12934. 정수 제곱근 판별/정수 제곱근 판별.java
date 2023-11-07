class Solution {
    public long solution(long n) {
        long answer = 0;
        
        double tmp = Math.sqrt(n);
        
        if(tmp % 1 == 0) {
            double tmp2 = tmp + 1;
            answer = (long) (tmp2 * tmp2);
        } else answer = -1;
        
        return answer;
    }
}