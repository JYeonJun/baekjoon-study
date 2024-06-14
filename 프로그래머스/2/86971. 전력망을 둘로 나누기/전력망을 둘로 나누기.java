import java.util.*;

// 임의의 전선 하나 끊기
// 전력망이 2개로 분할되었는지 검사 (BFS)
// 결과 업데이트 (Math.min)
class Solution {
    private List<Integer>[] graph;
    private boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        visited = new boolean[n + 1];
        
        initGraph(n, wires); // 그래프 초기화
        
        for(int i = 0; i < wires.length; i++) {
            int[] arr = wires[i]; // 끊을 전선 배열
            
            // 임의의 전선 하나 끊기
            graph[arr[0]].remove(Integer.valueOf(arr[1]));
            graph[arr[1]].remove(Integer.valueOf(arr[0]));
            
            // 전력망 개수 확인
            Arrays.fill(visited, false);
            int count = 0, num = 0;
            for(int j = 1; j < n + 1; j++) {
                if(!visited[j]) {
                    num = bfs(j);
                    count++;
                }
            }

            if(count == 2) {
                answer = Math.min(answer, Math.abs((n - num) - num));
            }
            
            // 끊은 전력망 다시 복구
            graph[arr[0]].add(arr[1]);
            graph[arr[1]].add(arr[0]);
        }
        
        return answer;
    }
    
    private void initGraph(int n, int[][] wires) {
        graph = new ArrayList[n + 1];
        
        for(int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] arr : wires) {
            graph[arr[0]].add(arr[1]);
            graph[arr[1]].add(arr[0]);
        }
    }
    
    private int bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;
        
        int num = 0;
        while(!que.isEmpty()) {
            int current = que.poll();
            List<Integer> list = graph[current];
            num++;
            
            for(Integer next : list) {
                if(!visited[next]) {
                    que.add(next);
                    visited[next] = true;
                }
            }
        }
        
        return num;
    }
}