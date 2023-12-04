import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        long[] visitCnt = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visitCnt[i] = Integer.parseInt(st.nextToken());
        }

        long maxVisit = 0, sum = visitCnt[0];
        long maxCnt = 1;

        for (int i = 1; i < X; i++) {
            sum += visitCnt[i];
        }

        maxVisit = sum;

        for (int i = 1; i <= N - X; i++) {

            sum -= visitCnt[i - 1];
            sum += visitCnt[i + X - 1];

            if (sum > maxVisit) {
                maxCnt = 1;
                maxVisit = sum;
            } else if (sum == maxVisit) {
                maxCnt++;
            }
        }

        if (maxVisit == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxVisit);
            System.out.println(maxCnt);
        }
    }
}
