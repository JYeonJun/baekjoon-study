import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] sum = new int[N + 1];

        sum[0] = 0;

        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + i;
        }

        int result = 0;

        // sum[i] - sum[j] : j + 1에서 i까지의 합
        for (int i = 0; i <= N - 1; i++) {
            for (int j = i + 1; j <= N; j++) {
                
                int num = sum[j] - sum[i];
                if (num == N) {
                    result++;
                } else if (num > N) {
                    break;
                }
            }
        }

        System.out.println(result);
    }
}