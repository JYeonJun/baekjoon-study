import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지 구하기
public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
    private static final int SPACE = 0, SHARK_POS = 9;

    private static StringTokenizer st;
    private static int[][] matrix;
    private static int N, sharkSize = 2, eatCount = 0, sharkY, sharkX, moveCount = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); // (2 <= N <= 20)
        initMatrix();

        bfs();

        System.out.println(moveCount);
    }

    private static void bfs() {
        while (true) {
            PriorityQueue<Pos> pq = new PriorityQueue<>();
            boolean[][] visited = new boolean[N][N];
            pq.add(new Pos(sharkY, sharkX, 0));
            visited[sharkY][sharkX] = true;

            boolean canGo = false;
            Pos eatFish = null; // 먹을 물고기 위치 저장 변수 추가
            while (!pq.isEmpty()) {
                Pos current = pq.poll();

                if (matrix[current.y][current.x] != SPACE && matrix[current.y][current.x] < sharkSize) {
                    eatFish = current; // 먹을 물고기 위치 업데이트
                    eatCount++;
                    moveCount += current.moveTime;
                    canGo = true;
                    break;
                }

                for (int i = 0; i < dy.length; i++) {
                    int ny = current.y + dy[i];
                    int nx = current.x + dx[i];

                    if (isOutOfMatrix(ny, nx) || visited[ny][nx] || matrix[ny][nx] > sharkSize) {
                        continue;
                    }

                    pq.add(new Pos(ny, nx, current.moveTime + 1));
                    visited[ny][nx] = true;
                }
            }

            if (!canGo) {
                break;
            }

            // 아기 상어 위치 업데이트
            if (eatFish != null) {
                sharkY = eatFish.y;
                sharkX = eatFish.x;
                matrix[sharkY][sharkX] = SPACE; // 먹은 물고기 위치를 빈 칸으로 업데이트
            }

            if (sharkSize == eatCount) {
                sharkSize++;
                eatCount = 0;
            }
        }
    }

    private static boolean isOutOfMatrix(int y, int x) {
        return y < 0 || x < 0 || y >= N || x >= N;
    }

    private static void initMatrix() throws IOException {
        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                matrix[i][j] = num;
                if (num == SHARK_POS) {
                    sharkY = i;
                    sharkX = j;
                    matrix[i][j] = SPACE;
                }
            }
        }
    }

    private static class Pos implements Comparable<Pos> {
        private int y, x, moveTime;

        public Pos(int y, int x, int moveTime) {
            this.y = y;
            this.x = x;
            this.moveTime = moveTime;
        }

        @Override
        public int compareTo(Pos other) {
            // (sharkY, sharkX)와 가장 가까운 거 오름차순!!
            if (this.moveTime == other.moveTime) {
                if (this.y == other.y) {
                    return Integer.compare(this.x, other.x);
                }

                return Integer.compare(this.y, other.y);
            }

            return Integer.compare(this.moveTime, other.moveTime);
        }
    }
}