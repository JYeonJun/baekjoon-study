import java.util.*;

class Solution {
    private List<String> route = new ArrayList<>();
    private boolean[] visited;
    private boolean found = false;

    public String[] solution(String[][] tickets) {
        // 항공권을 알파벳 순서로 정렬
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));

        visited = new boolean[tickets.length];
        route.add("ICN");
        dfs("ICN", tickets, 0);
        
        return route.toArray(new String[0]);
    }

    private void dfs(String current, String[][] tickets, int count) {
        if (count == tickets.length) {
            found = true;
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                route.add(tickets[i][1]);
                dfs(tickets[i][1], tickets, count + 1);
                if (found) return;  // 경로를 찾았으면 종료
                visited[i] = false;
                route.remove(route.size() - 1);
            }
        }
    }
}
