import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long[] times = new long[(int) N];

        long min = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            times[i] = Long.parseLong(br.readLine());
            min = Math.min(min, times[i]);
        }

        long start = min, end = min * M, mid = 0, sum = 0, result = Long.MAX_VALUE;
        while (start <= end) {
            mid = (start + end) / 2;

            sum = 0;
            for (int i = 0; i < N; i++) {
                sum += mid / times[i];
            }

            if (sum < M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }
}