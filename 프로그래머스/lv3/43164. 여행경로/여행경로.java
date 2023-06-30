import java.util.*;
class Solution {
    
    public String[] solution(String[][] tickets) {
        
        List<String> allRoute = new ArrayList<>();
        boolean[] visited = new boolean[tickets.length];
        
        dfs("ICN", "ICN", tickets, visited, allRoute, 0);
        
        Collections.sort(allRoute);
        
        String[] answer = allRoute.get(0).split(" ");
        
        return answer;
    }
    
    public void dfs(String start, String route, String[][]tickets, boolean[] visited, List<String> allRoute, int cnt) {
        
        if(cnt == tickets.length) {
            allRoute.add(route);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
                
                if(tickets[i][0].equals(start) && !visited[i]){
                    visited[i] = true;
                    dfs(tickets[i][1], route + " " + tickets[i][1], tickets, visited, allRoute, cnt + 1);
                    visited[i] = false;
                }
        }
    }
}