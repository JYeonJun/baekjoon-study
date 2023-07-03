import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[] result;
    private static int n;
    private static int m;
    private static int max = Integer.MIN_VALUE;
    private static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        result = new int[n + 1];

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            list[from].add(to);
        }

        for (int i = 1; i <= n; i++) {
            bfs(i);
            max = Math.max(max, result[i]);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (result[i] == max) {
                sb.append(i + " ");
            }
        }
        System.out.println(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        que.add(start);
        visited[start] = true;

        while (que.size() != 0) {
            Integer num = que.poll();
            ArrayList<Integer> network = list[num];

            for (int next : network) {
                if (!visited[next]) {
                    que.add(next);
                    visited[next] = true;
                    result[start]++;
                }
            }
        }
    }
}