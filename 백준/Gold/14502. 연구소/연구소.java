import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[][] originMap;
    private static int[][] copyMap;
    private static int maxSafeAreaCnt = Integer.MIN_VALUE;
    private static final int[] dx = new int[]{0, 1, 0, -1};
    private static final int[] dy = new int[]{-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        originMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                originMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(maxSafeAreaCnt);
    }

    private static void dfs(int wallCnt) {

        if (wallCnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (originMap[i][j] == 0) {
                    originMap[i][j] = 1;
                    dfs(wallCnt + 1);
                    originMap[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<Pos> que = new LinkedList<>();

        copyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (originMap[i][j] == 2) {
                    que.add(new Pos(i, j));
                }
            }
        }

        for (int i = 0; i < N; i++) {
            copyMap[i] = originMap[i].clone();
        }

        while (!que.isEmpty()) {
            Pos now = que.poll();
            int y = now.y;
            int x = now.x;

            for (int i = 0; i < dx.length; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (copyMap[ny][nx] == 0) {
                        que.add(new Pos(ny, nx));
                        copyMap[ny][nx] = 2;
                    }
                }
            }
        }

        calSafeAreaCnt();
    }

    private static void calSafeAreaCnt() {

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    cnt++;
                }
            }
        }

        if (maxSafeAreaCnt < cnt) {
            maxSafeAreaCnt = cnt;
        }
    }

    private static class Pos {
        private int x, y;

        public Pos(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}