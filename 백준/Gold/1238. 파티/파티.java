import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = Integer.MAX_VALUE;
    private static ArrayList<Node>[] graph;
    private static int N, M, X, result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        createGraph();
        initGraph(br);

        int[] distanceToX, distanceFromX;

        distanceFromX = new int[N + 1];
        Arrays.fill(distanceFromX, INF);
        dijkstra(X, distanceFromX);
        // 각 도시에서 X 도시로 가는 최단 거리 구하기(다익스트라) - 이거는 구할 때마다 결과 갱신하기
        // ex) 1번 도시 사람은 (1 -> 2) + (2 -> 1)
        for (int i = 1; i <= N; i++) {
            if (i == X) {
                continue;
            }
            distanceToX = new int[N + 1];
            Arrays.fill(distanceToX, INF);
            dijkstra(i, distanceToX);

            result = Math.max(result, distanceFromX[i] + distanceToX[X]);
        }
        System.out.println(result);
    }

    private static void dijkstra(int from, int[] distance) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
//        boolean[] visited = new boolean[N + 1];
        pq.add(new Node(from, 0));
        distance[from] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            ArrayList<Node> nodes = graph[current.to];
//            visited[current.to] = true;

            for (Node next : nodes) {
//                if (visited[next.to]) {
//                    continue;
//                }

                int nextWeight = distance[current.to] + next.weight;
                if (distance[next.to] > nextWeight) {
                    distance[next.to] = nextWeight;
                    pq.add(next);
                }
            }
        }
    }

    private static void initGraph(BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, weight));
        }
    }

    private static void createGraph() {
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    private static class Node implements Comparable<Node> {
        private int to, weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return this.weight - node.weight;
        }
    }
}