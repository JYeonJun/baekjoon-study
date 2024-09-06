import java.util.*;

class Solution {
    
    private List<Integer>[] tree;
    private int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        
        initTree(n, wires);
        permutation(n, wires);
        
        return answer;
    }
    
    private void permutation(int n, int[][] wires) {
        for(int[] wire : wires) {
            int from = wire[0];
            int to = wire[1];
            
            tree[from].remove(Integer.valueOf(to));
            tree[to].remove(Integer.valueOf(from));
            countNetwork(n);
            tree[from].add(Integer.valueOf(to));
            tree[to].add(Integer.valueOf(from));
        }
    }
    
    private int countNetwork(int n) {
        int networkCnt = 0;
        boolean[] visited = new boolean[n + 1];
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                nums.add(bfs(i, visited));
                networkCnt++;
            }
        }
        
        if(networkCnt == 2) { // 2개로 나뉘어진 경우
            answer = Math.min(answer, Math.abs(nums.get(0) - nums.get(1)));
        }
        
        return networkCnt;
    }
    
    private int bfs(int num, boolean[] visited) {
        Queue<Integer> que = new LinkedList<>();
        visited[num] = true;
        que.add(num);
        int count = 1;
        
        while(!que.isEmpty()) {
            int current = que.poll();
            
            for(int next : tree[current]) {
                if(!visited[next]) {
                    visited[next] = true;
                    que.add(next);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void initTree(int n, int[][] wires) {
        tree = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires) {
            tree[wire[0]].add(wire[1]);
            tree[wire[1]].add(wire[0]);
        }
    }
}