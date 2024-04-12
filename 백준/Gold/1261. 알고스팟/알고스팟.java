import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DY = {-1, 1, 0, 0}, DX = {0, 0, -1, 1}; // 상하좌우
    private static final int INF = Integer.MAX_VALUE;
    private static final int SPACE = 0, WALL = 1;

    private static int N, M;
    private static int[][] matrix;
    private static int[][] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        initMatrix(br); // 미로 초기화
        initResultMatrix(); // 결과 저장하는 미로 초기화

        dijkstra(0, 0);

        System.out.println(result[N - 1][M - 1]);
    }

    private static void dijkstra(int y, int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][M];
        pq.add(new Node(y, x, result[y][x]));
        visited[y][x] = true;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int cy = current.y;
            int cx = current.x;

            for (int i = 0; i < DY.length; i++) {
                int ny = cy + DY[i];
                int nx = cx + DX[i];

                if (isOutOfMatrix(ny, nx) || visited[ny][nx]) {
                    continue;
                }

                int tmpWeight = result[cy][cx] + matrix[ny][nx];
                if (result[ny][nx] >= tmpWeight) {
                    result[ny][nx] = tmpWeight;
                    pq.add(new Node(ny, nx, tmpWeight));
                    visited[ny][nx] = true;
                }
            }
        }
    }

    private static boolean isOutOfMatrix(int ny, int nx) {
        return ny < 0 || ny >= N || nx < 0 || nx >= M;
    }

    private static void initResultMatrix() {
        result = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(result[i], INF);
        }

        result[0][0] = 0;
    }

    private static void initMatrix(BufferedReader br) throws IOException {
        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }
    }

    private static class Node implements Comparable<Node>{
        private int y, x, weight;

        public Node(int y, int x, int weight) {
            this.y = y;
            this.x = x;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return this.weight - node.weight;
        }
    }
}