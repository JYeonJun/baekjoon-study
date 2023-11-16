class Solution {
    public String solution(String s, int n) {
        
        char[] chars = s.toCharArray();
        
        for(int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            
            if(ch == ' ') {
                continue;
            } else if(Character.isUpperCase(ch)) {
                chars[i] = (char)((ch + n) % 91);
                
                if(chars[i] < 65) chars[i] += 65;
            } else {
                chars[i] = (char)((ch + n) % 123);
                
                if(chars[i] < 97) chars[i] += 97;
            }
        }
        
        return new String(chars);
    }
}