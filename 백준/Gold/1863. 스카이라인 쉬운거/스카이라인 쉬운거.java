import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (y == 0) {
                result += stack.size();
                stack.clear();
                continue;
            }

            if (stack.isEmpty()) {
                stack.push(y);
                continue;
            }

            int peekNum = stack.peek();
            if (y > peekNum) {
                stack.push(y);
                continue;
            } else if (y == peekNum) {
                continue;
            }

            while (!stack.isEmpty()) {
                int num = stack.peek();
                if (num > y) {
                    result++;
                    stack.pop();

                    if (stack.isEmpty()) {
                        stack.push(y);
                    }

                } else if (num == y) {
                    break;
                } else { // num < y
                    stack.push(y);
                    break;
                }
            }
        }

        result += stack.size();
        System.out.println(result);
    }
}