import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, FROM, TO;
    private static ArrayList<Island>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Island(to, weight));
            graph[to].add(new Island(from, weight));
        }

        st = new StringTokenizer(br.readLine());
        FROM = Integer.parseInt(st.nextToken());
        TO = Integer.parseInt(st.nextToken());

        int result = 0, left = 1, right = 1_000_000_000, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (bfs(mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static boolean bfs(int weight) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        que.add(FROM);
        visited[FROM] = true;

        while (!que.isEmpty()) {
            int current = que.poll();

            if (current == TO) {
                return true;
            }

            ArrayList<Island> linkedIslands = graph[current];

            for (Island linkedIsland : linkedIslands) {
                int next = linkedIsland.to;
                if (!visited[next] && linkedIsland.bridgeWeight >= weight) {
                    que.add(next);
                    visited[next] = true;
                }
            }
        }

        return false;
    }

    private static class Island {
        private int to, bridgeWeight;

        public Island(int to, int bridgeWeight) {
            this.to = to;
            this.bridgeWeight = bridgeWeight;
        }
    }
}