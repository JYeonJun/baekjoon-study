import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int LNF = Integer.MAX_VALUE;

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1 + 6];

        dp[0] = LNF;
        dp[1] = LNF;
        dp[2] = 1;
        dp[3] = LNF;
        dp[4] = 2;
        dp[5] = 1;

        for (int i = 6; i <= n; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 5]) + 1;
        }

        System.out.println(dp[n] == LNF ? -1 : dp[n]);
        br.close();
    }
}
