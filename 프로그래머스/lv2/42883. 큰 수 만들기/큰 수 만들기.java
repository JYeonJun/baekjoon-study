class Solution {
    public String solution(String number, int k) {
        
        StringBuilder sb = new StringBuilder();
        
        int max = 0;
        int index = 0;
        for(int i = 0; i < number.length() - k; i++) {
            
            max = 0;
            for(int j = index; j <= i + k; j++) {
                int tmp = number.charAt(j) - '0';
                if(max < tmp) {
                    max = tmp;
                    index = j + 1;
                }
            }
            
            sb.append(max);
        }
        
        return sb.toString();
    }
}