import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static List<Road>[] ways;
    private static int[] dist;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ways = new ArrayList[N + 1];
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            ways[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cows_cnt = Integer.parseInt(st.nextToken());
            ways[from].add(new Road(to, cows_cnt));
            ways[to].add(new Road(from, cows_cnt));
        }

        dijkstra();
        System.out.println(dist[N]);
    }

    private static void dijkstra() {
        PriorityQueue<Road> q = new PriorityQueue<>();
        dist[1] = 0;
        q.offer(new Road(1, 0));

        while (!q.isEmpty()) {
            Road now = q.poll();

            int nt = now.to;
            if (visited[nt]) {
                continue;
            }

            visited[nt] = true;
            List<Road> roads = ways[nt];
            for (Road road : roads) {
                int nextTo = road.to;
                int cowsCnt = road.cowsCnt;
                if (dist[nextTo] > dist[now.to] + cowsCnt) {
                    dist[nextTo] = dist[now.to] + cowsCnt;
                    q.offer(new Road(nextTo, dist[nextTo]));
                }
            }
        }
    }

    private static class Road implements Comparable<Road>{
        private int to;
        private int cowsCnt;

        public Road(int to, int cowsCnt) {
            this.to = to;
            this.cowsCnt = cowsCnt;
        }

        @Override
        public int compareTo(Road o) {
            return this.cowsCnt - o.cowsCnt;
        }
    }
}