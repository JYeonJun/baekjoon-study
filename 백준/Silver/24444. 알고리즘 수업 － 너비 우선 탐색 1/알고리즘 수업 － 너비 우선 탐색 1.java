import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static ArrayList<Integer>[] graph;
    private static int[] visitedOrder;
    private static int count = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visitedOrder = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        bfs(R);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visitedOrder[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visitedOrder[start] = count++;

        while (!que.isEmpty()) {
            int current = que.poll();

            for (int nextVertex : graph[current]) {
                if (visitedOrder[nextVertex] != 0) {
                    continue;
                }
                que.add(nextVertex);
                visitedOrder[nextVertex] = count++;
            }
        }
    }
}