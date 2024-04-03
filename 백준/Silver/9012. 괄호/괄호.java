import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class Main {

    private static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < T; i++) {
            if (solve(br.readLine())) {
                result.append("YES");
            } else {
                result.append("NO");
            }
            result.append("\n");
        }

        System.out.println(result);
    }

    private static boolean solve(String input) {
        stack.clear();

        try {
            for (char c : input.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }
        } catch (EmptyStackException e) {
            return false;
        }

        return stack.isEmpty();
    }
}