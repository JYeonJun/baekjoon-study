import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] buildings;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        int[] count = new int[N + 1];
        int[] closest = new int[N + 1];
        
        // 왼쪽에서 오른쪽으로 가며 볼 수 있는 건물 탐색
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= N; i++) {
            while (!stack.isEmpty() && buildings[stack.peek()] <= buildings[i]) {
                stack.pop();
            }
            count[i] += stack.size();
            if (!stack.isEmpty()) {
                closest[i] = stack.peek();
            }
            stack.push(i);
        }
        
        // 오른쪽에서 왼쪽으로 가며 볼 수 있는 건물 탐색
        stack.clear();
        for (int i = N; i >= 1; i--) {
            while (!stack.isEmpty() && buildings[stack.peek()] <= buildings[i]) {
                stack.pop();
            }
            count[i] += stack.size();
            if (!stack.isEmpty() && (closest[i] == 0 || Math.abs(i - stack.peek()) < Math.abs(i - closest[i]))) {
                closest[i] = stack.peek();
            }
            stack.push(i);
        }

        // 결과 출력
        for (int i = 1; i <= N; i++) {
            if (count[i] == 0) {
                System.out.println(0);
            } else {
                System.out.println(count[i] + " " + closest[i]);
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        buildings = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }
    }
}
