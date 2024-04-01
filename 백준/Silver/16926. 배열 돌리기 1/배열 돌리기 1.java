import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M, R;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        fillArr();

        for (int t = 0; t < R; t++) {
            int depth = 0;
            while (depth < N / 2 && depth < M / 2) {

                int bottomLeft = arr[N - depth - 1][depth];
                int bottomRight = arr[N - depth - 1][M - depth - 1];
                int topRight = arr[depth][M - depth - 1];
                int tmp = arr[depth][depth];
                for (int i = depth; i < N - depth - 1; i++) {
                    int nextTmp = arr[i + 1][depth];
                    arr[i + 1][depth] = tmp;
                    tmp = nextTmp;
                }

                tmp = arr[N - depth - 1][depth + 1];
                for (int j = depth + 1; j < M - depth - 1; j++) {
                    int nextTmp = arr[N - depth - 1][j + 1];
                    arr[N - depth - 1][j + 1] = tmp;
                    tmp = nextTmp;
                }
                arr[N - depth - 1][depth + 1] = bottomLeft;

                tmp = arr[N - depth - 2][M - depth - 1];
                for (int i = N - depth - 2; i > depth; i--) {
                    int nextTmp = arr[i - 1][M - depth - 1];
                    arr[i - 1][M - depth - 1] = tmp;
                    tmp = nextTmp;
                }
                arr[N - depth - 2][M - depth - 1] = bottomRight;

                tmp = arr[depth][M - depth - 2];
                for (int j = M - depth - 2; j > depth; j--) {
                    int nextTmp = arr[depth][j - 1];
                    arr[depth][j - 1] = tmp;
                    tmp = nextTmp;
                }
                arr[depth][M - depth - 2] = topRight;

                depth++;
            }
        }

        printArr();
    }

    private static void printArr() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void fillArr() throws IOException {
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
