import java.util.*;

class Solution {
    
    private int len;
    private Set<Integer> answer = new HashSet<>();
    
    public int solution(String numbers) {
        
        len = numbers.length();
        
        String[] numsString = numbers.split("");
        int[] nums = new int[len];
        for(int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(numsString[i]);
        }
        
        backtrack(nums, new ArrayList<>(), 0, new boolean[len]);
        
        return answer.size();
    }
    
    private void backtrack(int[] nums, List<Integer> current, int depth, boolean[] visited) {
        if(depth > 0 && depth <= len) {
            StringBuilder num = new StringBuilder();
            for(Integer n : current) {
                num.append(n);
            }
            if(isPrime(Integer.parseInt(num.toString()))) {
                answer.add(Integer.parseInt(num.toString()));
            }
        }
        
        for(int i = 0; i < len; i++) {
            if(!visited[i]) {
                current.add(nums[i]);
                visited[i] = true;
                backtrack(nums, current, depth + 1, visited);
                visited[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }
    
    private boolean isPrime(int num) {
        if(num < 2) return false;
        
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}