import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
    private static final int SPACE = 0, CHEESE = 1;

    private static int height, width, lastCheeseCount = 0, totalCheese = 0;
    private static int[][] matrix;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        matrix = new int[height][width];
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if (matrix[i][j] == CHEESE) totalCheese++;
            }
        }

        int hourCount = 0;
        while (totalCheese > 0) {
            visited = new boolean[height][width];
            lastCheeseCount = totalCheese; // 마지막 치즈 개수 업데이트
            bfs();
            hourCount++;
        }

        System.out.println(hourCount);
        System.out.println(lastCheeseCount);
    }

    private static void bfs() {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Pos current = queue.poll();

            for (int i = 0; i < dy.length; i++) {
                int ny = current.y + dy[i];
                int nx = current.x + dx[i];

                if (nx >= 0 && ny >= 0 && nx < width && ny < height && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    if (matrix[ny][nx] == SPACE) {
                        queue.add(new Pos(ny, nx));
                    } else if (matrix[ny][nx] == CHEESE) {
                        matrix[ny][nx] = SPACE; // 치즈 녹이기
                        totalCheese--; // 전체 치즈 개수 감소
                    }
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