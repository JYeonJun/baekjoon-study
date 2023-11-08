import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String s = String.valueOf(n);
        
        int[] array =
            new StringBuilder().append(s).chars().map(Character::getNumericValue).toArray();
        
        Arrays.sort(array);
        
        String tmp = "";
        for(int i = array.length-1; i >= 0; i--) {
            tmp += array[i];
        }
        
        return Long.parseLong(tmp);
    }
}