import java.util.*;

class Solution {
    
    PriorityQueue<Integer> pq;
    
    public long solution(int n, int[] works) {
        long answer = 0;
        
        init(works);
        
        for(int i = 0; i < n; i++) {
            if(pq.isEmpty()) break;
            int num = pq.poll();
            if(num > 0) {
                pq.add(num - 1);
            }
        }
        
        while(!pq.isEmpty()) {
            int num = pq.poll();
            answer += num * num;
        }
        
        return answer;
    }
    
    private void init(int[] works) {
        pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int n : works) {
            pq.add(n);
        }
    }
}