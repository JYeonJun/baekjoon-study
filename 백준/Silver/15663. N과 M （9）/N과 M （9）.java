import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    private static int[] nums;
    private static LinkedHashSet<String> result = new LinkedHashSet<>();
    private static boolean[] checked;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        checked = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums); // 수열 정렬 추가

        dfs(0, "");
        result.forEach(System.out::println);
        br.close();
    }

    private static void dfs(int depth, String str) {
        if (depth == M) {
            result.add(str.trim());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!checked[i]) {
                checked[i] = true;
                dfs(depth + 1, str + nums[i] + " ");
                checked[i] = false;
            }
        }
    }
}
