import java.io.*;
import java.util.*;

public class Main {

    private static final int INF = Integer.MAX_VALUE;

    private static int N, E, v1, v2;
    private static List<Node>[] graph;
    private static int[] distances;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수

        distances = new int[N + 1];
        graph = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, distance));
            graph[to].add(new Node(from, distance));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        long result1 = 0, result2 = 0;
        // 1에서 v1, v2까지의 최단 거리
        int startToV1Distance = dijkstra(1, v1);
        int startToV2Distance = dijkstra(1, v2);
        // v1에서 v2까지의 최단 거리
        int v1ToV2Distance = dijkstra(v1, v2);
        // v1, v2에서 N까지의 최단 거리
        int v1ToNDistance = dijkstra(v1, N); 
        int v2ToNDistance = dijkstra(v2, N); 

        result1 = (long)startToV1Distance + (long)v1ToV2Distance + (long)v2ToNDistance;
        result2 = (long)startToV2Distance + (long)v1ToV2Distance + (long)v1ToNDistance;

        if (result1 >= INF || result2 >= INF) { // 수정된 부분
            System.out.println(-1);
        } else {
            System.out.println(Math.min(result1, result2));
        }
    }

    private static int dijkstra(int start, int destination) {

        Arrays.fill(distances, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        distances[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (now.to == destination) {
                break; // 수정된 부분: 더 빠른 탈출 조건
            }
            List<Node> nodes = graph[now.to];

            for (Node next : nodes) {

                int nextDistance = distances[now.to] + next.distance;
                if (distances[next.to] > nextDistance) {
                    distances[next.to] = nextDistance;
                    pq.add(new Node(next.to, distances[next.to])); // 수정된 부분: 갱신된 거리로 우선순위 큐에 추가
                }
            }
        }
        return distances[destination];
    }

    private static class Node implements Comparable<Node>{
        int to, distance;

        public Node(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.distance, node.distance);
        }
    }
}
