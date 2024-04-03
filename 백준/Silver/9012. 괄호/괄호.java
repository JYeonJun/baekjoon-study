import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < T; i++) {
            if (solve(br.readLine())) {
                result.append("YES\n");
            } else {
                result.append("NO\n");
            }
        }

        System.out.print(result);
    }

    private static boolean solve(String input) {
        int balance = 0;

        for (char c : input.toCharArray()) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
                if (balance < 0) {
                    return false;
                }
            }
        }

        return balance == 0;
    }
}