class Solution {
    public int solution(int order) {
        int answer = 0;
        int tmp = 0;
        while(order> 0) {
            tmp = order % 10;
            
            if(tmp == 3 || tmp == 6 || tmp == 9)
                answer++;
            
            order /= 10;
        }
        
        return answer;
    }
}