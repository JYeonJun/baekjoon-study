import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int SPACE = 0, WALL = 1, INACTIVE = 2;
    private static int N, M, result = Integer.MAX_VALUE, originSpaceCount = 0;
    private static int[][] matrix;
    private static ArrayList<Pos> viruses = new ArrayList<>();
    private static Pos[] selectedViruses;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N][N];
        selectedViruses = new Pos[M];

        initMatrix(br);

        if (originSpaceCount == 0) {
            System.out.println(0);
            return;
        }

        // 활성 바이러스 선택하기
        selectViruses(0, 0);

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static void selectViruses(int start, int depth) {
        if (depth == M) {
            spreadVirus(originSpaceCount);
            return;
        }

        for (int i = start; i < viruses.size(); i++) {
            selectedViruses[depth] = viruses.get(i);
            selectViruses(i + 1, depth + 1);
        }
    }

    private static void spreadVirus(int spaceCount) {
        Queue<Pos> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        for (Pos virus : selectedViruses) {
            queue.add(virus);
            visited[virus.y][virus.x] = true;
        }

        int time = 0;
        while (!queue.isEmpty()) {
            Pos current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = current.y + dy[i];
                int nx = current.x + dx[i];

                if (isInOfMatrix(ny, nx) && !visited[ny][nx] && matrix[ny][nx] != WALL) {
                    // 바이러스가 퍼질 수 있는 조건을 확인 (빈 칸이거나 비활성 바이러스인 경우)
                    if (matrix[ny][nx] == SPACE) { // 빈 칸인 경우에만 spaceCount 감소
                        spaceCount--;
                    }

                    if (spaceCount == 0) {
                        result = Math.min(result, current.time + 1);
                        return;
                    }
                    queue.add(new Pos(ny, nx, current.time + 1));
                    visited[ny][nx] = true;
                }
            }
        }
    }

    private static void initMatrix(BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if (matrix[i][j] == SPACE) {
                    originSpaceCount++;
                }
                if (matrix[i][j] == INACTIVE) {
                    viruses.add(new Pos(i, j, 0));
                }
            }
        }
    }

    private static boolean isInOfMatrix(int ny, int nx) {
        return ny >= 0 && ny < N && nx >= 0 && nx < N;
    }

    private static class Pos {
        int y, x, time;

        public Pos(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }
}