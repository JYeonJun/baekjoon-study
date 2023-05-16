import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] red;
    private static int[] green;
    private static int[] blue;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        red = new int[N];
        green = new int[N];
        blue = new int[N];

        dp = new int[3][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            red[i] = Integer.parseInt(st.nextToken());
            green[i] = Integer.parseInt(st.nextToken());
            blue[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = red[0];
        dp[1][0] = green[0];
        dp[2][0] = blue[0];
        for (int i = 1; i < N; i++) {

            dp[0][i] = Math.min(dp[1][i - 1], dp[2][i - 1]) + red[i];
            dp[1][i] = Math.min(dp[0][i - 1], dp[2][i - 1]) + green[i];
            dp[2][i] = Math.min(dp[0][i - 1], dp[1][i - 1]) + blue[i];
        }

        System.out.println(findMin(dp[0][N - 1], dp[1][N - 1], dp[2][N - 1]));
    }

    public static int findMin(int a, int b, int c) {
        int min = a;

        if (b < min) {
            min = b;
        }

        if (c < min) {
            min = c;
        }

        return min;
    }
}
