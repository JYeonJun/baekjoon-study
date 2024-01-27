import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, index, now;
    private static List<Node>[] graph;
    private static int[] plan;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        graph = new List[N + 1];
        M = Integer.parseInt(br.readLine());
        plan = new int[M];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            graph[i].add(new Node(i));
        }

        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(input[j]) == 0) {
                    continue;
                }
                graph[i].add(new Node(j + 1));
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        index = 0;
        while (index < M - 1) {
            if (!bfs(plan[index], plan[index + 1])) {
                System.out.println("NO");
                return;
            }
            index++;
        }

        System.out.println("YES");
    }

    private static boolean bfs(int start, int destination) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        que.add(start);
        visited[start] = true;

        int now;
        while (!que.isEmpty()) {
            now = que.poll();

            List<Node> list = graph[now];
            for (Node next : list) {
                int nextTo = next.to;

                if (nextTo == destination) {
                    return true;
                } else if (!visited[nextTo]) {
                    que.add(nextTo);
                    visited[nextTo] = true;
                }
            }
        }

        return false;
    }

    private static class Node {
        private Integer to;

        public Node(Integer to) {
            this.to = to;
        }
    }
}