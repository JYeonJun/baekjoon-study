class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int pCnt = 0, yCnt = 0;

        char[] cArr = s.toCharArray();
        
        for(char c : cArr) {
            
            if(c == 'p' || c == 'P') pCnt++;
            else if(c == 'y' || c == 'Y') yCnt++;
        }
        
        if(pCnt != yCnt) answer = false;

        return answer;
    }
}