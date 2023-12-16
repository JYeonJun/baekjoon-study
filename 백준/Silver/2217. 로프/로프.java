import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long w = 0, cnt =0 ;

        long[] weight = new long[N];

        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(weight);

        for (int i = N - 1; i >= 0; i--) {
            cnt++;
            long tmp = cnt * weight[i];

            if (tmp >= w) {
                w = tmp;
            }
        }

        System.out.println(w);
    }
}