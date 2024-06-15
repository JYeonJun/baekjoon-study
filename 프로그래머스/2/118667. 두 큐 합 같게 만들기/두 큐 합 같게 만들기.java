import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        
        for(int i = 0; i < queue1.length; i++) {
            que1.add(queue1[i]);
        }
        
        for(int i = 0; i < queue2.length; i++) {
            que2.add(queue2[i]);
        }
        
        long que1Sum = que1.stream().mapToInt(Integer::intValue).sum();
        long que2Sum = que2.stream().mapToInt(Integer::intValue).sum();
        long totalSum = que1Sum + que2Sum;
        
        if((totalSum & 1) == 1) return -1;
        
        long targetSum = totalSum / 2;
        int totalCount = 600_001;
        
        boolean isEqual = false;
        while(--totalCount >= 0) {
            if(que1Sum == targetSum) {
                isEqual = true;
                break;
            }
            
            if(que1Sum < targetSum) { // 목표합보다 작은 경우
                // que2에서 빼와서 더하기
                int num = que2.poll();
                que1.add(num);
                que1Sum += num;
            } else { // 목표합보다 큰 경우
                // que1에서 빼서 que2에 추가
                int num = que1.poll();
                que2.add(num);
                que1Sum -= num;
            }
            
            answer++;
        }
        
        if(!isEqual) {
            return -1;
        } else {
            return answer;
        }
    }
}