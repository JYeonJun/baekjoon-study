import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            long result = 0;
            int K = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                pq.add(Long.valueOf(st.nextToken()));
            }
            while (pq.size() > 1) {
                long num1 = pq.poll();
                long num2 = pq.poll();
                long sum = num1 + num2;
                result += sum;
                pq.add(sum);
            }

            System.out.println(result);
        }
    }
}