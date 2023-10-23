class Solution {
    public String solution(String s) {
        
        int inputLength = (s.length());
        
        int midIndex = inputLength / 2;
        
        String answer = "";
        
        if ((inputLength & 1) == 0) {
            
            answer = s.substring(midIndex - 1, midIndex + 1);
        } else {
            
            answer = s.substring(midIndex, midIndex + 1);
        }
        
        return answer;
    }
}