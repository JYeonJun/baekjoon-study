import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final int BOARD_LEN = 19;
    private static final int[][] board = new int[BOARD_LEN + 1][BOARD_LEN + 1];
    private static int[] dy = {0, 1, 1, 1}, dx = {1, 1, 0, -1}; // 우, 우하, 하, 좌하
    private static final PriorityQueue<Pos> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 1; i <= BOARD_LEN; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= BOARD_LEN; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= BOARD_LEN; i++) {
            for (int j = 1; j <= BOARD_LEN; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                for (int k = 0; k < dy.length ; k++) {
                    pq.clear();
                    pq.add(new Pos(i, j));
                    int ny = i + dy[k];
                    int nx = j + dx[k];

                    if (isOutOfArrayIndex(ny, nx)) continue;

                    int omogCount = 1;
                    while (board[ny][nx] == board[i][j]) {
                        pq.add(new Pos(ny, nx));
                        omogCount++;
                        ny += dy[k];
                        nx += dx[k];
                        if (isOutOfArrayIndex(ny, nx)) break;
                    }

                    int preY = i - dy[k];
                    int preX = j - dx[k];
                    if (!isOutOfArrayIndex(preY, preX) && board[preY][preX] == board[i][j]) {
                        continue;
                    }
                    if (omogCount == 5) {
                        Pos pos = pq.poll();
                        System.out.println(board[i][j]);
                        System.out.println(pos.y + " " + pos.x);
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }

    private static boolean isOutOfArrayIndex(int y, int x) {
        return y <= 0 || y > BOARD_LEN || x <= 0 || x > BOARD_LEN;
    }

    private static class Pos implements Comparable<Pos>{
        private int y, x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(Pos pos) {
            if (this.x == pos.x) {
                return this.y - pos.y;
            }
            return this.x - pos.x;
        }
    }
}