import java.util.*;

class Solution {
    
    List<Node>[] matrix;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        init(n, costs);
        answer = bfs(0, n);
        
        
        return answer;
    }
    
    private int bfs(int start, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n];
        
        for(Node node : matrix[start]) {
            pq.add(node);
        }
        
        visited[start] = true;
        
        int count = 1; // 방문한 섬의 개수
        int answer = 0;
        while(!pq.isEmpty() && count != n) {
            Node current = pq.poll();
            if(!visited[current.to]) {
                count++;
                answer += current.cost;
                visited[current.to] = true;
            } else {
                continue;
            }
            
            for(Node node : matrix[current.to]) {
                if(!visited[node.to]) {
                    pq.add(node);
                }
            }
        }
        
        return answer;
    }
    
    private void init(int n, int[][] costs) {
        matrix = new List[n];
        for(int i = 0; i < n; i++) {
            matrix[i] = new ArrayList<>();
        }
        
        for(int[] c : costs) {
            int from = c[0];
            int to = c[1];
            int cost = c[2];
            
            matrix[from].add(new Node(from, to, cost));
            matrix[to].add(new Node(to, from, cost));
        }
    }
    
    private class Node implements Comparable<Node>{
        private int from, to, cost;
        
        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}