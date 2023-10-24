import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList();
        
        for (int i = 0; i < arr.length; i++) {
            
            int tmp = arr[i];
            
            int listSize = list.size();
            
            if (listSize > 0 && list.get(listSize - 1) == tmp) {
                continue;
            }
            
            list.add(tmp);
        }
        
        int listSize = list.size();
        
        answer = list.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}