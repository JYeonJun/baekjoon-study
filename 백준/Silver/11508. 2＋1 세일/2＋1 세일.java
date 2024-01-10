import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> prices = new ArrayList<>();
        long result = 0;

        for (int i = 0; i < N; i++) {
            prices.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(prices, Collections.reverseOrder());

        while (true) {
            if (prices.size() < 3) {
                break;
            }

            Integer p1 = prices.remove(0);
            Integer p2 = prices.remove(0);
            Integer p3 = prices.remove(0);

            result += p1 + p2;
        }

        while (prices.size() > 0) {
            Integer price = prices.remove(0);
            result += price;
        }

        System.out.println(result);
    }
}
