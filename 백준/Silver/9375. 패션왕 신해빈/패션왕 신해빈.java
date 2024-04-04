import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    private static final HashMap<String, Integer> map = new HashMap<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n;

        while (T-- > 0) {
            map.clear();
            n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                map.put(input[1], map.getOrDefault(input[1], 0) + 1);
            }

            int result = 1;
            for (int value : map.values()) {
                result *= (value + 1);
            }

            System.out.println(result - 1);
        }
    }
}
