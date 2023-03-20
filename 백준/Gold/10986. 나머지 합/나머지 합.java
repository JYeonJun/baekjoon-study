import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] sum = new long[N + 1];
        long[] remain = new long[M];

        long result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {

            sum[i] = (sum[i - 1] + Integer.parseInt(st.nextToken())) % M;
            remain[(int) sum[i]]++;

            if (sum[i] == 0) {
                result++;
            }
        }

        for (int i = 0; i < M; i++) {
            if (remain[i] > 1) {
                result += (remain[i] * (remain[i] - 1)) / 2;
            }
        }

        System.out.println(result);
    }
}
