import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int n = 19;
    private static int[][] a = new int[n][n];
    private static int[] dx = new int[]{-1, 0, 1, 1}, dy = new int[]{1, 1, 1, 0}; // 왼쪽 아래 대각선, 아래, 오른쪽 아래 대각선, 오른쪽

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(input[j]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int now = a[i][j];
                if (now != 0) {
                    for (int k = 0; k < 4; k++) {
                        int count = 1;
                        int nx = dx[k], ny = dy[k];
                        if (isOutOfRange(i, j, nx, ny)) continue;

                        while (a[i+nx][j+ny] == now) { // 조건: 같은 색깔일 때
                            count++;
                            // 같은 방향으로 계속 탐색
                            nx += dx[k];
                            ny += dy[k];
                            if (count > 5) break; // 5개가 넘어가면 실패
                            if (isOutOfRange(i, j, nx, ny)) break;
                        }

                        // 현재 위치: (i, j), 현재 방향: k
                        // 바로 뒤의 위치에 같은 색깔이 존재하면 6개가 되니까 실패
                        if (i-dx[k] >= 0 && i-dx[k] < n && j-dy[k] >= 0 && j-dy[k] < n) {
                            if (a[i-dx[k]][j-dy[k]] == now) continue;
                        }

                        if (count == 5) {
                            sb.append(now).append("\n").append(i+1).append(" ").append(j+1);
                            System.out.println(sb.toString());
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }

    private static boolean isOutOfRange(int i, int j, int nx, int ny) {
        return i + nx < 0 || i + nx >= n || j + ny < 0 || j + ny >= n;
    }
}