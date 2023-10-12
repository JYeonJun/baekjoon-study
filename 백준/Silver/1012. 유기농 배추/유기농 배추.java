import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int M;
    private static int N;
    private static int[][] farm;
    private static boolean[][] visited;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int l = 0; l < T; l++) {

            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken()); // 가로 길이
            N = Integer.parseInt(st.nextToken()); // 세로 길이
            int K = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치의 개수

            farm = new int[N][M];
            visited = new boolean[N][M];

            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                farm[y][x] = 1;
            }

            int result = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {

                    if (!visited[i][j] && farm[i][j] == 1) {
                        dfs(i, j);
                        result++;
                    }
                }
            }

            System.out.println(result);
        }
    }

    private static void dfs(int y, int x) {

        if (farm[y][x] == 0) {
            return;
        }

        visited[y][x] = true;

        for (int i = 0; i < dx.length; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) {
                continue;
            }

            if (!visited[nextY][nextX] && farm[nextY][nextX] == 1) {
                dfs(nextY, nextX);
            }
        }
    }
}