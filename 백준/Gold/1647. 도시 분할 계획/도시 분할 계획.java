import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static List<Node>[] graph, con;

    public static void main(String[] args) throws IOException {
        init();
        int sum = prim();
        int tmp = 0;
        for (int i = 1; i <= N; i++) {
            if (con[i].size() == 1 || con[i].size() == 2) {
                for (Node node : con[i]) {
                    if (node.cost > tmp) {
                        tmp = node.cost;
                    }
                }
            }
        }

        System.out.println(sum - tmp);
    }

    private static int prim() {
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Node node : graph[1]) {
            pq.add(node);
        }
        visited[1] = true;

        int sum = 0;
        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (visited[current.to]) {
                continue;
            }

            visited[current.to] = true;
            sum += current.cost;
            for (Node node : graph[current.to]) {
                pq.add(node);
            }
            con[current.from].add(current);
            con[current.to].add(new Node(current.to, current.from, current.cost));
        }

        return sum;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        con = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            con[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(from, to, cost));
            graph[to].add(new Node(to, from, cost));
        }
    }

    private static class Node implements Comparable<Node> {
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