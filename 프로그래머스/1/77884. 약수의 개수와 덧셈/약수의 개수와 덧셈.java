import java.util.*;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++) {
            
            if (countAliquot(i) % 2 == 0) answer += i;
            else answer -= i;
        }
        
        return answer;
    }
    
    private int countAliquot(int n) {
        
        int cnt = 0;
        
        for(int i = 1; i <= Math.sqrt(n); i++) {
            
            if(n % i == 0) {
                if(i * i != n) {
                    cnt += 2;
                } else cnt++;
            }
        }
        
        return cnt;
    }
}