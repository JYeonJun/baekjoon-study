import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int K;
    private static int totalNodeCnt;
    private static int[] visitedOrder;
    private static StringBuilder[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        totalNodeCnt = (int) Math.pow(2, K) - 1;
        visitedOrder = new int[totalNodeCnt];

        StringTokenizer st = new StringTokenizer(br.readLine());
        tree = new StringBuilder[K];

        for (int i = 0; i < K; i++) {
            tree[i] = new StringBuilder();
        }

        for (int i = 0; i < totalNodeCnt; i++) {
            visitedOrder[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, totalNodeCnt - 1, 0);

        for (int i = 0; i < K; i++) {
            StringBuilder sb = tree[i];
            System.out.println(sb.toString());
        }
    }

    private static void dfs(int start, int end, int level) {

        if (level == K) {
            return;
        }

        int medium = (start + end) / 2;
        tree[level].append(visitedOrder[medium] + " ");

        dfs(start, medium - 1, level + 1);
        dfs(medium + 1, end, level + 1);
    }
}