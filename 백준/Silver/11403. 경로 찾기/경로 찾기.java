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
    private static List<Integer>[] graph;
    private static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new List[N];
        map = new int[N][N];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        int tmp;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            tmp = 0;
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    graph[i].add(tmp);
                }
                tmp++;
            }
        }

        for (int i = 0; i < N; i++) {
            bfs(i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int from) {

        Queue<Integer> que = new LinkedList<>();

        List<Integer> list = graph[from];

        for (Integer i : list) {
            que.add(i);
        }

        boolean[] visited = new boolean[N];

        while (!que.isEmpty()) {
            Integer to = que.poll();
            map[from][to] = 1;

            List<Integer> nextList = graph[to];

            for (Integer n : nextList) {
                if (!visited[n]) {
                    que.add(n);
                    visited[n] = true;
                }
            }
        }
    }
}