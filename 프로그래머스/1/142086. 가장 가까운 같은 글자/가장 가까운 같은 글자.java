import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if(map.containsKey(ch)) {
                int index = map.get(ch);
                answer[i] = i - index;
                map.put(ch, i);
            } else {
                answer[i] = -1;
                map.put(ch, i);
            }
        }
        
        return answer;
    }
}