import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] DY = {0, -1, -1, -1, 0, 1, 1, 1}, DX = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static final int[] DIAGONAL_Y = {-1, -1, 1, 1}, DIAGONAL_X = {-1, 1, 1, -1};
    private static final List<Pos> CLOUDS = new LinkedList<>();
    private static final List<Integer> DIAGONAL_COUNT = new LinkedList<>();


    private static int N, M;
    private static int[][] matrix;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        initMatrix();

        initCloudsPos();

        simulate();

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += matrix[i][j];
            }
        }
        System.out.println(sum);
    }

    private static void simulate() throws IOException {
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int moveCount = Integer.parseInt(st.nextToken());
            boolean[][] preClouds = new boolean[N][N];

            // dir과 moveCount값을 토대로 구름 위치 이동!!
            // 그리고 해당 위치에 값 증가
            moveClouds(dir, moveCount, preClouds);

            // 물복사버그 마법 시전
            // clouds 순서대로 대각선 방향에 개수 구하고 배열에 넣어두기 그러고 다시 배열 돌면서 변경하기
            waterCopyBug();

            // 구름 위치랑 대각선 개수 리스트 초기화
            CLOUDS.clear();
            DIAGONAL_COUNT.clear();

            // 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양 2 줄이기
            // 단, 3에서 구름이 사라진 칸이 아니어야 한다.
            generateNewClouds(preClouds);
        }
    }

    private static void generateNewClouds(boolean[][] preClouds) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] >= 2 && !preClouds[i][j]) {
                    // CLOUD에 새로 넣어야 하는데 넣을 수도 없고 흠..
                    CLOUDS.add(new Pos(i, j));
                    matrix[i][j] -= 2;
                }
            }
        }
    }

    private static void waterCopyBug() {
        for (Pos cloud : CLOUDS) {
            int cy = cloud.y;
            int cx = cloud.x;

            int count = countDiagonalWater(cy, cx);

            DIAGONAL_COUNT.add(count);
        }

        for (int i = 0; i < CLOUDS.size(); i++) {
            Pos cloud = CLOUDS.get(i);
            matrix[cloud.y][cloud.x] += DIAGONAL_COUNT.get(i);
        }
    }

    private static int countDiagonalWater(int cy, int cx) {
        int count = 0;
        for (int i = 0; i < DIAGONAL_Y.length; i++) {
            int ny = cy + DIAGONAL_Y[i];
            int nx = cx + DIAGONAL_X[i];

            if (!isOutOfMatrix(ny, nx) && matrix[ny][nx] > 0) {
                count++;
            }
        }
        return count;
    }

    private static void moveClouds(int dir, int moveCount, boolean[][] preClouds) {
        for (Pos cloud : CLOUDS) {
            int ny = ((cloud.y + DY[dir - 1] * moveCount) % N + N) % N;
            int nx = ((cloud.x + DX[dir - 1] * moveCount) % N + N) % N;
            preClouds[ny][nx] = true;
            cloud.changePos(ny, nx);
            matrix[ny][nx]++;
        }
    }

    private static void initCloudsPos() {
        CLOUDS.add(new Pos(N - 2, 0));
        CLOUDS.add(new Pos(N - 2, 1));
        CLOUDS.add(new Pos(N - 1, 0));
        CLOUDS.add(new Pos(N - 1, 1));
    }

    private static void initMatrix() throws IOException {
        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static boolean isOutOfMatrix(int ny, int nx) {
        return ny < 0 || ny >= N || nx < 0 || nx >= N;
    }

    private static class Pos {
        private int y, x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public void changePos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}