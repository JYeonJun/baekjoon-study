class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int coverage = (2 * w) + 1;
        int current = 1;
        
        for(int station : stations) { 
            int start = station - w;
            int end = station + w;
            
            if(current < start) {
                int length = start - current;
                answer += (length + coverage - 1) / coverage;
            }
            
            current = end + 1;
            
            if(current > n) break;
        }
        
        if(current <= n) {
            int length = n - current + 1;
            answer += (length + coverage - 1) / coverage;
        }

        return answer;
    }
}