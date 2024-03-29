import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dfs(0, "",  new boolean[N + 1]);
        System.out.print(sb.toString());
        br.close();
    }

    private static void dfs(int depth, String result, boolean[] checked) {
        if (depth == M) {
            sb.append(result.trim()).append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!checked[i]) {
                checked[i] = true;
                dfs(depth + 1, result + i + " ", Arrays.copyOf(checked, checked.length));
            }
        }
    }
}