import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int N, result;
    private static String[][] map;
    private static boolean[][] visited;
    private static int[] dx = new int[]{0, 1, 0, -1};
    private static int[] dy = new int[]{-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cnt = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());

            if (N == 0) {
                return;
            }

            map = new String[N][N];
            visited = new boolean[N][N];
            result = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    map[i][j] = st.nextToken();
                }
            }

            dijkstra(new Pos(0, 0, Integer.parseInt(map[0][0])));

            System.out.println("Problem " + cnt++ + ": " + result);
        }
    }

    private static void dijkstra(Pos pos) {
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        visited[pos.y][pos.x] = true;
        pq.add(pos);

        int ny, nx, nextY, nextX;
        Integer nRupee;
        while (!pq.isEmpty()) {
            Pos nPos = pq.poll();
            ny = nPos.y;
            nx = nPos.x;
            nRupee = nPos.rupee;

            if (ny == N - 1 && nx == N - 1) {
                compare(nRupee);
                return;
            }

            for (int i = 0; i < dx.length; i++) {
                nextY = ny + dy[i];
                nextX = nx + dx[i];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N || visited[nextY][nextX]
                        || nRupee + Integer.parseInt(map[nextY][nextX]) >
                        result) {
                    continue;
                }

                visited[nextY][nextX] = true;
                pq.add(new Pos(nextY, nextX, nRupee + Integer.parseInt(map[nextY][nextX])));
            }
        }
    }

    private static void compare(int num) {
        result = Math.min(result, num);
    }

    private static class Pos implements Comparable<Pos>{
        private int y, x;
        private Integer rupee;

        public Pos(int y, int x, Integer rupee) {
            this.y = y;
            this.x = x;
            this.rupee = rupee;
        }


        @Override
        public int compareTo(Pos o) {
            return this.rupee - o.rupee;
        }
    }
}