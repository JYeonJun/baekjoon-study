import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> extentions = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("\\.");
            extentions.put(line[1], extentions.getOrDefault(line[1], 0) + 1);
        }

        extentions.keySet().stream()
                .sorted()
                .forEach(e -> sb.append(e + " " + extentions.get(e) + "\n"));

        System.out.println(sb);
    }
}