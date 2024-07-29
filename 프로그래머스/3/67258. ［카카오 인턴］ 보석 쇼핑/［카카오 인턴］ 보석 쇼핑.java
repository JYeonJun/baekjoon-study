import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        int gemTypeCount = gemTypes.size();
        
        int length = Integer.MAX_VALUE, start = 0;
        
        Map<String, Integer> gemCount = new HashMap<>();
        for(int end = 0; end < gems.length; end++) {
            gemCount.put(gems[end], gemCount.getOrDefault(gems[end], 0) + 1);
            
            while(gemCount.get(gems[start]) > 1) {
                gemCount.put(gems[start], gemCount.get(gems[start]) - 1);
                start++;
            }
            
            if(gemCount.size() == gemTypeCount && length > (end - start)) {
                length = end - start;
                answer[0] = start + 1;
                answer[1] = end + 1;
            }
        }
        
        return answer;
    }
}