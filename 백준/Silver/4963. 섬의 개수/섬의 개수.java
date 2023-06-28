import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int w;
    static int h;
    static int[][] map;
    static boolean[][] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {

            st = new StringTokenizer(br.readLine());
            cnt = 0;

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                String[] split = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(split[j]);
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(new Pos(j, i));
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    static void bfs(Pos pos) {

        Queue<Pos> que = new LinkedList<>();
        que.add(pos);
        visited[pos.getY()][pos.getX()] = true;

        int[] dx = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};

        while (que.size() != 0) {

            Pos currentPos = que.poll();
            int cx = currentPos.getX();
            int cy = currentPos.getY();

            for (int i = 0; i < 8; i++) {
                int tmpX = cx + dx[i];
                int tmpY = cy + dy[i];

                if (tmpX >= 0 && tmpX < w && tmpY >= 0 && tmpY < h && map[tmpY][tmpX] == 1 && !visited[tmpY][tmpX]) {
                    que.add(new Pos(tmpX, tmpY));
                    visited[tmpY][tmpX] = true;
                }
            }
        }
    }

    static class Pos {
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