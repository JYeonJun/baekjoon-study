import java.util.*;

class Solution {
    
    private List<Integer>[] graph;
    private boolean[] visited;
    
    public int solution(int n, int[][] computers) { // n: 컴퓨터의 개수, computers: 연결에 대한 정보
        int answer = 0;
        
        init(n, computers);
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void init(int n, int[][] computers) {
        visited = new boolean[n];
        graph = new List[n];
        
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < computers.length; i++) {
            for(int j = 0; j < computers[i].length; j++) {
                if(computers[i][j] == 1 && i != j) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
    }
    
    private void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;
        
        while(!que.isEmpty()) {
            int current = que.poll();
            
            for(int next : graph[current]) {
                if(!visited[next]) {
                    que.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}