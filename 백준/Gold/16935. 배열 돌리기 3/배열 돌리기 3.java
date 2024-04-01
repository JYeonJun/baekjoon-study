import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] arr;
    private static int N, M, R, calNum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            while (st.hasMoreTokens()) {
                calNum = Integer.parseInt(st.nextToken());
                switch (calNum) {
                    case 1:
                        one();
                        break;
                    case 2:
                        two();
                        break;
                    case 3:
                        three();
                        break;
                    case 4:
                        four();
                        break;
                    case 5:
                        five();
                        break;
                    case 6:
                        six();
                        break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void one() {
        int tmp;
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M; j++) {
                tmp = arr[N - i - 1][j];
                arr[N - i - 1][j] = arr[i][j];
                arr[i][j] = tmp;
            }
        }
    }

    private static void two() {
        int tmp;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                tmp = arr[i][M - j - 1];
                arr[i][M - j - 1] = arr[i][j];
                arr[i][j] = tmp;
            }
        }
    }

    private static void three() {
        int[][] tmp = new int[M][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[j][N - i - 1] = arr[i][j];
            }
        }

        arr = tmp;
        swapNM();
    }

    private static void four() {
        int[][] tmp = new int[M][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[M - j - 1][i] = arr[i][j];
            }
        }

        arr = tmp;
        swapNM();
    }

    private static void five() {
        int[][] fourthArr = createQuarterArr();

        // 3 -> 4 (o)
        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) {
                arr[i][j - M / 2] = arr[i][j];
            }
        }

        // 2 -> 3(o)
        for (int i = 0; i < N / 2; i++) {
            for (int j = M / 2; j < M; j++) {
                arr[i + N / 2][j] = arr[i][j];
            }
        }

        // 1 -> 2 (o)
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                arr[i][j + M / 2] = arr[i][j];
            }
        }

        // 4 -> 1
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                arr[i][j] = fourthArr[i][j];
            }
        }
    }

    private static void six() {
        int[][] fourthArr = createQuarterArr();

        // 1 -> 4
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                arr[i + N / 2][j] = arr[i][j];
            }
        }

        // 2 -> 1
        for (int i = 0; i < N / 2; i++) {
            for (int j = M / 2; j < M; j++) {
                arr[i][j - M / 2] = arr[i][j];
            }
        }

        // 3 -> 2
        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) {
                arr[i - N / 2][j] = arr[i][j];
            }
        }

        // 4 -> 3
        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) {
                arr[i][j] = fourthArr[i - N / 2][j - M / 2];
            }
        }
    }

    private static int[][] createQuarterArr() {
        int[][] quarter = new int[N / 2][M / 2];

        for (int i = N / 2, qi = 0; i < N; i++, qi++) {
            for (int j = 0, qj = 0; j < M / 2; j++, qj++) {
                quarter[qi][qj] = arr[i][j];
            }
        }

        return quarter;
    }

    private static void swapNM() {
        int tmp = M;
        M = N;
        N = tmp;
    }
}