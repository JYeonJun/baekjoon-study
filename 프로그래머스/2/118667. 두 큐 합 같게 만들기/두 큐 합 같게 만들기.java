import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> que1 = new ArrayDeque<>();
        Queue<Integer> que2 = new ArrayDeque<>();
        
        long que1Sum = 0;
        long que2Sum = 0;

        for (int num : queue1) {
            que1.add(num);
            que1Sum += num;
        }
        
        for (int num : queue2) {
            que2.add(num);
            que2Sum += num;
        }
        
        long totalSum = que1Sum + que2Sum;
        
        if ((totalSum & 1) == 1) return -1;
        
        long targetSum = totalSum / 2;
        int maxOperations = 2 * (queue1.length + queue2.length);
        
        while (answer <= maxOperations) {
            if (que1Sum == targetSum) {
                return answer;
            }
            
            if (que1Sum < targetSum) {
                int num = que2.poll();
                que1.add(num);
                que1Sum += num;
                que2Sum -= num;
            } else {
                int num = que1.poll();
                que2.add(num);
                que1Sum -= num;
                que2Sum += num;
            }
            
            answer++;
        }
        
        return -1;
    }
}