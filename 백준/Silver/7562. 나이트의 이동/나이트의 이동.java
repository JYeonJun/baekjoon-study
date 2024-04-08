import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] deltaY = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static final int[] deltaX = {1, 2, 2, 1, -1, -2, -2, -1};
    private static boolean[][] visited;
    private static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];

            Position startPos = readPosition(br);
            Position targetPos = readPosition(br);
            sb.append(bfs(startPos, targetPos)).append("\n");
        }

        System.out.println(sb);
    }

    private static int bfs(Position startPos, Position targetPos) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(startPos);
        visited[startPos.y][startPos.x] = true;

        while (!queue.isEmpty()) {
            Position currentPos = queue.poll();

            if (currentPos.y == targetPos.y && currentPos.x == targetPos.x) {
                return currentPos.moveCount;
            }

            for (int i = 0; i < deltaY.length; i++) {
                int ny = currentPos.y + deltaY[i];
                int nx = currentPos.x + deltaX[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx]) {
                    queue.add(new Position(ny, nx, currentPos.moveCount + 1));
                    visited[ny][nx] = true;
                }
            }
        }

        return -1; // 이론적으로 도달할 수 없는 코드
    }

    private static Position readPosition(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        return new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
    }

    private static class Position {
        private int y, x, moveCount;

        public Position(int y, int x, int moveCount) {
            this.y = y;
            this.x = x;
            this.moveCount = moveCount;
        }
    }
}
