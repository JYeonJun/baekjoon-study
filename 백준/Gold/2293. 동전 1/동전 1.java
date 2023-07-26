import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] value = new int[n];
        int[][] dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < k + 1; i++) {

            for (int j = 0; j < n; j++) {
                int cur = value[j];
                if (cur == i) {
                    dp[j][i] = 1;
                } else if (i > cur) {
                    for (int q = 0; q <= j; q++) {
                        dp[j][i] += dp[q][i - cur];
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += dp[i][k];
        }

        System.out.println(result);
    }
}
