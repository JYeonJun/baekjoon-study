import java.util.*;

class Solution {
    
    private List<Integer>[] graph;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        initGraph(n, edge);
        int[] distances = dijkstra(n);
        
        int max = 0;
        for(int i = 1; i<= n; i++) {
            max = Math.max(max, distances[i]);
        }
        
        for(int i = 1; i <= n; i++) {
            if(distances[i] == max) answer++;
        }
        
        return answer;
    }
    
    private int[] dijkstra(int n) {
        int[] distances = new int[n + 1];
        
        for(int i = 1; i <= n; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[1] = 0;
        
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int next : graph[1]) {
            pq.add(new Node(next, distances[1] + 1));
        }
        
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int to = current.to;
            
            distances[to] = Math.min(distances[to], current.cost);
            
            for(int next : graph[to]) {
                if(!visited[next]) {
                    pq.add(new Node(next, distances[to] + 1));
                    visited[next] = true;
                }
            }
        }
        
        return distances;
    }
    
    private void initGraph(int n, int[][] edges) {
        graph = new List[n + 1];
        
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            
            graph[from].add(to);
            graph[to].add(from);
        }
    }
    
    private class Node implements Comparable<Node> {
        private int to, cost;
        
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}