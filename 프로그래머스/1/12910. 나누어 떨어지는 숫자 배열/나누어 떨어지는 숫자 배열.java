import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList();
        
        for (int i : arr) {
            
            if ( i % divisor == 0) {
                list.add(i);
            }
        }
        
        Collections.sort(list);
        
        if (list.size() == 0) {
            answer = new int[]{-1};
        } else {
            answer = list.stream().mapToInt(i -> i).toArray();
        }
        
        return answer;
    }
}