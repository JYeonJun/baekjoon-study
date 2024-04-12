import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = Integer.MAX_VALUE;
    private static final int[] DY = {-1, 1, 0, 0}, DX = {0, 0, -1, 1}; // 상, 하, 좌, 우

    private static int N;
    private static int[][] rupy;
    private static int[][] matrix;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 1;
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            initRupyMatrix(br);
            initDPMatrix();

            dijkstra(0, 0);
            System.out.println("Problem " + count++ + ": " + matrix[N - 1][N - 1]);
        }
    }

    private static void dijkstra(int y, int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][N];
        pq.add(new Node(y, x, rupy[y][x]));
        visited[y][x] = true;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int cy = current.y;
            int cx = current.x;
            if(cy == N - 1 && cx == N - 1) return;

            for (int i = 0; i < DY.length; i++) {
                int ny = cy + DY[i];
                int nx = cx + DX[i];

                if (isOutOfMatrix(ny, nx) || visited[ny][nx]) {
                    continue;
                }

                int tmpWeight = matrix[cy][cx] + rupy[ny][nx];
                if (matrix[ny][nx] >= tmpWeight) {
                    matrix[ny][nx] = tmpWeight;
                    pq.add(new Node(ny, nx, tmpWeight));
                    visited[ny][nx] = true;
                }
            }
        }
    }

    private static void initDPMatrix() {
        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(matrix[i], INF);
        }

        matrix[0][0] = rupy[0][0];
    }

    private static void initRupyMatrix(BufferedReader br) throws IOException {
        StringTokenizer st;
        rupy = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                rupy[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static boolean isOutOfMatrix(int ny, int nx) {
        return ny < 0 || ny >= N || nx < 0 || nx >= N;
    }

    private static class Node implements Comparable<Node> {
        private int y, x, weight;

        public Node(int y, int x, int weight) {
            this.y = y;
            this.x = x;
            this.weight = weight;
        }

        public void changeWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return this.weight - node.weight;
        }
    }
}