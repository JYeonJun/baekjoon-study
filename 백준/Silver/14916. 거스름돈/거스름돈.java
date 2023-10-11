import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int NOPE = Integer.MAX_VALUE - 100_000;

        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[n + 1 + 6];

        cnt[0] = NOPE;
        cnt[1] = NOPE;
        cnt[2] = 1;
        cnt[3] = NOPE;
        cnt[4] = 2;
        cnt[5] = 1;

        for (int i = 6; i <= n; i++) {

            cnt[i] = Math.min(cnt[i - 2], cnt[i - 5]) + 1;
        }

        if (cnt[n] >= NOPE) {
            System.out.println(-1);
        } else {
            System.out.println(cnt[n]);
        }
    }
}
