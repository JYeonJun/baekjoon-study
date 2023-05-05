class Solution {
    static boolean isVisited[];
    static int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        
        for(int i = 0; i < words.length; i++){
            if(compare(begin, words[i]) <= 1){
                isVisited = new boolean[words.length];
                isVisited[i] = true;
                dfs(1, i, words[i], target, words);
            }
        }
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    public static void dfs(int cnt, int cur, String begin, String target, String[] words) {
        
        if(target.equals(begin)) {
            answer = Math.min(cnt, answer);
            return;
        }
        
        for(int i = 0; i < words.length; i++) {
            if(!isVisited[i] && compare(begin, words[i]) == 1) {
                isVisited[i] = true;
                dfs(cnt+1, i, words[i], target, words);
                isVisited[i] = false;
            }
        }
    }
    
    public static int compare(String s1, String s2) {
        
        int n = 0;
        
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i))
                n++;
        }
        
        return n;
    }
}