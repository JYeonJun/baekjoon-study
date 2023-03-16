import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map;
    private static boolean[][] visited;

    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int j = 0; j < T; j++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken()); // 배추밭의 가로길이
            N = Integer.parseInt(st.nextToken()); // 배추밭의 세로길이
            int K = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치의 개수

            map = new int[N][M];
            visited = new boolean[N][M];
            int result = 0;

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][k] == 1 && !visited[i][k]) {
                        dfs(new Pos(k, i));
                        result++;
                    }
                }
            }

            System.out.println(result);
        }
    }

    private static void dfs(Pos pos) {

        Queue<Pos> que = new LinkedList<>();

        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        que.add(pos);
        visited[pos.y][pos.x] = true;

        while (que.size() != 0) {

            Pos nPos = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = nPos.getX();
                int ny = nPos.getY();

                int tmpX = nx + dx[i];
                int tmpY = ny + dy[i];

                if (tmpX >= 0 && tmpX < M && tmpY >= 0 && tmpY < N) {

                    if (!visited[tmpY][tmpX] && map[tmpY][tmpX] == 1) {
                        que.add(new Pos(tmpX, tmpY));
                        visited[tmpY][tmpX] = true;
                    }
                }
            }
        }
    }

    private static class Pos {

        private int x;
        private int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}