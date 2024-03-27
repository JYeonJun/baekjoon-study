import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1, k = N - 1; i <= N; i++, k--) {
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            for (int j = 0; j < k; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < k; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        for (int i = N - 1, k = 1; i > 0; i--, k++) {
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            for (int j = 0; j < k; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < k; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}