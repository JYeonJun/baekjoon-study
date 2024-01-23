import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static char[][] map;
    private static int N, M;
    private static final int[] dx = new int[]{0, 1, 0, -1};
    private static final int[] dy = new int[]{-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        String line;
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int result = Integer.MIN_VALUE;
        int tmp;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    tmp = bfs(new Pos(i, j, 0));
                    result = Math.max(result, tmp);
                }
            }
        }

        System.out.println(result);
    }

    private static int bfs(Pos pos) {

        Queue<Pos> que = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        que.add(pos);
        visited[pos.y][pos.x] = true;

        int ny, nx, nCnt, ty, tx, cnt = 0;
        while (!que.isEmpty()) {
            Pos nPos = que.poll();
            ny = nPos.y;
            nx = nPos.x;
            nCnt = nPos.cnt;

            for (int i = 0; i < dx.length; i++) {
                ty = ny + dy[i];
                tx = nx + dx[i];

                if (ty < 0 || ty >= N || tx < 0 || tx >= M || map[ty][tx] == 'W' || visited[ty][tx]) {
                    continue;
                }

                visited[ty][tx] = true;
                que.add(new Pos(ty, tx, nCnt + 1));
                cnt = Math.max(cnt, nCnt + 1);
            }
        }

        return cnt;
    }

    private static class Pos {
        private int y, x, cnt;

        public Pos(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
}