import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] < A[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                } else if (A[i] == A[j]) {
                    dp[i] = dp[j];
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}
