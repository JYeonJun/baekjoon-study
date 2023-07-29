import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> cards = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            cards.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while (cards.size() > 1) {
            Integer first = cards.poll();
            Integer second = cards.poll();
            
            int sum = first + second;
            cards.add(sum);
            result += sum;
        }

        System.out.println(result);
    }
}
