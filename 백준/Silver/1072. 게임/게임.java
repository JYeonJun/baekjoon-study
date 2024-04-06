import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());

        long Z = (Y * 100 / X);

        if (Z == 99 || Z == 100) {
            System.out.println(-1);
            return;
        }

        long left = 0, right = X, mid, min = Long.MAX_VALUE, avg;

        while (left <= right) {
            mid = (left + right) / 2;
            avg = ((Y + mid) * 100 / (X + mid));
            if (Z < avg) {
                min = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(min);
    }
}