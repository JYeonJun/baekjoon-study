import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final int[] dy = {-1, 0, 1, 0};
    private static final int[] dx = {0, 1, 0, -1};
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] map1 = new char[N][N];
        char[][] map2 = new char[N][N];

        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map1[i][j] = row[j];
                // 'G'를 'R'로 변환하여 map2에 저장
                map2[i][j] = (row[j] == 'G') ? 'R' : row[j];
            }
        }

        System.out.println(getRegionCount(map1) + " " + getRegionCount(map2));
    }

    private static int getRegionCount(char[][] map) {
        boolean[][] visited = new boolean[N][N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(map, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private static void bfs(char[][] map, boolean[][] visited, int y, int x) {
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(y, x));
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Pos current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = current.y + dy[i];
                int nx = current.x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx] && map[current.y][current.x] == map[ny][nx]) {
                    queue.offer(new Pos(ny, nx));
                    visited[ny][nx] = true;
                }
            }
        }
    }

    private static class Pos {
        int y, x;

        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
