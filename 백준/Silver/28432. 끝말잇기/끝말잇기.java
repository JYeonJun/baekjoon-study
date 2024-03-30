import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static String[] inputs;
    private static int N, M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String startChar = "";
        String endChar = "";

        N = Integer.parseInt(br.readLine());
        inputs = new String[N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            inputs[i] = input;
        }

        for (int i = 0; i < N; i++) {
            if (inputs[i].equals("?")) {
                if (i > 0) {
                    String preInput = inputs[i - 1];
                    startChar = preInput.substring(preInput.length() - 1);
                }
                if (i < N - 1) {
                    endChar = inputs[i + 1].substring(0, 1);
                }
                break;
            }
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (input.startsWith(startChar) && input.endsWith(endChar) && !isContains(input)) {
                System.out.println(input);
                return;
            }
        }
    }

    private static boolean isContains(String str) {
        for (int i = 0; i < N; i++) {
            if (inputs[i].equals(str)) return true;
        }
        return false;
    }
}
