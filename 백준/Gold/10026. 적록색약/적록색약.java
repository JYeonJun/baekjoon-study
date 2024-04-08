import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
    private static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] map1 = new char[N][N];
        char[][] map2 = new char[N][N];
        boolean[][] visited1 = new boolean[N][N];
        boolean[][] visited2 = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                char color = row[j];
                map1[i][j] = color;
                map2[i][j] = color;
                if (color == 'G') {
                    map2[i][j] = 'R';
                }
            }
        }

        int count1 = 0, count2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited1[i][j]) {
                    bfs(map1, visited1, i, j);
                    count1++;
                }
                if (!visited2[i][j]) {
                    bfs(map2, visited2, i, j);
                    count2++;
                }
            }
        }
        System.out.println(count1 + " " + count2);
    }

    private static void bfs(char[][] map, boolean[][] visited, int y, int x) {
        Queue<Pos> que = new LinkedList<>();
        que.add(new Pos(y, x));
        visited[y][x] = true;

        while (!que.isEmpty()) {
            Pos current = que.poll();
            int cy = current.y;
            int cx = current.x;

            for (int i = 0; i < dy.length; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx] || map[cy][cx] != map[ny][nx]) {
                    continue;
                }

                que.add(new Pos(ny, nx));
                visited[ny][nx] = true;
            }
        }
    }

    private static class Pos {
        private int y, x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}