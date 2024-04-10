import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final int HEIGHT = 12, WIDTH = 6, BOMB_COUNT = 4;
    private static final int[] DY = {-1, 0, 1, 0}, DX = {0, 1, 0, -1};
    private static final char[][] MATRIX = new char[HEIGHT][WIDTH];
    private static boolean[][] visited = new boolean[HEIGHT][WIDTH];
    private static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < HEIGHT; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < WIDTH; j++) {
                MATRIX[i][j] = line[j];
            }
        }

        while (true) {
            boolean hasExploded = false;
            visited = new boolean[HEIGHT][WIDTH]; // 비효율적인 위치에서의 초기화를 수정함.

            for (int i = HEIGHT - 1; i >= 0; i--) {
                for (int j = 0; j < WIDTH; j++) {
                    if (MATRIX[i][j] != '.' && !visited[i][j]) {
                        if (bfs(i, j) >= BOMB_COUNT) {
                            hasExploded = true;
                        }
                    }
                }
            }

            if (!hasExploded) {
                break;
            }

            // 그리고 아래가 '.'인 것들 전부 아래로 내려야함.
            for (int col = 0; col < WIDTH; col++) {
                for (int row = HEIGHT - 1; row >= 0; row--) {
                    if (MATRIX[row][col] == '.') {
                        for (int aboveRow = row - 1; aboveRow >= 0; aboveRow--) {
                            if (MATRIX[aboveRow][col] != '.') {
                                MATRIX[row][col] = MATRIX[aboveRow][col];
                                MATRIX[aboveRow][col] = '.';
                                break;
                            }
                        }
                    }
                }
            }

            count++;
        }

        System.out.println(count);
    }

    private static int bfs(int y, int x) {
        Queue<Pos> que = new LinkedList<>();
        int count = 0;
        que.add(new Pos(y, x));
        visited[y][x] = true;
        boolean[][] tmpVisited = new boolean[HEIGHT][WIDTH];
        tmpVisited[y][x] = true;

        while (!que.isEmpty()) {
            Pos current = que.poll();
            int cy = current.y;
            int cx = current.x;
            count++;

            for (int i = 0; i < DY.length; i++) {
                int ny = cy + DY[i];
                int nx = cx + DX[i];

                if (isOutOfMatrix(ny, nx) || MATRIX[ny][nx] == '.' || MATRIX[cy][cx] != MATRIX[ny][nx] || visited[ny][nx]) {
                    continue;
                }

                que.add(new Pos(ny, nx));
                visited[ny][nx] = true;
                tmpVisited[ny][nx] = true;
            }
        }

        if (count >= BOMB_COUNT) {
            for (int i = 0; i < HEIGHT; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    if (tmpVisited[i][j]) {
                        MATRIX[i][j] = '.'; // 터진 뿌요 바로 '.'으로 변경하는 로직 제거
                    }
                }
            }
        }

        return count;
    }

    private static boolean isOutOfMatrix(int ny, int nx) {
        return ny < 0 || ny >= HEIGHT || nx < 0 || nx >= WIDTH;
    }

    private static class Pos {
        private int y, x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}