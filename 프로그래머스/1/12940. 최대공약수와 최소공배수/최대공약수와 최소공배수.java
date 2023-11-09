class Solution {
    public int[] solution(int n, int m) {
        
        int[] answer = {gcd(n, m), lcm(n, m)};
        return answer;
    }
    
    private int gcd(int n, int m) {
        int max = Math.max(n, m);
        int min = Math.min(n, m);
        int r;
        
        while(min != 0) {
            r = max % min;
            max =min;
            min = r;
        }
        
        return max;
    }
    
    private int lcm(int n, int m) {
        return (n * m) / gcd(n, m);
    }
}