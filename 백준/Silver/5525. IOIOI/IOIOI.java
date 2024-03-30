import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int N, M;
    private static String S;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine();

        int count = 0;
        int subCount = 0;
        for (int i = 0; i < M; i++) {

            if (S.startsWith("IOI", i)) {
                subCount++;
                if (subCount == N) {
                    count++;
                    subCount--;
                }
                i++;
            } else {
                subCount = 0;
            }
        }

        System.out.println(count);
    }
}