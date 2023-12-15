import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static List<Integer>[] graph;
    private static boolean[] dfsChecked;
    private static boolean[] bfsChecked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()),
                M = Integer.parseInt(st.nextToken()),
                V = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        dfsChecked = new boolean[N + 1];
        bfsChecked = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        dfs(V);
        System.out.println();
        bfs(V);
    }

    private static void dfs(int start) {

        System.out.print(start + " ");
        dfsChecked[start] = true;

        List<Integer> dfsList = graph[start];
        Collections.sort(dfsList);

        for (int i = 0; i < dfsList.size(); i++) {
            Integer next = dfsList.get(i);

            if (!dfsChecked[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        bfsChecked[start] = true;

        while (!que.isEmpty()) {
            int now = que.poll();
            System.out.print(now + " ");
            List<Integer> bfsList = graph[now];
            Collections.sort(bfsList);

            for (int i = 0; i < bfsList.size(); i++) {
                int next = bfsList.get(i);

                if (!bfsChecked[next]) {
                    que.add(next);
                    bfsChecked[next] = true;
                }
            }
        }
    }
}