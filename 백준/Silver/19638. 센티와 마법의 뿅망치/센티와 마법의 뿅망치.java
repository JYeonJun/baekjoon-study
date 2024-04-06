import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int sentiHeight = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        while (N-- > 0) {
            pq.add(Integer.valueOf(br.readLine()));
        }

        int count = 0;
        while (!pq.isEmpty() && limit > 0) {
            int height = pq.poll();
            if (height < sentiHeight) {
                pq.add(height);
                break;
            }
            if (height > 1) {
                height = height / 2;
                pq.add(height);
                count++;
                limit--;
            } else {
                // 키가 1인 거인은 다시 추가하지 않음
                break;
            }
        }
        
        int highest = pq.isEmpty() ? 1 : pq.peek();
        if (highest < sentiHeight) {
            System.out.println("YES");
            System.out.println(count);
        } else {
            System.out.println("NO");
            System.out.println(highest);
        }
    }
}
