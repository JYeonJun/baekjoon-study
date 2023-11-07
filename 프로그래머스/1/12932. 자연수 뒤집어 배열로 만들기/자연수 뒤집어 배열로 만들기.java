import java.util.Arrays;

class Solution {
    public int[] solution(long n) {
        
        String s = String.valueOf(n);
        
        StringBuilder sb = new StringBuilder(s);
        
        s = sb.reverse().toString();
        
        char[] ca = s.toCharArray();
        
        int l = ca.length;
        
        int[] answer = new int[l];
        
        for(int i = 0; i < l; i++) {
            answer[i] = ca[i] - '0';
        }
        
        return answer;
    }
}