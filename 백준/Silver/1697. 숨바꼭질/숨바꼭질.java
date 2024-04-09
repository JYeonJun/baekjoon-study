import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, K;
    private static int[] check;
    private static final int[] step = {-1, +1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println(N - K);
            return;
        }

        check = new int[K * 2 + 1];
        bfs(N);
        System.out.println(check[K]);
    }

    private static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        check[start] = 0;

        while (!que.isEmpty()) {
            int current = que.poll();

            if (current == K) {
                return;
            }
            
            for (int s : step) {
                int next = current + s;

                if (next >= 1 && next < check.length && check[next] == 0) {
                    que.add(next);
                    check[next] = check[current] + 1;
                }
            }

            int next = current * 2;

            if (next >= 1 && next < check.length && check[next] == 0) {
                que.add(next);
                check[next] = check[current] + 1;
            }
        }
    }
}