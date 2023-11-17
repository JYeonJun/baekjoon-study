class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int[] wall = new int[n + 1];
        
        for(int i = 0; i < wall.length; i++) {
            for(int j = 0; j < section.length; j++) {
                int tmp = section[j];
                wall[tmp] = 1;
            }
        }
        
        for(int i = 0; i < wall.length;) {
            
            if(wall[i] == 1) {
                
                answer++;
                
                if(i + m <= n) i += m;
                else break;
            } else i++;
        }
        
        return answer;
    }
}