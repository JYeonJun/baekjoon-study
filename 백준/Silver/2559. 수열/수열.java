import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] temp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }

        int tmp = 0;

        for (int i = 0; i < K; i++) {
            tmp += temp[i];
        }

        int max = tmp;

        for (int i = 1; i <= N - K; i++) {

            tmp -= temp[i - 1];
            tmp += temp[i + K - 1];

            if (tmp > max) {
                max = tmp;
            }
        }

        System.out.println(max);
    }
}