class Solution {
    public boolean solution(String s) {
        return check(s);
    }
    
    private boolean check(String s) {
        boolean result = true;
        
        int sSize = s.length();
        
        if (sSize == 4 || sSize == 6) {
            
            char[] charArr = s.toCharArray();
            
            for (char c : charArr) {
                if (!Character.isDigit(c))
                    result = false;
            }
        } else {
            result = false;
        }
        
        return result;
    }
}