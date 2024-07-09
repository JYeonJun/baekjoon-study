import java.util.*;

class Solution {
    
    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    private PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
    
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        for(String s : operations) {
            StringTokenizer st = new StringTokenizer(s);
            String command = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            solve(command, num);
        }
        
        if(pq.size() > 0) {
            answer[0] = maxPq.peek();
            answer[1] = pq.peek();
        }
        
        return answer;
    }
    
    private void solve(String command, int num) {
        if(command.equals("I")) {
            inputNum(num);
        } else if(command.equals("D") && pq.size() > 0){
            removeNum(num);
        }
    }
    
    private void inputNum(int num) {
        pq.offer(num);
        maxPq.offer(num);
    }
    
    private void removeNum(int num) {
        if(num < 0) {
            int tmp = pq.poll();
            maxPq.remove(tmp);
        } else {
            int tmp = maxPq.poll();
            pq.remove(tmp);
        }
    }
}