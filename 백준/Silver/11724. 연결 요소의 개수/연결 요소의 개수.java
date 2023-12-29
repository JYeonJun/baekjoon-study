import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static List<Integer>[] map;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 0;

        map = new List[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            map[u].add(v);
            map[v].add(u);
        }

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                bfs(i);
                result++;
            }
        }

        System.out.println(result);
    }

    private static void bfs(int num) {
        Queue<Integer> que = new LinkedList<>();

        que.add(num);
        visited[num] = true;

        while (!que.isEmpty()) {
            int now = que.poll();

            List<Integer> list = map[now];
            for (int i : list) {
                if (!visited[i]) {
                    que.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}