import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;

    static char[][] map;
    static boolean[][] visited;

    static Queue<int[]> que;

    static int sum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 세로 크기
        int M = Integer.parseInt(st.nextToken()); // 가로 크기

        map = new char[N][M];
        visited = new boolean[N][M];
        sum = 0;

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = split[j].charAt(0);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    sum++;
                }
            }
        }

        System.out.println(sum);
    }

    public static void bfs(int y, int x) {

        que = new LinkedList<>();
        que.add(new int[]{y, x});
        visited[y][x] = true;

        while (que.size() != 0) {
            int[] pos = que.poll();
            int cy = pos[0];
            int cx = pos[1];

            char ch = map[cy][cx];

            if (ch == '-') {
                if (cx + 1 < map[0].length && map[cy][cx + 1] == '-' && !visited[cy][cx+1]) {
                    que.add(new int[]{cy, cx + 1});
                    visited[cy][cx+1] = true;
                }
            } else if (ch == '|') {
                if (cy + 1 < map.length && map[cy + 1][cx] == '|' && !visited[cy + 1][cx]) {
                    que.add(new int[]{cy + 1, cx});
                    visited[cy + 1][cx] = true;
                }
            }
        }
    }
}
