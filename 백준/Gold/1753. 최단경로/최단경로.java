import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        result = new int[V + 1];
        for (int i = 1; i < graph.length; i++) {
            if (i != K) {
                result[i] = Integer.MAX_VALUE;
            } else {
                result[i] = 0;
            }
        }

        visited = new boolean[V + 1];
        visited[K] = true;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, weight));
        }

        Queue<Integer> que = new LinkedList<>();
        que.add(K);
        while (!que.isEmpty()) {
            Integer now = que.poll();

            for (int i = 0; i < graph[now].size(); i++) {
                Node node = graph[now].get(i);
                int next = node.getNum();
                result[next] = Math.min(result[next], result[now] + node.getWeight());
            }

            int minIndex = 0;
            int minValue = Integer.MAX_VALUE;
            for (int i = 1; i < result.length; i++) {
                if (!visited[i] && result[i] < minValue) {
                    minIndex = i;
                    minValue = result[i];
                }
            }

            if (minIndex != 0) {
                que.add(minIndex);
                visited[minIndex] = true;
            }
        }

        for (int i = 1; i < result.length; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(result[i]);
            }
        }
    }

    static class Node {
        private int num;
        private int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        public int getNum() {
            return num;
        }

        public int getWeight() {
            return weight;
        }
    }
}