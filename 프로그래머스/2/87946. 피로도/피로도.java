class Solution {
    
    private int answer = Integer.MIN_VALUE;
    
    public int solution(int k, int[][] dungeons) { // k: 유저의 현재 피로도, dungeons: 최소 필요 피로도, 소모 피로도
        
        permutation(k, dungeons, 0, new boolean[dungeons.length]);
        return answer; // 유저가 탐험할 수 있는 최대 던전 수
    }
    
    private void permutation(int k, int[][] dungeons, int current, boolean[] visited) {
        answer = Math.max(answer, current);
        
        for(int i = 0; i < dungeons.length; i++) {
            if(visited[i]) {
                continue;
            }
            
            if(dungeons[i][0] <= k) {
                visited[i] = true;
                permutation(k - dungeons[i][1], dungeons, current + 1, visited);
                visited[i] = false;
            }
        }
    }
}