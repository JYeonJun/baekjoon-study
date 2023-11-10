class Solution {
    public String solution(String s) {
        
        char[] chars = s.toCharArray();
        
        int index = 0;
        for(int i = 0; i < chars.length; i++, index++) {
            
            char c = chars[i];
            
            if (c == ' ') index = -1;
            
            if ((index & 1) == 0) { // 짝수
                chars[i] = Character.toUpperCase(c);
            } else { // 홀수
                chars[i] = Character.toLowerCase(c);
            }
        }
        
        return new String(chars);
    }
}