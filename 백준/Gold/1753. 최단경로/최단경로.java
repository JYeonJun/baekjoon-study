import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int v;
    public static int start;
    public static List<Node>[] arrayList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        v = Integer.parseInt(st.nextToken()); // 노드 개수
        int e = Integer.parseInt(st.nextToken()); // 간선 개수
        start = Integer.parseInt(br.readLine()); // 시작 정점

        arrayList = new ArrayList[v + 1];
        int[] weights = new int[v + 1];

        for (int i = 1; i < v + 1; i++) {
            if (i != start) {
                weights[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < v + 1; i++) {
            arrayList[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arrayList[from].add(new Node(to, w));
        }

        bfs(weights);

        for (int i = 1; i < v + 1; i++) {

            int weight = weights[i];

            if (weight == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(weight);
            }
        }
    }

    static void bfs(int[] weights) {

        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        boolean[] visited = new boolean[v + 1];
        visited[start] = true;

        while (!que.isEmpty()) {
            Integer from = que.poll();

            for (Node node : arrayList[from]) {
                int nodeNum = node.getNode();
                int weight = node.getWeight();

                weights[nodeNum] = Math.min(weights[from] + weight, weights[nodeNum]);
            }

            int minIndex = 0;
            int minValue = Integer.MAX_VALUE;
            for (int i = 1; i < weights.length; i++) {
                if (!visited[i] && weights[i] < minValue) {
                    minIndex = i;
                    minValue = weights[i];
                }
            }

            if (minIndex != 0) {
                que.add(minIndex);
                visited[minIndex] = true;
            }
        }
    }

    static class Node {
        private int node;
        private int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int getNode() {
            return node;
        }

        public int getWeight() {
            return weight;
        }
    }
}