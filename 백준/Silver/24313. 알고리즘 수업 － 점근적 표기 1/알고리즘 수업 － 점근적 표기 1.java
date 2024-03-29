import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int a0, a1, c, n0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a1 = Integer.parseInt(st.nextToken()); a0 = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(br.readLine()); n0 = Integer.parseInt(br.readLine());

        int result = 1;
        for (int i = n0; i <= 100; i++) {
            if (f(i) > c * i) result = 0;
        }
        System.out.println(result);
    }

    private static int f(int n) {
        return a1 * n + a0;
    }
}