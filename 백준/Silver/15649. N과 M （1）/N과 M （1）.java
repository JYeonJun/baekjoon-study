import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static boolean[] checked;
    private static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        checked = new boolean[N + 1];
        dfs("", 0);

        br.close();
        bw.close();
    }

    private static void dfs(String result, int count) throws IOException {
        if (count == M) {
            bw.write(result.trim() + "\n");
            sb.setLength(0);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!checked[i]) {
                checked[i] = true;
                dfs(result + " " + i, count + 1);
                checked[i] = false;
            }
        }
    }
}