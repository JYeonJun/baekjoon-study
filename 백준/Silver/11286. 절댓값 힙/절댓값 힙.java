import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    private static PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {
        int abs1 = Math.abs(n1);
        int abs2 = Math.abs(n2);
        if (abs1 == abs2) {
            return n1 - n2;
        }
        return abs1 - abs2;
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            processInput(x, result);
        }

        System.out.println(result);
    }

    private static void processInput(int x, StringBuilder result) {
        if (x != 0) {
            pq.add(x);
            return;
        }
        appendResultOrZero(result);
    }

    private static void appendResultOrZero(StringBuilder result) {
        if (pq.isEmpty()) {
            result.append("0\n");
            return;
        }
        result.append(pq.poll()).append("\n");
    }
}
