import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final String ENTER = "ENTER";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), result = 0;
        Map<String, Integer> enterCount = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            if (ENTER.equals(name)) {
                enterCount.clear();
            } else {
                enterCount.put(name, enterCount.getOrDefault(name, 0) + 1);
            }

            if (enterCount.getOrDefault(name, 0) == 1) {
                result++;
            }
        }

        System.out.println(result);
    }
}