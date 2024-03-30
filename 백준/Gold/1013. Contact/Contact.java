import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            verifyPattern();
        }
        System.out.println(sb);
    }

    private static void verifyPattern() throws IOException {
        String input = br.readLine();
        if (input.matches("(100+1+|01)+")) {
            sb.append("YES").append("\n");
        } else {
            sb.append("NO").append("\n");
        }
    }
}