import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static long[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1 <= N <= 90
        int N = Integer.parseInt(br.readLine());

        dp = new long[N + 2];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        System.out.println(pinaryNumber(N));
    }

    private static long pinaryNumber(int n) {

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}