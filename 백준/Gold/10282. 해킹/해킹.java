import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = Integer.MAX_VALUE;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int n, d, c;
    private static ArrayList<Computer>[] graph;
    private static int[] times;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수 (1 <= n <= 10,000)
            d = Integer.parseInt(st.nextToken()); // 의존성 개수 (1 <= d <= 100,000)
            c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터 번호

            initGraph();

            times = new int[n + 1];
            Arrays.fill(times, INF);
            dijkstra(c);

            // 총 감염되는 컴퓨터 수
            // 마지막 컴퓨터가 감염되기까지 걸리는 시간
            int count = 0;
            int spreadTime = Integer.MIN_VALUE;
            for (int i = 0; i <= n; i++) {
                if (times[i] != INF) {
                    count++;
                    if (times[i] > spreadTime) {
                        spreadTime = times[i];
                    }
                }
            }

            System.out.println(count);
            System.out.println(spreadTime);
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Computer> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        pq.add(new Computer(start, 0));
        times[start] = 0;

        while (!pq.isEmpty()) {
            Computer current = pq.poll();

            if (visited[current.to]) {
                continue;
            }
            visited[current.to] = true;

            for (Computer next : graph[current.to]) {
                int nextTime = times[current.to] + next.second;
                if (times[next.to] > nextTime) {
                    times[next.to] = nextTime;
                    pq.add(new Computer(next.to, nextTime));
                }
            }
        }
    }

    private static void initGraph() throws IOException {
        graph = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < d; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            graph[to].add(new Computer(from, second)); // to가 감염되면 from에게 s초 후 감염
        }
    }

    private static class Computer implements Comparable<Computer>{
        private int to, second;

        public Computer(int to, int second) {
            this.to = to;
            this.second = second;
        }

        @Override
        public int compareTo(Computer computer) {
            return Integer.compare(this.second, computer.second);
        }
    }
}