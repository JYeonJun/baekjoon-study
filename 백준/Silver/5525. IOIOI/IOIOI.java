import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int N, M;
    private static String S;
    private static final String[] IO = {"I", "O"};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 2 * N + 1; i++) {
            sb.append(IO[i % 2]);
        }

        String str = sb.toString();
        int count = 0;
        for (int i = 0; i <= M - 2 * N - 1; i++) {
            String substring = S.substring(i, i + 2 * N + 1);
            if (substring.equals(str)) count++;
        }

        if (S.substring(M - 2 * N).equals(str)) count++;

        System.out.println(count);
    }
}