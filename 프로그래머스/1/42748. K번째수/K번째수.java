import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int last = commands[i][1];
            int target = commands[i][2];
            
            int[] tmp = new int[last - start + 1];
            int index = 0;
            for(int j = start - 1; j < last; j++) {
                tmp[index++] = array[j];
            }
            
            Arrays.sort(tmp);
            
            answer[i] = tmp[target - 1];
        }
        
        return answer;
    }
}