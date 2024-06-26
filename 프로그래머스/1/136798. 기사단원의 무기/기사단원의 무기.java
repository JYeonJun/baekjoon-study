class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i = 1; i <= number; i++) {
            int cnt = count(i);
            
            if(cnt > limit) answer += power;
            else answer += cnt;
        }
        
        return answer;
    }
    
    private int count(int n) {
        int cnt = 0;
        
        for(int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if(i * i == n) {
                    cnt += 1;
                } else {
                    cnt += 2;
                }
            }
        }
        
        return cnt;
    }
}